package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

public class ViewAcceptedEventsController extends DataPanelController 
{

	private DineWithMeFacade facade;
	public ViewAcceptedEventsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public Vector<String> getAcceptedEvents()
	{
		Vector<String> events = new Vector<String>();
		
		try
		{
			ArrayList<String> accepted = facade.getAcceptedEvents();
			events.addAll(accepted);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return events;
	}
	
	public String getEventDetails(String eventString)
	{
		eventString = eventString.split("\\|")[0];
		String detailString = "";
		try
		{
			detailString += facade.getEventDetails(eventString);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return detailString;
	}
	
	public void deleteEvent(String event)
	{
		System.out.println("Delete event");
		String eventString = event.split("\\|")[0];
		String hostString = event.split("\\|")[1];
		try
		{
			facade.deleteAcceptedEvent(eventString, hostString);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	
	}
}
