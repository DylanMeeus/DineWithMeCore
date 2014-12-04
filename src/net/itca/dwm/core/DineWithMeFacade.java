package net.itca.dwm.core;

import java.util.ArrayList;

import net.itca.dwm.data.FriendService;
import net.itca.dwm.data.RecipeService;
import net.itca.dwm.data.UserConnection;
import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;
import net.itca.dwm.core.ActiveSession;

/**
 * 
 * @author Dylan Providing a single-point of access to the dine with me
 *         application
 */
public class DineWithMeFacade
{
	// TODO: Create service factory
	private ActiveSession session = ActiveSession.getActiveSession();
	public boolean login(String username, String password)
	{
		UserConnection userConnection = new UserConnection();
		return userConnection.login(username, password);
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

	public void createUser(String username, String password, String firstname, String lastname) throws DatabaseException, PasswordException
	{
		UserConnection userConnection = new UserConnection();
		userConnection.createUser(username, firstname, lastname, password);
	}
	
	public void setCurrentUser(User current)
	{
		session.setCurrentUser(current);
	}
	
	public User getCurrentUser()
	{
		return session.getCurrentUser();
	}
	
	public int getUserID(String user)
	{
		UserConnection userConnection = new UserConnection();
		return userConnection.getUserID(user);	
	}
	
	public void addFriend(String username)
	{
		FriendService friendService = new FriendService();
		friendService.addFriend(session.getCurrentUser().getID(), username);
	}
	
	public boolean acceptFriend(String friend)
	{
		FriendService friendService = new FriendService();
		return friendService.acceptFriend(session.getCurrentUser().getID(),friend);
	}
	
	public ArrayList<String> getFriendsByUserID()
	{
		FriendService friendService = new FriendService();
		return friendService.getFriends(session.getCurrentUser().getID());
	}
	
	public ArrayList<String> getFriendInvites()
	{
		FriendService friendService = new FriendService();
		return friendService.getFriendInvites(session.getCurrentUser().getID());
	}

	public boolean declineRequest(String friend) throws Exception
	{
		FriendService friendService = new FriendService();
		return friendService.declineRequest(session.getCurrentUser().getID(),friend);		
	}
	
	
	public void createRecipe(String name, String ingredients, String instructions, int people)
	{
		RecipeService recipeService = new RecipeService();
		recipeService.createRecipe(name, ingredients, instructions, session.getCurrentUser().getID(), people);
	}
	
	public ArrayList<String> getRecipes()
	{
		RecipeService recipeService = new RecipeService();
		return recipeService.getRecipesByID(session.getCurrentUser().getID());		
	}
	
	public String encodeForDB(String toEncode)
	{
		TextEncoder encoder = new TextEncoder();
		return encoder.encode(toEncode);
	}
	
	public String getRecipeDetails(String recipeName)
	{
		TextEncoder decoder = new TextEncoder();
		RecipeService recipeService = new RecipeService();
		return decoder.decode(recipeService.getRecipeDetails(session.getCurrentUser().getID(), recipeName));
	}
	
	public void deleteRecipe(String recipe)
	{
		RecipeService recipeService = new RecipeService();
		recipeService.deleteRecipe(session.getCurrentUser().getID(), recipe);
	}
}
