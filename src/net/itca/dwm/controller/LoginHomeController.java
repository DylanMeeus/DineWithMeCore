package net.itca.dwm.controller;

import net.itca.dwm.controller.friends.AddFriendController;
import net.itca.dwm.controller.friends.FriendInviteController;
import net.itca.dwm.controller.friends.ViewFriendsController;
import net.itca.dwm.controller.recipes.CreateRecipeController;
import net.itca.dwm.controller.recipes.ViewRecipesController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;
import net.itca.dwm.view.friends.AddFriendPanel;
import net.itca.dwm.view.friends.FriendInvitesPanel;
import net.itca.dwm.view.friends.ViewFriendsPanel;
import net.itca.dwm.view.recipes.CreateRecipePanel;
import net.itca.dwm.view.recipes.ViewRecipesPanel;

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
		ViewFriendsPanel vfPanel = new ViewFriendsPanel(new ViewFriendsController(new DineWithMeFacade()));
		mainView.setMainPanel(vfPanel);
	}
	
	public void navigateViewFriendInvites()
	{
		FriendInvitesPanel fiPanel = new FriendInvitesPanel(new FriendInviteController(new DineWithMeFacade()));
		mainView.setMainPanel(fiPanel);
	}
	
	public void navigateCreateRecipe()
	{
		CreateRecipePanel crPanel = new CreateRecipePanel(new CreateRecipeController(new DineWithMeFacade()));
		mainView.setMainPanel(crPanel);
	}
	
	public void navigateViewRecipes()
	{
		ViewRecipesPanel vrPanel = new ViewRecipesPanel(new ViewRecipesController(new DineWithMeFacade()));	
		mainView.setMainPanel(vrPanel);
	}
	
	public void navigateCreateEvent()
	{
		System.out.println("Add event");
	}
	
	public void navigateViewEvents()
	{
		System.out.println("View events");
	}
}
