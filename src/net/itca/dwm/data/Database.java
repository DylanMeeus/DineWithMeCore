package net.itca.dwm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;
import net.itca.dwm.exceptions.UserNotFoundException;
import net.itca.dwm.interfaces.Datasource;

/**
 * 
 * @author Dylan Only database, access with JDBC.
 */
public class Database /* implements Datasource */
{
	protected Connection connection;
	protected String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	protected String dbpassword = "local";
	protected String schema = "dinewithme";

	public Database()
	{
		try
		{
			Class.forName("org.postgresql.Driver");

		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

	protected void openConnection()
	{
		try
		{
			if(connection==null)
				connection = DriverManager.getConnection(url, "postgres",dbpassword);
		
			Statement statement = connection.createStatement(); 
			statement.execute("set search_path to '" + schema + "'"); 
			statement.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	protected void closeConnection()
	{
		if (connection != null)
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	

	public boolean acceptFriend(String user, String friend)
	{
		boolean succes = false;
		try
		{
			connection = DriverManager.getConnection(url, "postgres",
					dbpassword);

			String updateFriend = "update friends set accepted='true' where username1='"
					+ user + "' and username2='" + friend + "';";
			Statement updateStatement = connection.createStatement();
			int affected = updateStatement.executeUpdate(updateFriend);
			if (affected == 1)
			{
				succes = true;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return succes;
	}

}
