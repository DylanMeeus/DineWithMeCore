package net.itca.dwm.data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.itca.dwm.interfaces.DataService;

/**
 * Class to deal with the event system in the database. (CRUD operations).
 * 
 * @author Dylan
 *
 */
public class EventService extends Database implements DataService
{
	public void createEvent(String name, String date, int hostid, int recipeid)
	{
		try
		{
			openConnection();
			String createEventStatement = "insert into events(name,eventdate,hostid,recipeid) values('"
					+ name
					+ "','"
					+ date
					+ "',"
					+ hostid
					+ ","
					+ recipeid
					+ ");";
			System.out.println("SQL: " + createEventStatement);
			Statement createStatement = connection.createStatement();
			int affected = createStatement.executeUpdate(createEventStatement);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
	}

	public ArrayList<String> getEvents(int currentUserID)
	{
		ArrayList<String> events = new ArrayList<String>();
		try
		{
			openConnection();
			String selectEvents = "select * from events where hostid="
					+ currentUserID + ";";
			Statement selectStatement = connection.createStatement();
			ResultSet results = selectStatement.executeQuery(selectEvents);
			while (results.next())
			{
				events.add(results.getString("name"));
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		return events;
	}

	public void inviteUserToEvent(String invitee, String eventname, int currentUser)
	{
		int eventID = getEventID(eventname, currentUser);
		System.out.println("event id: " + eventID);
	}

	private int getEventID(String eventname, int currentUser)
	{
		// Throw event exception?
		int id = -1;
		try
		{
			openConnection();
			String fetchIDString = "select eventid from events where name='"
					+ eventname + "';";
			Statement fetchStatement = connection.createStatement();
			ResultSet results = fetchStatement.executeQuery(fetchIDString);
			while (results.next())
			{
				id = results.getInt("eventid");
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return id;
	}

}
