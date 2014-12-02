package net.itca.dwm.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.itca.dwm.controller.LoginController;

public class LoginPanel extends JPanel
{

	private JLabel usernameLabel, passwordLabel;
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton;
	private LoginController controller;
	
	public LoginPanel(LoginController loginController)
	{
		controller = loginController;
		setup();
	}
	
	private void setup()
	{
		usernameLabel = new JLabel("username");
		passwordLabel = new JLabel("password");
		username = new JTextField(10);
		password = new JPasswordField(10);
		loginButton = new JButton("login");
		loginButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				controller.login("hello", "world");
			}
			
		});
		this.setLayout(new FlowLayout());
		
		this.add(usernameLabel);
		this.add(username);
		this.add(passwordLabel);
		this.add(password);
		this.add(loginButton);
	}
}
