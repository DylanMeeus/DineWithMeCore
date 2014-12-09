package net.itca.dwm.data;

import java.sql.ResultSet;
import java.sql.Statement;

import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;
import net.itca.dwm.interfaces.DataService;

/**
 * Database extension for dealing with the user system (Logging in, creating users).
 * @author Dylan
 *
 */
public class UserService extends Database implements DataService
{

	/**
	 * Checks whether or not a given username exists.
	 * @param username
	 * @return
	 */
	private boolean usernameExists(String username)
	{

		// check if user exists
		try
		{
			String getUsername = "select * from users where username='"
					+ username + "';";
			System.out.println("SQL: " + getUsername);
			Statement getUserStatement = connection.createStatement();
			ResultSet getUserResults = getUserStatement.executeQuery(getUsername);
			while (getUserResults.next())
			{
				if((getUserResults.getString("username").equals(username)))
				{
//					throw new DatabaseException("Username already in database!");
					return true;
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * Creates a user based on the given parameters.
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @return
	 * @throws DatabaseException
	 * @throws PasswordException
	 */
	public boolean createUser(String username, String firstname, String lastname, String password) throws DatabaseException, PasswordException
	{
		boolean succes = false;
		try
		{
			openConnection();
			if(!usernameExists(username))
			{
				String createString = "insert into users(username,firstname,lastname,password) values('" + username
						+ "','" + firstname + "','" + lastname + "','" + password +  "');";
				System.out.println("SQL: " + createString);
				Statement createStatement = connection.createStatement();
				int affectedRows = createStatement.executeUpdate(((createString)));
				if(affectedRows==1)
				{
					succes = true;
				}
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
		return succes;
	}
	

	/**
	 * Login method, username and (hashed) password have to match.
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password)
	{
		//TODO: Add salt
		boolean succes = false;
		try
		{
			openConnection();
			String loginString = "select count(username) from users where username='"
					+ username + "' and password='" + password + "'";
			System.out.println("SQL: " + loginString);
			Statement loginStatement = connection.createStatement();
			ResultSet res = loginStatement.executeQuery(((loginString)));
			while (res.next())
			{
				if (res.getShort("count") == 1)
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
	 * Returns the userID, or -1 when the user was not present in the database.
	 * @param username
	 * @return
	 */
	public int getUserID(String username)
	{
		
		int id = -1; // -1 not found
		try
		{
			openConnection();
			String getIDString = "select userid from users where username='" + username + "';";
			Statement getIDStatement = connection.createStatement();
			ResultSet results = getIDStatement.executeQuery(getIDString);
			while(results.next())
			{
				id = results.getInt("userid");
				System.out.println(id);
				return id;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		
		return id;
	}


}
