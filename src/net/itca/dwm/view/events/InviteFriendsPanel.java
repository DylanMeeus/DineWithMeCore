package net.itca.dwm.view.events;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.events.InviteFriendsController;

public class InviteFriendsPanel extends JPanel
{
	private JButton menu, sendInvites;
	private JComboBox eventBox;
	private JList friendsList;
	private InviteFriendsController controller;

	public InviteFriendsPanel(InviteFriendsController ivfController)
	{
		controller = ivfController;
		setup();
	}

	private void setup()
	{
		friendsList = new JList();
		System.out.println("List set up");
		menu = new JButton("Menu");
		sendInvites = new JButton("Send invites");
		eventBox = new JComboBox();
		JPanel combiPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());

		combiPanel.add(eventBox, BorderLayout.NORTH);
		combiPanel.add(friendsList, BorderLayout.CENTER);
		combiPanel.add(sendInvites, BorderLayout.SOUTH);

		// Add to mainlayout
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.WEST);
		this.add(combiPanel, BorderLayout.CENTER);

		addListeners();
	}

	private void addListeners()
	{
		this.addAncestorListener(new AncestorListener()
		{

			public void ancestorAdded(AncestorEvent arg0)
			{
				// Fill combobox
				ArrayList<String> myEvents = controller.getMyEvents();
				for (String event : myEvents)
				{
					eventBox.addItem(event);
				}
				// Fill jlist
				Vector<String> friends = controller.getFriends();
				friendsList.setListData(friends);

			}

			public void ancestorMoved(AncestorEvent arg0)
			{
			}

			public void ancestorRemoved(AncestorEvent arg0)
			{

			}

		});

		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateMenu();
			}
		});

		sendInvites.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				String event = eventBox.getSelectedItem().toString();
				@SuppressWarnings("deprecation")
				Object[] friendsObject = friendsList.getSelectedValues();
				
				for (int i = 0; i < friendsObject.length; i++)
				{
					controller.inviteFriend(event, friendsObject[i].toString());
				}

			}

		});
	}

}
