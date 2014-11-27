package net.itca.dwm.exceptions;

/**
 * 
 * @author Dylan
 *	Class representing a custom exception (user not found)
 */
public class UserNotFoundException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Thrown when the user is not present in the dataset.
	 */
	public UserNotFoundException()
	{
		super();
	}
	
	public UserNotFoundException(String message)
	{
		super(message);
	}

}
