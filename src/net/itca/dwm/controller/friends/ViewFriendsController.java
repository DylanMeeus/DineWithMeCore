package net.itca.dwm.controller.friends;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

public class ViewFriendsController extends DataPanelController
{

	private DineWithMeFacade facade;

	public ViewFriendsController()
	{
		facade = DWMSwingFacade.getInstance();
	}

	/**
	 * Gets the friends belonging to the logged in user
	 * 
	 * @return
	 */
	public Vector<String> getFriends()
	{
		ArrayList<String> friends = null;
		try
		{
			friends = facade.getFriendsByUserID();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		Vector<String> friendsVector = new Vector<String>();
		friendsVector.addAll(friends);
		return friendsVector;
	}

	public String getDetails(String friendsname)
	{
		friendsname = friendsname.split(" ")[0];
		String details = "";
		try
		{
			details = facade.getFriendDetails(friendsname);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return details;
	}

	public void removeFriend(String friendsname)
	{
		System.out.println("Removed");
		String username = friendsname.split(" ")[0];
		try
		{
			facade.deleteFriend(username);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
