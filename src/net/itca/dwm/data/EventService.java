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
	public void createEvent(String name, String date, String time, int hostid, int recipeid)
	{
		try
		{
			openConnection();
			String createEventStatement = "insert into events(name,eventdate,hostid,recipeid, eventtime) values('"
					+ name
					+ "','"
					+ date
					+ "',"
					+ hostid
					+ ","
					+ recipeid
					+ ", '"+time+"');";
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
	
		
	/**
	 * Get events belonging to the currently logged in user.
	 * @param currentUserID
	 * @return
	 */
	public ArrayList<String> getMyEvents(int currentUserID)
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

	public void inviteUserToEvent(int inviteeID, String eventname, int currentUser)
	{
		int eventID = getEventID(eventname, currentUser);
		System.out.println("event id: " + eventID +"friend id:" + inviteeID);
		try
		{
			openConnection();
			String insertUsers = "insert into eventinvitees values("+eventID+","+inviteeID+", false);";
			System.out.println("SQL: " + insertUsers);
			Statement insertStatement = connection.createStatement();
			int affected = insertStatement.executeUpdate(insertUsers);
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
	
	
	public ArrayList<String> getEventInvites(int currentUser)
	{
		ArrayList<String> invites = new ArrayList<String>();
		try
		{
			openConnection();
			String selectEventInvites = "select * from eventinvitees inner join events using(eventid) inner join users on events.hostid = users.userid where inviteeid="+currentUser+" and accepted=false;";
			Statement selectStatement = connection.createStatement();
			ResultSet results = selectStatement.executeQuery(selectEventInvites);
			while(results.next())
			{
				String addInvite = results.getString("name") + " " + results.getString("eventdate") + " " + results.getString("username");
				invites.add(addInvite);
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
		
		return invites;
	}

}
