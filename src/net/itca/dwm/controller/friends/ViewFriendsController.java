package net.itca.dwm.controller.friends;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class ViewFriendsController
{
	
	DineWithMeFacade facade;
	public ViewFriendsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	
	public void navigateToMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
	
	/**
	 * Gets the friends belonging to the logged in user
	 * @return
	 */
	public Vector<String> getFriends()
	{
		ArrayList<String> friends = facade.getFriendsByUserID();
		Vector<String> friendsVector = new Vector<String>();
		friendsVector.addAll(friends);
		return friendsVector;
	}

}
