package net.itca.dwm.controller.events;

import java.util.ArrayList;
import java.util.Vector;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class CreateEventPanelController
{

	DineWithMeFacade facade;

	public CreateEventPanelController(DineWithMeFacade dwmFacade)
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

	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}

	public void createEvent(String name, String date, String recipeName)
	{
		try
		{
			facade.createEvent(name, date, recipeName);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
