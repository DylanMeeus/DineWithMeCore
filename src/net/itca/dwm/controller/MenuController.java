package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.CreateUserPanel;
import net.itca.dwm.view.LoginPanel;
import net.itca.dwm.view.MainView;

public class MenuController
{
	private DineWithMeFacade dineWithMeFacade;
	public MenuController(DineWithMeFacade dwm)
	{
		dineWithMeFacade = dwm;
	}
	
	public void navigateLogin()
	{
		LoginPanel login = new LoginPanel(new LoginController(dineWithMeFacade));
		MainView mv = MainView.getMainView();
		mv.setMainPanel(login);
	}
	
	public void navigateCreateUser()
	{
		CreateUserPanel createuser = new CreateUserPanel(new CreateUserController(dineWithMeFacade));
		MainView mv = MainView.getMainView();
		mv.setMainPanel(createuser);
	
	}
}
