package net.itca.dwm.controller.users;

import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

public class ViewFriendsController extends DataPanelController
{

	private DineWithMeFacade facade;

	public ViewFriendsController()
	{
		facade = DWMSwingFacade.getInstance();
	}

	/**
	 * Gets the friends belonging to the logged in user
	 * 
	 * @return
	 */
	public Vector getFriends()
	{
		return null; 
	}

}
