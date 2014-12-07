package net.itca.dwm.controller.users;

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
	public Vector getFriends()
	{
		
		
		
		return null;
	}

}
