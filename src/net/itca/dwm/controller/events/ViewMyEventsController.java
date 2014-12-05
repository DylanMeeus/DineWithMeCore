package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class ViewMyEventsController
{

	private DineWithMeFacade facade;

	public ViewMyEventsController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}

	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
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
}
