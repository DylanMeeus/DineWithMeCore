package net.itca.dwm.view.events;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.events.ViewEventInvitesController;

public class ViewEventInvitesPanel extends JPanel
{

	private ViewEventInvitesController controller;
	private JList<String> invites;
	private JButton accept, decline, menu;

	public ViewEventInvitesPanel(ViewEventInvitesController veicontroller)
	{
		controller = veicontroller;
		setup();
	}

	private void setup()
	{
		invites = new JList<String>();
		menu = new JButton("Menu");
		accept = new JButton("Accept");
		decline = new JButton("Decline");

		JPanel combiPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(accept);
		buttonPanel.add(decline);
		combiPanel.add(invites, BorderLayout.CENTER);
		combiPanel.add(buttonPanel, BorderLayout.SOUTH);
		// add to main panel
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.WEST);
		this.add(combiPanel, BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.navigateMenu();
			}
		});

		accept.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				controller.acceptInvite(invites.getSelectedValue());
			}
		
		});

		decline.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
			}
		
		});

		this.addAncestorListener(new AncestorListener()
		{

			public void ancestorAdded(AncestorEvent arg0)
			{
				Vector<String> eventinvites = controller.getEventInvites();
				invites.setListData(eventinvites);
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
	}
}
