package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class LoginController
{
	private DineWithMeFacade facade;
	
	public LoginController(DineWithMeFacade dwmfacade)
	{
		facade = dwmfacade;
	}
	
	
	public void login(String username, String password)
	{
		String pwEncrypted = facade.encrypt(password);
		facade.login(username, pwEncrypted);
	}
	
	public void navigateToMenu()
	{
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(menuPanel);
	}
}
