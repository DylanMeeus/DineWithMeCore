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
public class Database implements Datasource
{
	private Connection connection;
	private String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private String dbpassword = "local";
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

	public boolean login(String username, String password)
	{
		boolean succes = false;
		try
		{
			connection = DriverManager.getConnection(url, "postgres",
					dbpassword);
			String loginString = "select count(username) from dwmusers where username='"
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

	public boolean createUser(String username, String nickname, String password) throws DatabaseException, PasswordException
	{
		boolean succes = false;
		try
		{
			connection = DriverManager.getConnection(url, "postgres",
					dbpassword);

			// check if user exists
			String getUsername = "select * from dwmusers where username='"
					+ username + "';";
			System.out.println("SQL: " + getUsername);
			Statement getUserStatement = connection.createStatement();
			ResultSet getUserResults = getUserStatement
					.executeQuery(getUsername);
			while (getUserResults.next())
			{
				if((getUserResults.getString("Username").equals(username)))
				{
					throw new DatabaseException("Username already in database!");
				}
			}

			String createString = "insert into dwmusers(username,pseudo,password) values('" + username
					+ "','" + nickname + "','" + password + "');";
			System.out.println("SQL: " + createString);
			Statement createStatement = connection.createStatement();
			int affectedRows = createStatement.executeUpdate(((createString)));
			if(affectedRows==1)
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

	public boolean addFriend(String user, String friend)
	{
		boolean succes = false;
		try
		{
			connection = DriverManager.getConnection(url, "postgres",
					dbpassword);

			// check if user exists
			String getUsername = "select * from dwmusers where username='"+ user + "';";
			System.out.println("SQL: " + getUsername);
			Statement getUserStatement = connection.createStatement();
			ResultSet getUserResults = getUserStatement.executeQuery(getUsername);
			boolean inResultSet = false;
			while (getUserResults.next())
			{
				if((getUserResults.getString("username").equals(user)))
				{
					inResultSet = true;
				}
			}
			if(!inResultSet) throw new UserNotFoundException("User not found in database");
			String addString = "insert into friends(username1,username2,accepted)values('"+user+"','"+friend+"',false);";
			System.out.println("SQL: " + addString);
			Statement createStatement = connection.createStatement();
			int affectedRows = createStatement.executeUpdate(((addString)));
			if(affectedRows==1)
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

	public boolean acceptFriend(String user, String friend)
	{
		boolean succes = false;
		try
		{
			connection = DriverManager.getConnection(url, "postgres",dbpassword);
			// Check if they exist!
			
			String updateFriend = "update friends set accepted='true' where username1='"+user+"' and username2='"+friend+"';";
			Statement updateStatement = connection.createStatement();
			int affected = updateStatement.executeUpdate(updateFriend);
			if(affected==1)
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
