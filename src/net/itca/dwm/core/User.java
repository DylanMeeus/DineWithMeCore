package net.itca.dwm.core;

/**
 * Class which represents a user.
 * @author Dylan
 *
 */
public class User
{
	private int userID;
	private String username;
	private Status userStatus;
	
	
	public User(String user, int ID) // CurrentUser
	{
		username = user;
		userID = ID;
		userStatus = Status.OFFLINE; // default to offline.
	}
	
	/**
	 * Returns the users username as it is found in the database
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * Returns the users ID as it is in the database
	 * @return
	 */
	public int getID()
	{
		return userID;
	}
	
	public void setStatus(Status status)
	{
		userStatus = status;
	}
	
	public Status getUserStatus()
	{
		return userStatus;
	}
}
