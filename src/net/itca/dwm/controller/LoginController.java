package net.itca.dwm.controller;

import net.itca.dwm.core.DineWithMeFacade;

public class LoginController
{
	private DineWithMeFacade facade;
	
	public LoginController(DineWithMeFacade dwmfacade)
	{
		facade = dwmfacade;
	}
	
	
	public void login(String username, String password)
	{
		String pwEncrypted = facade.encrypt(password);
		facade.login(username, pwEncrypted);
	}
}
