package net.itca.dwm.launcher;

import net.itca.dwm.controller.LoginController;
import net.itca.dwm.controller.MenuController;
import net.itca.dwm.core.DineWithMeFacade;
import net.itca.dwm.data.Database;
import net.itca.dwm.view.LoginPanel;
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

	public static void gui()
	{
		MainView mv = MainView.getMainView();
		MenuPanel startPanel = new MenuPanel(new MenuController(new DineWithMeFacade()));
		mv.setMainPanel(startPanel);
	}		
}
