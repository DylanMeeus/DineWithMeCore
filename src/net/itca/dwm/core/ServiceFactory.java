package net.itca.dwm.core;

import net.itca.dwm.data.EventService;
import net.itca.dwm.data.FriendService;
import net.itca.dwm.data.RecipeService;
import net.itca.dwm.exceptions.ServiceException;
import net.itca.dwm.interfaces.DataService;


/**
 * Returns services which talk to the database for a specialized purpose
 * (e.g: RecipeService for CRUD recipes, FriendService for CRUD on friends table)
 * @author Dylan
 *
 */
public class ServiceFactory
{
	/**
	 * 
	 * @param serviceType
	 * @return
	 * @throws Exception
	 */
	public DataService getService(ServiceType serviceType) throws ServiceException
	{
		// Post-Java1.5 you'd use a Switch statement for this, but that is not yet supported under this JDK!
		
		if(serviceType == ServiceType.EVENTSERVICE)
		{
			return new EventService();
		}
		else if(serviceType == ServiceType.FRIENDSERVICE)
		{
			return new FriendService();
		}
		else if(serviceType == ServiceType.RECIPESERVICE)
		{
			return new RecipeService();
		}
		throw new ServiceException("Service not found");
	}
}
