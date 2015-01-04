package net.itca.dwm.core;

import java.util.ArrayList;

import net.itca.dwm.data.EventService;
import net.itca.dwm.data.FriendService;
import net.itca.dwm.data.RecipeService;
import net.itca.dwm.data.UserService;
import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;
import net.itca.dwm.exceptions.ServiceException;

/**
 * 
 * @author Dylan Providing a single-point of access to the dine with me
 *         application
 */
public class DineWithMeFacade
{
	private ActiveSession session = ActiveSession.getActiveSession();
	private ServiceFactory serviceFactory;
	private UserService userService;
	private RecipeService recipeService;
	private FriendService friendService;
	private EventService eventService;
	
	
	public DineWithMeFacade()
	{
		serviceFactory = new ServiceFactory();
		try
		{
			userService = (UserService) serviceFactory.getService(ServiceType.USERSERVICE);
			recipeService = (RecipeService) serviceFactory.getService(ServiceType.RECIPESERVICE);
			friendService = (FriendService) serviceFactory.getService(ServiceType.FRIENDSERVICE);
			eventService = (EventService) serviceFactory.getService(ServiceType.EVENTSERVICE);
		} catch (ServiceException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public boolean login(String username, String password) throws ServiceException
	{
		return userService.login(username, password);
	}

	public String encrypt(String encrypt)
	{
		Encrypter encrypter = new Encrypter(); // Initialize it here, not as
												// class variable. Not used
												// often enough to get heap
												// space. Rather put it on the
												// stack (escape analysis)
		return encrypter.encrypt(encrypt);
	}
	
	// User stuff

	public void createUser(String username, String password, String firstname, String lastname) throws DatabaseException, PasswordException, ServiceException
	{
		userService.createUser(username, firstname, lastname, password);
	}
	
	public void setCurrentUser(User current)
	{
		session.setCurrentUser(current);
	}
	
	public User getCurrentUser()
	{
		return session.getCurrentUser();
	}
	
	public int getUserID(String user) throws ServiceException
	{
		return userService.getUserID(user);	
	}
	
	
	public void addFriend(String username) throws ServiceException
	{
		friendService.addFriend(session.getCurrentUser().getID(), username);
	}
	
	public boolean acceptFriend(String friend) throws ServiceException
	{
		return friendService.acceptFriend(session.getCurrentUser().getID(), friend);
	}
	
	public ArrayList<String> getFriendsByUserID() throws ServiceException
	{
		return friendService.getFriends(session.getCurrentUser().getID());
	}
	
	public ArrayList<String> getFriendInvites() throws ServiceException
	{
		return friendService.getFriendInvites(session.getCurrentUser().getID());
	}

	public String getFriendDetails(String friend)
	{
		return friendService.getFriendInfo(friend);
	}
	
	public boolean declineRequest(String friend) throws Exception
	{
		return friendService.declineRequest(session.getCurrentUser().getID(),friend);		
	}
	
	public void deleteFriend(String friend) throws Exception
	{
		int friendID = friendService.getFriendID(friend);
		friendService.deleteFriend(friendID, session.getCurrentUser().getID());
	}
	
	// RECIPES
	
	public void createRecipe(String name, String ingredients, String instructions, int people) throws ServiceException
	{
		recipeService.createRecipe(name, ingredients, instructions, session.getCurrentUser().getID(), people);
	}
	
	public ArrayList<String> getRecipes() throws ServiceException
	{
		return recipeService.getRecipesByID(session.getCurrentUser().getID());		
	}
	
	public String encodeForDB(String toEncode)
	{
		TextEncoder encoder = new TextEncoder();
		return encoder.encode(toEncode);
	}
	
	public String getRecipeDetails(String recipeName) throws ServiceException
	{
		TextEncoder decoder = new TextEncoder();
		return decoder.decode(recipeService.getRecipeDetails(session.getCurrentUser().getID(), recipeName));
	}
	
	public void deleteRecipe(String recipe) throws ServiceException
	{
		// Delete the recipe, but first delete the events connected to this, for which we
		// first have to delete the eventinvitees
		int recipeID = recipeService.getRecipeID(recipe, session.getCurrentUser().getID());
		ArrayList<Integer> eventIDList = eventService.getEventsBasedOnRecipe(recipeID, session.getCurrentUser().getID());
		for(Integer i : eventIDList)
		{
			eventService.deleteEventFromInvites(i);
			eventService.deleteEvent(i);
		}
		recipeService.deleteRecipe(session.getCurrentUser().getID(), recipe);
	}
	
	// Events
	
	public void createEvent(String eventname, String date, String time, String recipeName) throws ServiceException
	{
		int recipeID = recipeService.getRecipeID(recipeName, session.getCurrentUser().getID());
		eventService.createEvent(eventname, date, time, session.getCurrentUser().getID(), recipeID);
	}
	
	/**
	 * Gets events belonging to the logged in user.
	 * @return
	 * @throws ServiceException
	 */
	public ArrayList<String> getEvents() throws ServiceException
	{
		return eventService.getMyEvents(session.getCurrentUser().getID());
	}
	
	public String getEventDetails(String eventName) throws ServiceException
	{
		return eventService.getEventDetails(eventName, session.getCurrentUser().getID());
	}
	
	public void InviteFriend(String eventname, String friendname) throws ServiceException, Exception
	{
		eventService.inviteUserToEvent(friendService.getFriendID(friendname), eventname, session.getCurrentUser().getID());
	}
	
	public ArrayList<String> getEventInvites() throws ServiceException
	{
		return eventService.getEventInvites(session.getCurrentUser().getID());
	}
	
	public void acceptEventInvite(String event) throws ServiceException
	{
		eventService.acceptEventInvite(event, session.getCurrentUser().getID());
	}
	
	/**
	 * Gets accepted events belonging to a certain user.
	 * @return
	 * @throws ServiceException 
	 */
	public ArrayList<String> getAcceptedEvents() throws ServiceException
	{
		return eventService.getAcceptedEvents(session.getCurrentUser().getID());		
	}
	
	public void deleteEvent(String event)
	{
		// Delete the invites associated with the event
		int eventID = eventService.getEventID(event, session.getCurrentUser().getID());
		eventService.deleteEventFromInvites(eventID);
		// Delete the event
		eventService.deleteEvent(event, session.getCurrentUser().getID());
	}
	
	public void deleteAcceptedEvent(String event, String hostname)
	{
		int hostID = userService.getUserID(hostname);
		int eventID = eventService.getEventID(event, hostID);
		eventService.deleteAcceptedEvent(eventID, session.getCurrentUser().getID());
	}
	
	
	public String getMyEventDetails(String event)
	{
		return eventService.getMyEventDetails(session.getCurrentUser().getID(), event);
	}
	
}
