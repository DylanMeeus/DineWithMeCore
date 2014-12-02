package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class CreateUserController
{
	DineWithMeFacade facade;
	
	public CreateUserController(DineWithMeFacade dineWithMeFacade)
	{
		facade = dineWithMeFacade;
	}

	public void navigateToMenu()
	{
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(menuPanel);
	}
	
	
	public void createUser(String username, String password, String first, String last)
	{
		String encryptedPassword = facade.encrypt(password);
	}

}
