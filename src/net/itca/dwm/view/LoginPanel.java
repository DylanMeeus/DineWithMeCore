package net.itca.dwm.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
	private JButton loginButton, menuButton;
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
		menuButton = new JButton("menu");

		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new FlowLayout());
		dataPanel.add(usernameLabel);
		dataPanel.add(username);
		dataPanel.add(passwordLabel);
		dataPanel.add(password);
		dataPanel.add(loginButton);
		this.setLayout(new BorderLayout());
		this.add(dataPanel, BorderLayout.CENTER);
		this.add(menuButton, BorderLayout.WEST);
		addListeners();
	}

	private void addListeners()
	{
		menuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateToMenu();
			}

		});

		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String usernameString = username.getText();
				String passwordString = password.getText();
				System.out.println(controller.login(usernameString,passwordString));
			}
		});

	}
}
