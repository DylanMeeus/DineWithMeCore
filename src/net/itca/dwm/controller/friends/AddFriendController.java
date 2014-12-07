package net.itca.dwm.controller.friends;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

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
	}
	
}
