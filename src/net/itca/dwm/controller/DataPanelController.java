package net.itca.dwm.controller;

import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

/**
 * Superclass which contains methods all controllers which control views containing database information need to implement
 * @author Dylan
 *
 */
public class DataPanelController
{

	/**
	 * Opens the main menu for a logged-in user.
	 */
	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
}
