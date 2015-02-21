package net.itca.dwm.controller.users;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class AddFriendController extends DataPanelController
{
	private DineWithMeFacade facade;
	public AddFriendController()
	{
		facade =  DWMSwingFacade.getInstance();
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
