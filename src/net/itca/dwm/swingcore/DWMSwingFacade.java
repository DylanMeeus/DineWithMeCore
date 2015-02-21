package net.itca.dwm.swingcore;

import net.itca.dwm.core.DineWithMeFacade;

/**
 * Singleton swing facade.
 * @author Dylan
 *
 */
public class DWMSwingFacade extends DineWithMeFacade
{
	private static DWMSwingFacade facade;
	
	// TODO: Improve for deadlocks and stuff.
	public static DWMSwingFacade getInstance()
	{
		if(facade==null)
		{
			facade = new DWMSwingFacade();
		}
		return facade;
	}
	
	private DWMSwingFacade()
	{

	}
}
