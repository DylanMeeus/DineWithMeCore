package net.itca.dwm.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.itca.dwm.controller.MenuController;

public class MenuPanel extends JPanel
{
	private JButton loginScreen, createUserScreen;
	private MenuController controller;
	public MenuPanel(MenuController mc)
	{
		controller = mc;
		setup();
	}
	
	private void setup()
	{
		this.setLayout(new GridLayout(3,1));
		loginScreen = new JButton("login");
		createUserScreen = new JButton("create user");
		this.add(loginScreen);
		this.add(createUserScreen);
		addListeners();
	}
	
	private void addListeners()
	{
		loginScreen.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateLogin();
			}
			
		});
		
		createUserScreen.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateCreateUser();
			}
			
		});
	}
}
