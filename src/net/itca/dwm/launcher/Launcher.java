package net.itca.dwm.launcher;

import net.itca.dwm.data.Database;

/**
 * 
 * @author Dylan
 * Used for console-based testing.
 */
public class Launcher
{
	public static void main(String[] args)
	{
		System.out.println("setting up database");
		Database db = new Database();
		try
		{
			db.createUser("Vasco", "vasco", "vasco");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
