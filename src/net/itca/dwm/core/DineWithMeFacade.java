package net.itca.dwm.core;

/**
 * 
 * @author Dylan
 * Providing a single-point of access to the dine with me application
 */
public class DineWithMeFacade
{
	public void login(String username, String password){}
	
	public String encrypt(String encrypt)
	{
		Encrypter encrypter = new Encrypter(); // Initialize it here, not as class variable. Not used often enough to get heap space. Rather put it on the stack (escape analysis)
		return encrypter.encrypt(encrypt);
	}
}
