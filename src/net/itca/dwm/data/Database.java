package net.itca.dwm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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


}
