package net.itca.dwm.controller;

import net.itca.dwm.controller.users.CreateUserController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;
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
	private DWMSwingFacade dineWithMeFacade = DWMSwingFacade.getInstance();
	
	/**
	 * 
	 * @param dwm
	 */
	public MenuController()
	{
	
	}
	
	/**
	 * Navigates to the login menu
	 */
	public void navigateLogin()
	{
		LoginPanel login = new LoginPanel(new LoginController());
		MainView mv = MainView.getMainView();
		mv.setMainPanel(login);
	}
	
	/**
	 * Navigates to the create user menu
	 */
	public void navigateCreateUser()
	{
		CreateUserPanel createuser = new CreateUserPanel(new CreateUserController());
		MainView mv = MainView.getMainView();
		mv.setMainPanel(createuser);
	
	}
}
