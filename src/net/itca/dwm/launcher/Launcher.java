package net.itca.dwm.launcher;

import java.io.FileInputStream;
import java.util.Properties;

import net.itca.dwm.controller.MenuController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.view.MainView;
import net.itca.dwm.view.MenuPanel;

/**
 * 
 * @author Dylan
 * Used for console-based testing.
 */
public class Launcher
{
	public static void main(String[] args)
	{
		gui();
	}

	/**
	 * Start the GUI for the program.
	 */
	public static void gui()
	{
		MainView mv = MainView.getMainView();
		MenuPanel startPanel = new MenuPanel(new MenuController());
		mv.setMainPanel(startPanel);
		
		/*
		 * try
		{
			Properties props = new Properties();
			props.load(new FileInputStream("config/database.properties"));
			String username = props.getProperty("username");
			String pw = props.getProperty("password");
			userService.setUsername(username);
			userService.setPassword(pw);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}		
		 */
	}		
}
