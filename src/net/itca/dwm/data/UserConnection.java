package net.itca.dwm.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;

public class UserConnection extends Database
{

	public boolean usernameExists(String username)
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
	

	public boolean login(String username, String password)
	{
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


}
