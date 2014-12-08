package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

public class InviteFriendsController extends DataPanelController
{

	private DineWithMeFacade facade;
	public InviteFriendsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public void inviteFriend(String event, String friendname)
	{
		try
		{
			facade.InviteFriend(event, friendname);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public ArrayList<String> getMyEvents()
	{
		ArrayList<String> events = null;
		try
		{			
			events = facade.getEvents();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return events;
	}
	
	public Vector<String> getFriends()
	{
		Vector<String> friends = new Vector<String>();
		try
		{
			ArrayList<String> friendList = facade.getFriendsByUserID();
			for(String s : friendList)
			{
				friends.add(s);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return friends;
	}
}
