package net.itca.dwm.data;

import java.util.ArrayList;

import net.itca.dwm.interfaces.IEvents;

public class OfflineEventService implements IEvents
{

	public void acceptEventInvite(String eventname, int currentUser)
	{
		// TODO Auto-generated method stub
		
	}

	public void createEvent(String name, String date, String time, int hostID, int recipeID)
	{
		// TODO Auto-generated method stub
		
	}

	public int getEventID(String eventname, int currentUser)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<String> getEventInvites(int currentUser)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getMyEvents(int currentUserID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void inviteUserToEvent(int inviteeID, String eventname, int currentUser)
	{
		// TODO Auto-generated method stub
		
	}

}
