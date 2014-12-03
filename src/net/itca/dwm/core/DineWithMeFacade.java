package net.itca.dwm.core;

import java.util.ArrayList;

import net.itca.dwm.data.FriendService;
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
	
	public ArrayList<String> getFriendsByID(int id)
	{
		return null;
	}
	
	public ArrayList<String> getFriendInvites()
	{
		FriendService friendService = new FriendService();
		return friendService.getFriendInvites(session.getCurrentUser().getID());
	}

}
