package net.itca.dwm.controller.recipes;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

/**
 * Controller for the view recipes panel
 * @author Dylan
 *
 */
public class ViewRecipesController
{

	DineWithMeFacade facade;
	public ViewRecipesController(DineWithMeFacade dwmfacade)
	{
		facade = dwmfacade;
	}
	
	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
	
	/**
	 * Returns the recipes based on the current logged in user.
	 * @return
	 */
	public Vector<String> getRecipes()
	{
		ArrayList<String> recipes = facade.getRecipes();
		Vector<String> recipeVector = new Vector<String>();
		recipeVector.addAll(recipes);
		return recipeVector;
	}
	
}
