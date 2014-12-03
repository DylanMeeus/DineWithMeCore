package net.itca.dwm.core;

public class User
{
	private int userID;
	private String username;
	
	public User(String user, int ID) // CurrentUser
	{
		username = user;
		userID = ID;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public int getID()
	{
		return userID;
	}
	public String getFriends()
	{
		return "";
	}
}
