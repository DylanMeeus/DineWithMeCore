package net.itca.dwm.controller.users;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class AddFriendController extends DataPanelController
{
	private DineWithMeFacade facade;
	public AddFriendController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public void addFriend(String friend)
	{
		try
		{
		facade.addFriend(friend);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
		}
	}
	
}
