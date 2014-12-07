package net.itca.dwm.view.friends;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.friends.FriendInviteController;

public class FriendInvitesPanel extends JPanel
{
	private FriendInviteController controller;
	private JButton menuButton, acceptButton, declineButton;
	private JList inviteList;

	public FriendInvitesPanel(FriendInviteController ficontroller)
	{
		controller = ficontroller;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		menuButton = new JButton("Menu");
		acceptButton = new JButton("Accept");
		declineButton = new JButton("Decline");
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(acceptButton);
		buttonPanel.add(declineButton);
		dataPanel.add(buttonPanel, BorderLayout.SOUTH);
		inviteList = new JList();
		dataPanel.add(inviteList, BorderLayout.CENTER);

		// Add to panel
		this.add(dataPanel, BorderLayout.CENTER);
		this.add(menuButton, BorderLayout.WEST);
		addListeners();
	}

	private void addListeners()
	{
		this.addAncestorListener(new AncestorListener()
		{

			public void ancestorAdded(AncestorEvent arg0)
			{
				controller.getFriendInvites();
				inviteList.setListData(controller.getFriendInvites());
			}

			public void ancestorMoved(AncestorEvent arg0)
			{
				// TODO Auto-generated method stub

			}

			public void ancestorRemoved(AncestorEvent arg0)
			{
				// TODO Auto-generated method stub

			}
		});

		menuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateMenu();
			}
		});

		acceptButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.acceptFriend(inviteList.getSelectedValue().toString());
			}
		});
		
		declineButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.declineRequest(inviteList.getSelectedValue().toString());
			}
		});
	
	}

}
