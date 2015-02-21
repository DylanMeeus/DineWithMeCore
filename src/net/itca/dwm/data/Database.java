package net.itca.dwm.data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Dylan Only database, access with JDBC. Default instance uses a local database
 * under the schema 'dinewithme'
 * 
 * @author
 * 
 */
public class Database /* implements Datasource */
{
	protected Connection connection;
	// protected String url = "jdbc:postgresql://127.0.0.1:5432/postgres;
	// Localhost
	protected String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51415/o3?sslfactory=org.postgresql.ssl.NonValidatingFactory&ssl=true";

	protected String dbpassword = "Proton16021";
	protected String schema = "public";
	protected String user = "r0368004";

	public Database()
	{
		try
		{
			// Read the information from the config file.
			Class.forName("org.postgresql.Driver");
			System.out.println("Connection url: " + url);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	protected void openConnection()
	{
		try
		{
			connection = DriverManager.getConnection(url, user, dbpassword);
			Statement statement = connection.createStatement();
			statement.execute("set search_path to '" + schema + "'");
			statement.close();
		} catch (SQLException e)
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

	public void setConnectionURL(String _url)
	{
		url = _url;
	}

	public void setSchema(String _schema)
	{
		schema = _schema;
	}

	public void setUsername(String username)
	{
		user = username;
	}

	public void setPassword(String password)
	{
		dbpassword = password;
	}
}
