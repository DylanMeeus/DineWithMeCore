package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.core.User;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class LoginController
{
	private DineWithMeFacade facade;
	
	public LoginController(DineWithMeFacade dwmfacade)
	{
		facade = dwmfacade;
	}
	
	
	public boolean login(String username, String password)
	{
		System.out.println("The encrypted pw is: " + password);
		String pwEncrypted = facade.encrypt(password);
		boolean succes = false;
		if(facade.login(username, pwEncrypted))
		{
			User user = new User(username, facade.getUserID(username));
			facade.setCurrentUser(user);
			LoginHomePanel homePanel = new LoginHomePanel(new LoginHomeController());
			MainView mainView = MainView.getMainView();
			mainView.setMainPanel(homePanel);
			succes = true;
		}
		
		return succes;
	}
	
	public void navigateToMenu()
	{
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(menuPanel);
	}

}
