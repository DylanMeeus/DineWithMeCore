package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;

/**
 * 
 * @author Dylan
 *
 */
public class CreateEventController extends DataPanelController
{
	DineWithMeFacade facade;

	/**
	 * 
	 * @param dwmFacade
	 */
	public CreateEventController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}

	/**
	 * Returns the recipes based on the current logged in user.
	 * 
	 * @return
	 */
	public Vector<String> getRecipes()
	{
		ArrayList<String> recipes = null;
		try
		{
			recipes = facade.getRecipes();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		Vector<String> recipeVector = new Vector<String>();
		recipeVector.addAll(recipes);
		return recipeVector;
	}


	/**
	 * 
	 * @param name
	 * @param date
	 * @param recipeName
	 */
	public void createEvent(String name, String date, String time, String recipeName)
	{
		try
		{
			facade.createEvent(name, date, time, recipeName);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
