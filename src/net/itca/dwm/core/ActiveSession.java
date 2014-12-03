package net.itca.dwm.core;

/**
 * An active session that guards data throughout the session.
 * Can be used to cache data.
 * Singleton.
 * @author Dylan
 *
 */

public class ActiveSession
{
	private static ActiveSession session;
	private User currentUser;
	private ActiveSession()
	{
		
	}
	
	public static ActiveSession getActiveSession()
	{
		if(session==null)
		{
			session = new ActiveSession();
		}
		return session;
	}
	
	public void setCurrentUser(User current)
	{
		currentUser = current;
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
}
