package net.itca.dwm.controller.recipes;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.DataPanelController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.swingcore.DWMSwingFacade;

/**
 * Controller for the view recipes panel
 * 
 * @author Dylan
 *
 */
public class ViewRecipesController extends DataPanelController
{

	private DineWithMeFacade facade;

	public ViewRecipesController()
	{
		facade = DWMSwingFacade.getInstance();
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

	public String getDetails(String entry)
	{
		String details = "";
		try
		{
			details = facade.getRecipeDetails(entry);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return details;
	}

	public void deleteRecipe(String entry)
	{
		try
		{
			facade.deleteRecipe(entry);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
