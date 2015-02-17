package net.itca.dwm.data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;

import net.itca.dwm.interfaces.DataService;
import net.itca.dwm.interfaces.IEvents;

/**
 * Class to deal with the event system in the database. (CRUD operations).
 * 
 * @author Dylan
 *
 */
public class EventService extends Database implements DataService, IEvents
{
	
	private PreparedStatement preparedStatement;
	public EventService()
	{
		super();
	}


	/**
	 * Enter an event in the database with the given parameters.
	 * @param name
	 * @param date
	 * @param time
	 * @param hostid
	 * @param recipeid
	 */
	public void createEvent(String name, String date, String time, int hostid,int recipeid)
	{
		// TODO: date/time format

		try
		{
			openConnection();
			String createEventStatement = "insert into events(name,eventdate,hostid,recipeid, eventtime) values(?,'"
					+ date + "', ?, ?, '" + time + "');";
			System.out.println("SQL: " + createEventStatement);
			preparedStatement = connection
					.prepareStatement(createEventStatement);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, hostid);
			preparedStatement.setInt(3, recipeid);
			int affected = preparedStatement.executeUpdate();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
	}
	
	/**
	 * Gets an event based on a given recipeid
	 * @param recipeID
	 * @param currentUserID
	 * @return
	 */
	public ArrayList<Integer> getEventsBasedOnRecipe(int recipeID, int currentUserID)
	{
		ArrayList<Integer> eventids = new ArrayList<Integer>();
		
		try
		{
			openConnection();
			String selectEventIDs = "select eventid from events where hostid="+currentUserID+" and recipeid="+recipeID+";";
			Statement selectEIds = connection.createStatement();
			ResultSet results = selectEIds.executeQuery(selectEventIDs);
			while(results.next())
			{
				eventids.add(results.getInt("eventid"));
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
		
		return eventids;
	}

	/**
	 * Get events belonging to the currently logged in user.
	 * 
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

	/**
	 * Invite a user to an event by giving the ID of the event.
	 * @param inviteeID
	 * @param eventname
	 * @param currentUser
	 */
	public void inviteUserToEvent(int inviteeID, String eventname,
			int currentUser)
	{
		int eventID = getEventID(eventname, currentUser);
		System.out.println("event id: " + eventID + "friend id:" + inviteeID);
		try
		{
			openConnection();
			String insertUsers = "insert into eventinvitees values(" + eventID
					+ "," + inviteeID + ", false);";
			System.out.println("SQL: " + insertUsers);
			Statement insertStatement = connection.createStatement();
			int affected = insertStatement.executeUpdate(insertUsers);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
	}

	/**
	 * 
	 * @param eventname
	 * @param hostID
	 * @return
	 */
	public int getEventID(String eventname, int hostID)
	{
		// Throw event exception?
		int id = -1;
		try
		{
			openConnection();
			String fetchIDString = "select eventid from events where name='"
					+ eventname + "';";
			System.out.println("SQL: " + fetchIDString);
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

	/**
	 * Get events belonging to the logged in user.
	 */
	public ArrayList<String> getEventInvites(int currentUser)
	{
		ArrayList<String> invites = new ArrayList<String>();
		try
		{
			openConnection();
			String selectEventInvites = "select * from eventinvitees inner join events using(eventid) inner join users on events.hostid = users.userid where inviteeid="
					+ currentUser + " and accepted=false;";
			Statement selectStatement = connection.createStatement();
			ResultSet results = selectStatement
					.executeQuery(selectEventInvites);
			while (results.next())
			{
				String addInvite = results.getString("name") + "|"
						+ results.getString("username") + "|"
						+ results.getString("eventdate") + "|"
						+ results.getString("eventtime");
				invites.add(addInvite);
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return invites;
	}

	/**
	 * Accept an event invite. 
	 * @param eventname
	 * @param currentUser
	 */
	public void acceptEventInvite(String eventname, int currentUser)
	{
		try
		{
			int eventID = getEventID(eventname, currentUser);
			openConnection();
			String acceptString = "update eventinvitees set accepted = true where eventid="
					+ eventID + " and inviteeid=" + currentUser + ";";
			System.out.println("SQL: " + acceptString);
			Statement acceptStatement = connection.createStatement();
			int affected = acceptStatement.executeUpdate(acceptString);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
	}

	/**
	 * Get the events that a user has accepted.
	 * @param currentUser
	 * @return
	 */
	public ArrayList<String> getAcceptedEvents(int currentUser)
	{
		ArrayList<String> accepted = new ArrayList<String>();

		try
		{
			openConnection();
			String selectAcceptedInvites = "select * from eventinvitees inner join events using(eventid) inner join users on events.hostid = users.userid where inviteeid="
					+ currentUser + " and accepted=true;";
			Statement selectStatement = connection.createStatement();
			System.out.println("SQL: " + selectAcceptedInvites);
			ResultSet results = selectStatement
					.executeQuery(selectAcceptedInvites);
			while (results.next())
			{
				String addInvite = results.getString("name") + "|"
						+ results.getString("username") + "|"
						+ results.getString("eventdate") + "|"
						+ results.getString("eventtime");
				accepted.add(addInvite);
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		return accepted;
	}

	/**
	 * Gets the details from an event.
	 * @param eventname
	 * @param currentUser
	 * @return
	 */
	public String getEventDetails(String eventname, int currentUser)
	{
		String details = "";
		try
		{
			openConnection();
			String selectDetails = "select * from eventinvitees inner join events using(eventid) inner join users on events.hostid = users.userid inner join recipes using(recipeid) where inviteeid="
					+ currentUser
					+ /*" and accepted=true */ " and name='"
					+ eventname
					+ "';";
			Statement selectStatement = connection.createStatement();
			System.out.println("SQL: " + selectDetails);
			ResultSet results = selectStatement.executeQuery(selectDetails);
			while (results.next())
			{
				details += results.getString("name") + "\n"
						+ results.getString("eventdate") + "\n"
						+ results.getString("eventtime") + "\n"
						+ results.getString("username") + "\n"
						+ results.getString("firstname") + " "
						+ results.getString("lastname") + "\n"
						+ results.getString("recipename");
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		return details;
	}

	
	/**
	 * Decline an event invite.
	 * @param event
	 */
	public void deleteEventFromInvites(int event)
	{
		try
		{
			openConnection();
			
			String deleteString = "delete from eventinvitees where eventid="+event+";";
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteString);
			
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
	
	
	/**
	 * Delete an event.
	 * @param id
	 */
	public void deleteEvent(int id)
	{
	
		try
		{
			openConnection();
			String deleteString = "delete from events where eventid="+id+";";
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteString);
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
	
	/**
	 * Deletes an event based on an event username
	 * @param eventname
	 * @param currentUser
	 */
	public void deleteEvent(String eventname, int currentUser)
	{
		try
		{
			openConnection();
			String deleteString = "delete from events where name='"+eventname+"' and hostid="+currentUser;
			System.out.println("SQL: " + deleteString);
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteString);
		
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
	}
	
	
	
	/**
	 * Deletes a previously accepted event.
	 * @param eventname
	 * @param currentUser
	 */
	public void deleteAcceptedEvent(int eventID, int hostUserID)
	{
		
		try
		{
			openConnection();
			String deleteAcceptedString = "delete from eventinvitees where inviteeid="+hostUserID+" and eventID="+eventID+";";
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteAcceptedString);
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
	
	
	/**
	 * Get some details for an event hosted by the current user.
	 * @param hostUserID
	 * @return
	 */
	public String getMyEventDetails(int hostUserID, String name)
	{
		String details = "";
		try
		{
			openConnection();
			String selectDetails = "select * from events inner join recipes using(recipeid) where hostID="+hostUserID+" and name='"+name+"';";
			Statement selectStatement = connection.createStatement();
			System.out.println("SQL: " + selectDetails);
			ResultSet results = selectStatement.executeQuery(selectDetails);
			while (results.next())
			{
				details += results.getString("name") + "\n"
						+ results.getString("eventdate") + "\n"
						+ results.getString("eventtime") + "\n"
						+ results.getString("recipename");
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}
		return details;
	}
	
	
}
