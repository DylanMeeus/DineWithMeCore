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

import net.itca.dwm.controller.events.ViewAcceptedEventsController;
import net.itca.dwm.view.DetailsDialog;

public class ViewAcceptedEventsPanel extends JPanel
{

	private static final long serialVersionUID = 2283733819127283067L;
	private ViewAcceptedEventsController controller;
	private JButton menu, details, delete;
	private JList eventList;

	public ViewAcceptedEventsPanel(ViewAcceptedEventsController vaeController)
	{
		controller = vaeController;
		setup();
	}

	private void setup()
	{

		menu = new JButton("Menu");
		details = new JButton("Details");
		delete = new JButton("Delete");
		eventList = new JList();
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(details);
		buttonPanel.add(delete);
		
		JPanel combiPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());
		combiPanel.add(eventList, BorderLayout.CENTER);
		combiPanel.add(buttonPanel,BorderLayout.SOUTH);
		// Add to panel
		this.setLayout(new BorderLayout());
		this.add(combiPanel,BorderLayout.CENTER);
		this.add(menu, BorderLayout.WEST);
		addListeners();
	}

	private void addListeners()
	{

		this.addAncestorListener(new AncestorListener()
		{
			public void ancestorAdded(AncestorEvent arg0)
			{
				eventList.setListData(controller.getAcceptedEvents());
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
			public void actionPerformed(ActionEvent e)
			{
				controller.navigateMenu();
			}
		});

		details.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String selectEvent = eventList.getSelectedValue().toString();
				DetailsDialog detailsDialog = new DetailsDialog(controller.getEventDetails(selectEvent));				
				detailsDialog.show();
			}
		});

		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.deleteEvent(eventList.getSelectedValue().toString());
			}
		});
	}
}
