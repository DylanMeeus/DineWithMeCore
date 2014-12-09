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
	
	public DineWithMeFacade()
	{
		serviceFactory = new ServiceFactory();
	}
	
	public boolean login(String username, String password) throws ServiceException
	{
		return ((UserService)serviceFactory.getService(ServiceType.USERSERVICE)).login(username, password);
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

	public void createUser(String username, String password, String firstname, String lastname) throws DatabaseException, PasswordException, ServiceException
	{
		((UserService)serviceFactory.getService(ServiceType.USERSERVICE)).createUser(username, firstname, lastname, password);
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
		return ((UserService)serviceFactory.getService(ServiceType.USERSERVICE)).getUserID(user);	
	}
	
	public void addFriend(String username) throws ServiceException
	{
		FriendService friendService = (FriendService) serviceFactory.getService(ServiceType.FRIENDSERVICE);
		friendService.addFriend(session.getCurrentUser().getID(), username);
	}
	
	public boolean acceptFriend(String friend) throws ServiceException
	{
		return ((FriendService)serviceFactory.getService(ServiceType.FRIENDSERVICE)).acceptFriend(session.getCurrentUser().getID(), friend);
	}
	
	public ArrayList<String> getFriendsByUserID() throws ServiceException
	{
		return ((FriendService)serviceFactory.getService(ServiceType.FRIENDSERVICE)).getFriends(session.getCurrentUser().getID());
	}
	
	public ArrayList<String> getFriendInvites() throws ServiceException
	{
		return ((FriendService)serviceFactory.getService(ServiceType.FRIENDSERVICE)).getFriendInvites(session.getCurrentUser().getID());
	}

	public boolean declineRequest(String friend) throws Exception
	{
		return ((FriendService)serviceFactory.getService(ServiceType.FRIENDSERVICE)).declineRequest(session.getCurrentUser().getID(),friend);		
	}
	
	
	public void createRecipe(String name, String ingredients, String instructions, int people) throws ServiceException
	{
		((RecipeService)serviceFactory.getService(ServiceType.RECIPESERVICE)).createRecipe(name, ingredients, instructions, session.getCurrentUser().getID(), people);
	}
	
	public ArrayList<String> getRecipes() throws ServiceException
	{
		return ((RecipeService)serviceFactory.getService(ServiceType.RECIPESERVICE)).getRecipesByID(session.getCurrentUser().getID());		
	}
	
	public String encodeForDB(String toEncode)
	{
		TextEncoder encoder = new TextEncoder();
		return encoder.encode(toEncode);
	}
	
	public String getRecipeDetails(String recipeName) throws ServiceException
	{
		TextEncoder decoder = new TextEncoder();
		RecipeService recipeService = new RecipeService();
		return decoder.decode(((RecipeService)serviceFactory.getService(ServiceType.RECIPESERVICE)).getRecipeDetails(session.getCurrentUser().getID(), recipeName));
	}
	
	public void deleteRecipe(String recipe) throws ServiceException
	{
		((RecipeService)serviceFactory.getService(ServiceType.RECIPESERVICE)).deleteRecipe(session.getCurrentUser().getID(), recipe);
	}
	
	// Events
	
	public void createEvent(String eventname, String date, String time, String recipeName) throws ServiceException
	{
		int recipeID = ((RecipeService)serviceFactory.getService(ServiceType.RECIPESERVICE)).getRecipeID(recipeName, session.getCurrentUser().getID());
		((EventService)serviceFactory.getService(ServiceType.EVENTSERVICE)).createEvent(eventname, date, time, session.getCurrentUser().getID(), recipeID);
	}
	
	public ArrayList<String> getEvents() throws ServiceException
	{
		return ((EventService)serviceFactory.getService(ServiceType.EVENTSERVICE)).getMyEvents(session.getCurrentUser().getID());
	}
	
	public String getEventDetails()
	{
		return "Details";
	}
	
	public void InviteFriend(String eventname, String friendname) throws ServiceException, Exception
	{
		((EventService)serviceFactory.getService(ServiceType.EVENTSERVICE)).inviteUserToEvent(((FriendService)serviceFactory.getService(ServiceType.FRIENDSERVICE)).getFriendID(friendname), eventname, session.getCurrentUser().getID());
	}
	
	public ArrayList<String> getEVentInvites() throws ServiceException
	{
		return ((EventService)serviceFactory.getService(ServiceType.EVENTSERVICE)).getEventInvites(session.getCurrentUser().getID());
	}
	
	public void acceptEventInvite(String event) throws ServiceException
	{
		((EventService)serviceFactory.getService(ServiceType.EVENTSERVICE)).acceptEventInvite(event, session.getCurrentUser().getID());
	}
}
