package net.itca.dwm.controller.friends;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class FriendInviteController
{
	private DineWithMeFacade facade;
	public FriendInviteController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	
	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
	
	public Vector<String> getFriendInvites()
	{
		ArrayList<String> invites = facade.getFriendInvites();
		Vector<String> friendVector = new Vector<String>();
		friendVector.addAll(invites);
		return friendVector;
	}

}
