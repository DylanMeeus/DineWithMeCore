package net.itca.dwm.controller;

import net.itca.dwm.controller.friends.AddFriendController;
import net.itca.dwm.controller.friends.FriendInviteController;
import net.itca.dwm.controller.friends.ViewFriendsController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;
import net.itca.dwm.view.friends.AddFriendPanel;
import net.itca.dwm.view.friends.FriendInvitesPanel;
import net.itca.dwm.view.friends.ViewFriendsPanel;

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
		System.out.println("Add recipe");
	}
	
	public void navigateViewRecipes()
	{
		System.out.println("view recipes");		
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
