package net.itca.dwm.exceptions;

/**
 * Thrown if the password is wrong
 * @author Dylan
 * 
 */
public class PasswordException extends Exception
{

	public PasswordException()
	{
		super();
	}
	
	public PasswordException(String message)
	{
		super(message);
	}
}
