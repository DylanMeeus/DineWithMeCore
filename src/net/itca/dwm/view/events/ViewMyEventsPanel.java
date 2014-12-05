package net.itca.dwm.view.events;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.events.ViewMyEventsController;

public class ViewMyEventsPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private ViewMyEventsController controller;

	private JButton menuButton, detailButton, deleteButton;
	private JList eventList;

	public ViewMyEventsPanel(ViewMyEventsController vmeController)
	{
		controller = vmeController;
		setup();
	}

	private void setup()
	{
		menuButton = new JButton("Menu");
		detailButton = new JButton("Details");
		deleteButton = new JButton("Delete");
		eventList = new JList();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		buttonPanel.add(detailButton);
		buttonPanel.add(deleteButton);

		JPanel combiPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());
		combiPanel.add(eventList, BorderLayout.CENTER);
		combiPanel.add(buttonPanel, BorderLayout.SOUTH);
		// Add to layout
		this.setLayout(new BorderLayout());
		this.add(menuButton, BorderLayout.WEST);
		this.add(combiPanel, BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{

		this.addAncestorListener(new AncestorListener()
		{

			public void ancestorAdded(AncestorEvent arg0)
			{
				eventList.setListData(controller.getEvents());
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
			public void actionPerformed(ActionEvent arg0)
			{
				controller.navigateMenu();
			}
		});

		detailButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String details = controller.getDetails();	
			}
		});
	}
}
