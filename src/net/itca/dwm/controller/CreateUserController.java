package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

/**
 * 
 * @author Dylan
 *
 */
public class CreateUserController
{
	DineWithMeFacade facade;
	
	/**
	 * 
	 * @param dineWithMeFacade
	 */
	public CreateUserController(DineWithMeFacade dineWithMeFacade)
	{
		facade = dineWithMeFacade;
	}

	/**
	 * 
	 */
	public void navigateToMenu()
	{
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(menuPanel);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param first
	 * @param last
	 */
	public void createUser(String username, String password, String first, String last)
	{
		System.out.println("Controller creating user");
		System.out.println("Encrypting: " + password);
		String encryptedPassword = facade.encrypt(password);
		try
		{
			facade.createUser(username, encryptedPassword, first, last);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
