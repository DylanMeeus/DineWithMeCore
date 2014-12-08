package net.itca.dwm.controller;

import net.itca.dwm.controller.events.CreateEventController;
import net.itca.dwm.controller.events.InviteFriendsController;
import net.itca.dwm.controller.events.ViewEventInvitesController;
import net.itca.dwm.controller.events.ViewMyEventsController;
import net.itca.dwm.controller.friends.AddFriendController;
import net.itca.dwm.controller.friends.FriendInviteController;
import net.itca.dwm.controller.friends.ViewFriendsController;
import net.itca.dwm.controller.recipes.CreateRecipeController;
import net.itca.dwm.controller.recipes.ViewRecipesController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;
import net.itca.dwm.view.events.CreateEventPanel;
import net.itca.dwm.view.events.InviteFriendsPanel;
import net.itca.dwm.view.events.ViewEventInvitesPanel;
import net.itca.dwm.view.events.ViewMyEventsPanel;
import net.itca.dwm.view.friends.AddFriendPanel;
import net.itca.dwm.view.friends.FriendInvitesPanel;
import net.itca.dwm.view.friends.ViewFriendsPanel;
import net.itca.dwm.view.recipes.CreateRecipePanel;
import net.itca.dwm.view.recipes.ViewRecipesPanel;

/**
 * 
 * @author Dylan
 *
 */
public class LoginHomeController
{
	private MainView mainView;
	private DineWithMeFacade facade;
	public LoginHomeController() // No facade needed for this one
	{
		mainView = MainView.getMainView();
	}
	
	/**
	 * Logs out the current user and returns to the initial menu
	 */
	public void logout()
	{
		// Set user to null & return to main?
		MenuPanel menuPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		DineWithMeFacade facade = new DineWithMeFacade();
		facade.setCurrentUser(null);
		mainView.setMainPanel(menuPanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for adding friends.
	 */
	public void navigateAddFriend()
	{
		AddFriendPanel addFriendPanel = new AddFriendPanel(new AddFriendController(new DineWithMeFacade()));
		mainView.setMainPanel(addFriendPanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for viewing friends
	 */
	public void navigateViewFriends()
	{
		ViewFriendsPanel vfPanel = new ViewFriendsPanel(new ViewFriendsController(new DineWithMeFacade()));
		mainView.setMainPanel(vfPanel);
	}

	/**
	 * Sets the mainpanel to the panel for viewing friend invites
	 */
	public void navigateViewFriendInvites()
	{
		FriendInvitesPanel fiPanel = new FriendInvitesPanel(new FriendInviteController(new DineWithMeFacade()));
		mainView.setMainPanel(fiPanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for creating recipes
	 */
	public void navigateCreateRecipe()
	{
		CreateRecipePanel crPanel = new CreateRecipePanel(new CreateRecipeController(new DineWithMeFacade()));
		mainView.setMainPanel(crPanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for viewing the users recipes
	 */
	public void navigateViewRecipes()
	{
		ViewRecipesPanel vrPanel = new ViewRecipesPanel(new ViewRecipesController(new DineWithMeFacade()));	
		mainView.setMainPanel(vrPanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for creating events.
	 */
	public void navigateCreateEvent()
	{
		CreateEventPanel cePanel = new CreateEventPanel(new CreateEventController(new DineWithMeFacade()));
		mainView.setMainPanel(cePanel);
	}
	
	/**
	 * Sets the mainpanel to the panel for viewing the events the current user has created.
	 */
	public void navigateViewMyEvents()
	{
		ViewMyEventsPanel vmePanel = new ViewMyEventsPanel(new ViewMyEventsController(new DineWithMeFacade()));
		mainView.setMainPanel(vmePanel);
	}
	
	/**
	 * Sets the main panel to the view to view the event invites.
	 */
	public void navigateViewEventInvites()
	{
		ViewEventInvitesPanel veiPanel = new ViewEventInvitesPanel(new ViewEventInvitesController(new DineWithMeFacade()));
		mainView.setMainPanel(veiPanel);
	}
	
	/**
	 * Sets the main panel to the view to invite friends to an invent.
	 */
	public void navigateInviteFriendToEvent()
	{
		InviteFriendsPanel ivFpanel = new InviteFriendsPanel(new InviteFriendsController(new DineWithMeFacade()));
		mainView.setMainPanel(ivFpanel);
	}
}
