package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.core.User;
import net.itca.dwm.swingcore.DWMSwingFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

/**
 * 
 * @author Dylan
 *
 */
public class LoginController
{
	private DineWithMeFacade facade;

	/**
	 * 
	 * @param dwmfacade
	 */
	public LoginController()
	{
		facade = DWMSwingFacade.getInstance();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password)
	{
		String pwEncrypted = facade.encrypt(password);
		boolean succes = false;
		try
		{
			if (facade.login(username, pwEncrypted))
			{
				User user = new User(username, facade.getUserID(username));
				facade.setCurrentUser(user);
				LoginHomePanel homePanel = new LoginHomePanel(
						new LoginHomeController());
				MainView mainView = MainView.getMainView();
				mainView.setMainPanel(homePanel);
				succes = true;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return succes;
	}

	/**
	 * 
	 */
	public void navigateToMenu()
	{
		MenuPanel menuPanel = new MenuPanel(new MenuController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(menuPanel);
	}

}
