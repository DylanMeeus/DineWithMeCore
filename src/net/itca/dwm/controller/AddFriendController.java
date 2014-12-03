package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class AddFriendController
{
	private DineWithMeFacade facade;
	public AddFriendController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
	
	
}
