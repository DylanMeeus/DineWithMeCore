package net.itca.dwm.interfaces;

import java.util.ArrayList;

public interface IEvents
{
	void acceptEventInvite(String eventname, int currentUser);
	void createEvent(String name, String date, String time, int hostID, int recipeID);
	int getEventID(String eventname, int currentUser);
	ArrayList<String> getEventInvites(int currentUser);
	ArrayList<String> getMyEvents(int currentUserID);
	void inviteUserToEvent(int inviteeID, String eventname, int currentUser);
}
