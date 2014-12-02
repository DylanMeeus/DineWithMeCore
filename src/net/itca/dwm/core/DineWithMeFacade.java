package net.itca.dwm.core;

import net.itca.dwm.data.UserConnection;
import net.itca.dwm.exceptions.DatabaseException;
import net.itca.dwm.exceptions.PasswordException;

/**
 * 
 * @author Dylan Providing a single-point of access to the dine with me
 *         application
 */
public class DineWithMeFacade
{
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

}
