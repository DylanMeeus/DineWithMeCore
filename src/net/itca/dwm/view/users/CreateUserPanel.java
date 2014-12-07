package net.itca.dwm.view.users;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.itca.dwm.controller.users.CreateUserController;

/**
 * 
 * @author Dylan CreateUserPanel is a JPanel with options to create users.
 * 
 */
public class CreateUserPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JButton create, menu;
	private JLabel usernameLabel, passwordLabel, firstLabel, lastLabel;
	private JTextField username, firstname, lastname;
	private JPasswordField password;
	private CreateUserController controller;

	public CreateUserPanel(CreateUserController cuserController)
	{
		controller = cuserController;
		setup();
	}

	private void setup()
	{
		int textFieldLength = 10;
		usernameLabel = new JLabel("username");
		passwordLabel = new JLabel("password");
		firstLabel = new JLabel("first name");
		lastLabel = new JLabel("last name");
		username = new JTextField(textFieldLength);
		password = new JPasswordField(textFieldLength);
		firstname = new JTextField(textFieldLength);
		lastname = new JTextField(textFieldLength);
		create = new JButton("create");
		menu = new JButton("menu");
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(10, 1));
		dataPanel.add(usernameLabel);
		dataPanel.add(username);
		dataPanel.add(passwordLabel);
		dataPanel.add(password);
		dataPanel.add(firstLabel);
		dataPanel.add(firstname);
		dataPanel.add(lastLabel);
		dataPanel.add(lastname);
		dataPanel.add(create);

		this.setLayout(new BorderLayout());
		this.add(dataPanel, BorderLayout.CENTER);
		this.add(menu, BorderLayout.WEST);
		addListeners();
	}

	private void addListeners()
	{
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateMenu();
			}
		});

		create.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				String usernameString = username.getText();
				String passwordString = password.getText();
				String firstString = firstname.getText();
				String lastString = lastname.getText();
				controller.createUser(usernameString, passwordString, firstString, lastString);
			}

		});
	}
}
