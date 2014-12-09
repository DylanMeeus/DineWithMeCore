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

import net.itca.dwm.controller.friends.ViewFriendsController;

public class ViewFriendsPanel extends JPanel
{
	private JList friendList;
	private JButton menuButton, removeButton, detailButton;
	private ViewFriendsController controller;

	public ViewFriendsPanel(ViewFriendsController vfController)
	{
		controller = vfController;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		friendList = new JList();
		menuButton = new JButton("Menu");
		removeButton = new JButton("Remove");
		detailButton = new JButton("Details"); // fill JDialog with info about
		this.add(menuButton, BorderLayout.WEST);
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		dataPanel.add(friendList,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(detailButton);
		buttonPanel.add(removeButton);
		dataPanel.add(buttonPanel,BorderLayout.SOUTH);
		this.add(dataPanel,BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{
		
		this.addAncestorListener(new AncestorListener()
		{

			public void ancestorAdded(AncestorEvent arg0)
			{
				friendList.setListData(controller.getFriends());
			}

			public void ancestorMoved(AncestorEvent arg0)
			{
			
			}

			public void ancestorRemoved(AncestorEvent arg0)
			{
			}
			
		});
		
		menuButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.navigateMenu();
			}	
		});
	}
}
