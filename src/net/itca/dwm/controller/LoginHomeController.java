package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.AddFriendPanel;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

public class LoginHomeController
{
	MainView mainView;
	public LoginHomeController() // No facade needed for this one
	{
		mainView = MainView.getMainView();
	}
	
	public void logout()
	{
		// Set user to null & return to main?
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		DineWithMeFacade facade = new DineWithMeFacade();
		facade.setCurrentUser(null);
		mainView.setMainPanel(menuPanel);
		System.out.println("logout");
	}
	
	public void navigateAddFriend()
	{
		AddFriendPanel addFriendPanel = new AddFriendPanel(new AddFriendController(new DineWithMeFacade()));
		mainView.setMainPanel(addFriendPanel);
	}
	
	public void navigateViewFriends()
	{
		
	}
	
	public void navigateAddRecipe()
	{
		
	}
	
	public void navigateViewRecipes()
	{
		
	}
	
	public void navigateAddEvent()
	{
		
	}
	
	public void navigateViewEvents()
	{
		
	}
}
