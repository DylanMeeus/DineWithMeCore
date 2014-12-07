package net.itca.dwm.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.itca.dwm.exceptions.UserNotFoundException;
import net.itca.dwm.interfaces.DataService;

/**
 * A database extension for access to the internal friend system (CRUD operations).
 * 
 * @author Dylan
 *
 */
public class FriendService extends Database implements DataService
{

	public FriendService()
	{
		super();
	}

	/**
	 * Sends a friend request to the specified friend. Returns false in case something went wrong.
	 * @param currentUserID
	 * @param friend
	 * @return
	 */
	public boolean addFriend(int currentUserID, String friend)
	{
		boolean succes = false;
		try
		{
			openConnection();

			// check if user exists
			if (!friendExists(friend))
			{
				throw new UserNotFoundException("User not found in database");
			} else
			{
				int friendID = getFriendID(friend);
				String addString = "insert into friends(user1,user2,accepted)values('"
						+ currentUserID + "','" + friendID + "',false);";
				System.out.println("SQL: " + addString);
				Statement createStatement = connection.createStatement();
				int affectedRows = createStatement.executeUpdate(((addString)));
				if (affectedRows == 1)
				{
					succes = true;
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return succes;
	}

	
	/**
	 * Returns the database ID of a friend based on the username.
	 * @param friend
	 * @return
	 * @throws Exception
	 */
	private int getFriendID(String friend) throws Exception
	{
		String selectIDString = "select userid from users where username='"
				+ friend + "';";
		Statement selectIDStatement = connection.createStatement();
		ResultSet results = selectIDStatement.executeQuery(selectIDString);
		while (results.next())
		{
			return results.getInt("userid");
		}

		return -1;
	}

	/**
	 * Checks whether or not a certain username is present in the database.
	 * @param friendname
	 * @return
	 * @throws Exception
	 */
	private boolean friendExists(String friendname) throws Exception
	{
		boolean exists = false;
		String getUsername = "select * from users where username='"
				+ friendname + "';";
		System.out.println("SQL: " + getUsername);
		Statement getUserStatement = connection.createStatement();
		ResultSet getUserResults = getUserStatement.executeQuery(getUsername);
		boolean inResultSet = false;
		while (getUserResults.next())
		{
			if ((getUserResults.getString("username").equals(friendname)))
			{
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * Gets the friend invites based on the current users ID in the database
	 * @param userID
	 * @return
	 */
	public ArrayList<String> getFriendInvites(int userID)
	{
		ArrayList<String> invites = new ArrayList<String>();
		try
		{
			openConnection();

			String inviteIDString = "select user1 from users inner join friends"
					+ " on users.userid = friends.user2 where friends.user2 = "
					+ userID + " and accepted = false";

			ArrayList<Integer> returnedIDs = new ArrayList<Integer>();
			Statement IDStatement = connection.createStatement();
			ResultSet IDSet = IDStatement.executeQuery(inviteIDString);
			System.out.println("SQL: " + inviteIDString);

			while (IDSet.next())
			{
				returnedIDs.add(IDSet.getInt("user1"));
			}

			for (int i = 0; i < returnedIDs.size(); i++)
			{
				invites.add(getUserInfoByID(returnedIDs.get(i)));
			}

		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return invites;
	}

	/**
	 * Accepts a friend request.
	 * @param currentUserID
	 * @param friendname
	 * @return
	 */
	public boolean acceptFriend(int currentUserID, String friendname)
	{
		boolean accepted = false;
		try
		{
			openConnection();
			String acceptString = "update friends set accepted = true where user1="
					+ getFriendID(friendname)
					+ " and user2="
					+ currentUserID
					+ ";";
			Statement acceptStatement = connection.createStatement();
			int affected = acceptStatement.executeUpdate(acceptString);
			if (affected == 1)
			{
				accepted = true;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		return accepted;
	}

	/**
	 * Gets the list of friends (only people whom have accepted your friend requests, or of whom you have accepted friend requests.
	 * @param currentUserID
	 * @return
	 */
	public ArrayList<String> getFriends(int currentUserID)
	{
		ArrayList<String> friends = new ArrayList<String>();
		ArrayList<Integer> friendids = new ArrayList<Integer>();
		try
		{
			openConnection();
			String getFriendsIDs = "select * from friends where (user1="
					+ currentUserID + " or user2=" + currentUserID + ") and accepted=true;";
			Statement getFriendIDStatement = connection.createStatement();
			ResultSet friendIDResults = getFriendIDStatement
					.executeQuery(getFriendsIDs);
			while (friendIDResults.next())
			{
				int user1ID = friendIDResults.getInt("user1");
				int user2ID = friendIDResults.getInt("user2");
				if (user1ID != currentUserID)
					friendids.add(user1ID);
				if (user2ID != currentUserID)
					friendids.add(user2ID);
			}

			for (int i = 0; i < friendids.size(); i++)
			{
				friends.add(getUserInfoByID(friendids.get(i)));
			}

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}

		return friends;
	}

	/**
	 * Gets username, first name and last name based on a given user ID.
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	private String getUserInfoByID(int userid) throws SQLException
	{
		String inviteString = "select username, firstname, lastname from users where userid="
				+ userid + ";";
		System.out.println("SQL: " + inviteString);
		Statement inviteStatement = connection.createStatement();
		ResultSet results = inviteStatement.executeQuery(inviteString);
		while (results.next())
		{
			String entry = results.getString("username") + " "
					+ results.getString("firstname") + " "
					+ results.getString("lastname");
			return entry;
		}
		return null;
	}
	
	/**
	 * Declines a user request by removing it from the database.
	 * @param currentUserID
	 * @param friend
	 * @return
	 * @throws Exception
	 */
	public boolean declineRequest(int currentUserID, String friend) throws Exception
	{
		
		boolean succes = false;
		try
		{
			openConnection();
			int friendID = getFriendID(friend);
			String deleteRequest = "delete from friends where user2=" + currentUserID + " and user1=" + friendID+";";
			System.out.println("SQL: " + deleteRequest);
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteRequest);
			if(affected == 1)
				succes = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return succes;
	}
}
