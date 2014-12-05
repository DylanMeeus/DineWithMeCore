package net.itca.dwm.controller.recipes;

import net.itca.dwm.controller.LoginHomeController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.LoginHomePanel;
import net.itca.dwm.view.MainView;

public class CreateRecipeController
{

	private DineWithMeFacade facade;
	public CreateRecipeController(DineWithMeFacade dwmFacade)
	{
		facade = dwmFacade;
	}
	
	public void navigateMenu()
	{
		LoginHomePanel loginHome = new LoginHomePanel(new LoginHomeController());
		MainView mainView = MainView.getMainView();
		mainView.setMainPanel(loginHome);
	}
	
	public void createRecipe(String name, String ingredients, String instructions, int people)
	{
		//System.out.println("test: " + facade.encodeForDB(ingredients));
		try
		{
		facade.createRecipe(name, facade.encodeForDB(ingredients), facade.encodeForDB(instructions), people);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
