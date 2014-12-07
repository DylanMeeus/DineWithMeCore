package net.itca.dwm.view.events;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.events.CreateEventController;

public class CreateEventPanel extends JPanel
{

	private JButton menuButton, createButton;
	private JLabel nameLabel, dateLabel, recipeNameLabel;
	private JTextField nameField, dateField;
	private JComboBox recipeBox;
	private CreateEventController controller;

	public CreateEventPanel(CreateEventController cepController)
	{
		controller = cepController;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		menuButton = new JButton("Menu");
		createButton = new JButton("Create");
		// Instantiate the javax components
		JPanel dataPanel = new JPanel();
		nameLabel = new JLabel("name");
		dateLabel = new JLabel("date");
		recipeNameLabel = new JLabel("Recipe name");
		nameField = new JTextField(10);
		dateField = new JTextField(4);
		recipeBox = new JComboBox();
		dataPanel.setLayout(new GridLayout(10, 1));
		
		dataPanel.add(nameLabel);
		dataPanel.add(nameField);
		dataPanel.add(dateLabel);
		dataPanel.add(dateField);
		dataPanel.add(recipeNameLabel);
		dataPanel.add(recipeBox);
		dataPanel.add(createButton);
		// Add to main layout
		this.add(menuButton, BorderLayout.WEST);
		this.add(dataPanel, BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{
		this.addAncestorListener(new AncestorListener()
		{
			public void ancestorAdded(AncestorEvent ae)
			{

				Vector<String> userrecipes = controller.getRecipes();
				for (int item = 0; item < userrecipes.size(); item++)
				{
					recipeBox.addItem(userrecipes.get(item));
				}
			}

			public void ancestorMoved(AncestorEvent ae)
			{
				// TODO Auto-generated method stub

			}

			public void ancestorRemoved(AncestorEvent ae)
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
		
		createButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String eventName = nameField.getText();
				String date = dateField.getText();
				String recipeName = recipeBox.getSelectedItem().toString();
				controller.createEvent(eventName, date, recipeName);
			}
		});
	}
}
