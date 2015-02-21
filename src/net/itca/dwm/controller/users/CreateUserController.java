package net.itca.dwm.controller.users;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.controller.LoginController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginPanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.swingcore.*;
/**
 * 
 * @author Dylan
 *
 */
public class CreateUserController
{
	
	
	
	private DWMSwingFacade facade;
	
	/**
	 * 
	 * @param dineWithMeFacade
	 */
	public CreateUserController()
	{
		facade = DWMSwingFacade.getInstance();
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
	
	public void navigateMenu()
	{
		LoginPanel lp = new LoginPanel(new LoginController());
		MainView mv = MainView.getMainView();
		mv.setMainPanel(lp);
	}

}
