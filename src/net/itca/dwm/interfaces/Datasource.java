package net.itca.dwm.interfaces;

import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;


/**
 * 
 * @author Dylan
 * Interface that defines what the datasource for saving / editing application objects needs to implement
 */

public interface Datasource
{
	
	/**
	 * Checks the username and password against the database entry
	 * Returns true if login is succesful
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
	/**
	 * Create a user with the given username and password.
	 * This method is NOT responsible for encryption!
	 * Return true if user created succesfully, false otherwise
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean createUser(String username, String nickname, String password) throws DatabaseException, PasswordException;

	/**
	 * Add a friend-relationship between two users
	 * @param username1
	 * @param username2
	 * @return
	 */
	public boolean addFriend(String user, String friend);
	
	/**
	 * Accept a friend request. (Changes boolean value in the friends table) 
	 * @param user
	 * @param friend
	 * @return
	 */
	public boolean acceptFriend(String user, String friend);
	
}
