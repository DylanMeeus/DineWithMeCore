package net.itca.dwm.controller.friends;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class ViewFriendsController extends DataPanelController
{
	
	DineWithMeFacade facade;
	public ViewFriendsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	

	
	/**
	 * Gets the friends belonging to the logged in user
	 * @return
	 */
	public Vector<String> getFriends()
	{
		ArrayList<String> friends = null;
		try
		{
			friends = facade.getFriendsByUserID();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Vector<String> friendsVector = new Vector<String>();
		friendsVector.addAll(friends);
		return friendsVector;
	}

}
