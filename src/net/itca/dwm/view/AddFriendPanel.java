package net.itca.dwm.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.itca.dwm.controller.AddFriendController;

public class AddFriendPanel extends JPanel
{
	private AddFriendController controller;
	private JButton menu, addFriend;
	private JTextField username;
	private JLabel usernameLabel;

	public AddFriendPanel(AddFriendController afc)
	{
		controller = afc;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		menu = new JButton("menu");
		this.add(menu, BorderLayout.WEST);
		JPanel dataPanel = new JPanel();
		usernameLabel = new JLabel("username");
		username = new JTextField(10);
		addFriend = new JButton("add friend");
		dataPanel.setLayout(new GridLayout(10, 1));
		dataPanel.add(usernameLabel);
		dataPanel.add(username);
		dataPanel.add(addFriend);
		this.add(dataPanel,BorderLayout.CENTER);
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

		addFriend.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
