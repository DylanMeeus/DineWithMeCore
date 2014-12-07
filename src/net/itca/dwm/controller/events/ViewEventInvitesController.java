package net.itca.dwm.controller.events;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

public class ViewEventInvitesController extends DataPanelController
{

	DineWithMeFacade facade;
	public ViewEventInvitesController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
}
