package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

/**
 * Controller to control the event invites view.
 * @author Dylan
 *
 */
public class ViewEventInvitesController extends DataPanelController
{

	private DineWithMeFacade facade;
	public ViewEventInvitesController()
	{
		facade =  DWMSwingFacade.getInstance();
	}
	
	public Vector<String> getEventInvites()
	{
		Vector<String> invites = new Vector<String>();
		
		try
		{
			ArrayList<String> aInvites = facade.getEventInvites();
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
	
	public void acceptInvite(String event)
	{
		String eventString = event.split("\\|")[0];
		try
		{
			facade.acceptEventInvite(eventString);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void declineInvite(String event)
	{
		String eventString = event.split("\\|")[0];
		try
		{
			facade.deleteEvent(eventString);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	
	}
}
