package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

public class ViewMyEventsController extends DataPanelController
{

	private DineWithMeFacade facade;

	public ViewMyEventsController()
	{
		facade =  DWMSwingFacade.getInstance();
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
		try
		{
		return facade.getEventDetails("test");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return "";
	}
	
	public void deleteEvent(String event)
	{
		try
		{
			facade.deleteEvent(event);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
