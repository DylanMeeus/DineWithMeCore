package net.itca.dwm.data;

import java.sql.Statement;

import net.itca.dwm.interfaces.DataService;

public class EventService extends Database implements DataService
{

	
	
	public void createEvent(String name, String date, int hostid, int recipeid)
	{
		try
		{
			openConnection();
			String createEventStatement = "insert into events(name,eventdate,hostid,recipeid) values('"+name+"','"+date+"',"+hostid+","+recipeid+");";
			System.out.println("SQL: " + createEventStatement);
			Statement createStatement = connection.createStatement();
			int affected = createStatement.executeUpdate(createEventStatement);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
	}
}
