package net.itca.dwm.data;

import java.sql.PreparedStatement;
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

	private PreparedStatement preparedStatement;

	
	public UserService()
	{
		super();
	}
	
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
			String getUsername = "select * from users where username= ? ";
			System.out.println("SQL: " + getUsername);
			preparedStatement = connection.prepareStatement(getUsername);
			preparedStatement.setString(1, username);
			ResultSet getUserResults = preparedStatement.executeQuery();
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
				String createString = "insert into users(username,firstname,lastname,password) values(?,?,?,?);";
				System.out.println("SQL: " + createString);
				preparedStatement = connection.prepareStatement(createString);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, firstname);
				preparedStatement.setString(3, lastname);
				preparedStatement.setString(4,password);
				int affectedRows = preparedStatement.executeUpdate();
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
			String loginString = "select count(username) from users where username= ? and password = ? ";
			System.out.println("SQL: " + loginString);
			preparedStatement = connection.prepareStatement(loginString);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2,password);
			ResultSet res = preparedStatement.executeQuery();
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
