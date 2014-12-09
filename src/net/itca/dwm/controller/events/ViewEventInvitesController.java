package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

public class ViewEventInvitesController extends DataPanelController
{

	DineWithMeFacade facade;
	public ViewEventInvitesController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public Vector<String> getEventInvites()
	{
		Vector<String> invites = new Vector<String>();
		
		try
		{
			ArrayList<String> aInvites = facade.getEVentInvites();
			for(String invite : aInvites)
			{
				invites.add(invite);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return invites;
	}
}
