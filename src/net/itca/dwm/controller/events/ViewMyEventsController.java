package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

public class ViewMyEventsController extends DataPanelController
{

	private DineWithMeFacade facade;

	public ViewMyEventsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}


	public Vector<String> getEvents()
	{
		Vector<String> eventVector = new Vector<String>();
		try
		{
			ArrayList<String> eventList = facade.getEvents();
			eventVector.addAll(eventList);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return eventVector;
	}
	
	public String getDetails()
	{
		return facade.getEventDetails();
	}
	
	public void deleteEvent()
	{
		
	}
}
