package net.itca.dwm.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
