package net.itca.dwm.controller.friends;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

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
	}
	
}
