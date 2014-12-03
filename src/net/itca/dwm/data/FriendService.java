package net.itca.dwm.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.itca.dwm.exceptions.UserNotFoundException;

/**
 * A database extension for dealing with friends. Adding friends, accepting,
 * removing..
 * 
 * @author Dylan
 *
 */
public class FriendService extends Database
{

	public FriendService()
	{
		super();
	}

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
	
	
	public ArrayList<String> getFriendInvites(int userID)
	{
		ArrayList<String> invites = new ArrayList<String>();
		try
		{
			openConnection();
			
			String inviteIDString = "select user1 from users inner join friends"
					+" on users.userid = friends.user2 where friends.user2 = "+ userID + " and accepted = false";
			
			ArrayList<Integer> returnedIDs = new ArrayList<Integer>();			
			Statement IDStatement = connection.createStatement();
			ResultSet IDSet = IDStatement.executeQuery(inviteIDString); 
			System.out.println("SQL: " + inviteIDString);
			
			while(IDSet.next())
			{
				returnedIDs.add(IDSet.getInt("user1"));
			}
			
			for(int i = 0; i < returnedIDs.size(); i++)
			{
				String inviteString = "select username, firstname, lastname from users where userid="+returnedIDs.get(i)+";";
				System.out.println("SQL: " + inviteString);
				Statement inviteStatement = connection.createStatement();
				ResultSet results = inviteStatement.executeQuery(inviteString);
				while(results.next())
				{
					String entry = results.getString("username") + " " + results.getString("firstname") + " " + results.getString("lastname"); 
					invites.add(entry);
				}
			}
		
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		
		return invites;
	}
	
	
	
}
