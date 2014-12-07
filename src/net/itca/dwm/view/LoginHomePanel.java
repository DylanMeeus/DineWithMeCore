package net.itca.dwm.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.itca.dwm.controller.LoginHomeController;

public class LoginHomePanel extends JPanel
{
	JButton logout, addFriend, viewFriends, viewMyEvents, viewEventInvites, createEvent, viewRecipes, createRecipes,
			viewFriendInvites;
	LoginHomeController lhcController; // Not the hadron collider! ;)

	public LoginHomePanel(LoginHomeController controller)
	{
		lhcController = controller;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		logout = new JButton("logout");
		addFriend = new JButton("add friend");
		viewFriends = new JButton("view friends");
		viewMyEvents = new JButton("View my events");
		viewEventInvites = new JButton("View event invites");
		createEvent = new JButton("Create event");
		viewRecipes = new JButton("View recipes");
		createRecipes = new JButton("Create recipes");
		viewFriendInvites = new JButton("View friend invites");
		// Add them to the panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(10, 1));
		// Logout
		this.add(logout, BorderLayout.WEST);
		// Button
		buttonPanel.add(addFriend);
		buttonPanel.add(viewFriends);
		buttonPanel.add(viewFriendInvites);
		buttonPanel.add(createEvent);
		buttonPanel.add(viewMyEvents);
		buttonPanel.add(viewEventInvites);
		buttonPanel.add(viewRecipes);
		buttonPanel.add(createRecipes);

		this.add(buttonPanel, BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lhcController.logout();
			}
		});

		addFriend.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lhcController.navigateAddFriend();
			}
		});
		viewFriends.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lhcController.navigateViewFriends();
			}
		});
		viewMyEvents.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lhcController.navigateViewMyEvents();
			}
		});

		createRecipes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lhcController.navigateCreateRecipe();
			}
		});

		createEvent.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				lhcController.navigateCreateEvent();
			}
		});

		viewRecipes.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				lhcController.navigateViewRecipes();
			}
		});

		viewFriendInvites.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				lhcController.navigateViewFriendInvites();
			}

		});
		viewMyEvents.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				lhcController.navigateViewMyEvents();
			}

		});
		viewEventInvites.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				lhcController.navigateViewEventInvites();
			}
		});
	}
}
