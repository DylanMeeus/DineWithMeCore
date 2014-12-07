package net.itca.dwm.controller;

import net.itca.dwm.controller.users.CreateUserController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginPanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.users.CreateUserPanel;

/**
 * Controller for the main menu
 * @author Dylan
 *
 */
public class MenuController
{
	private DineWithMeFacade dineWithMeFacade;
	
	/**
	 * 
	 * @param dwm
	 */
	public MenuController(DineWithMeFacade dwm)
	{
		dineWithMeFacade = dwm;
	}
	
	/**
	 * Navigates to the login menu
	 */
	public void navigateLogin()
	{
		LoginPanel login = new LoginPanel(new LoginController(dineWithMeFacade));
		MainView mv = MainView.getMainView();
		mv.setMainPanel(login);
	}
	
	/**
	 * Navigates to the create user menu
	 */
	public void navigateCreateUser()
	{
		CreateUserPanel createuser = new CreateUserPanel(new CreateUserController(dineWithMeFacade));
		MainView mv = MainView.getMainView();
		mv.setMainPanel(createuser);
	
	}
}
