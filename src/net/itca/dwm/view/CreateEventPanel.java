package net.itca.dwm.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class CreateEventPanel extends JPanel
{

	private JButton menuButton, createButton;
	private JLabel nameLabel, dateLabel, recipeNameLabel;
	private JTextField nameField, dateField;
	private JComboBox recipeBox;

	public CreateEventPanel()
	{
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
		dateLabel = new JLabel("data");
		recipeNameLabel = new JLabel("Recipe name");
		nameField = new JTextField(10);
		dateField = new JTextField(4);
		recipeBox = new JComboBox();
		dataPanel.setLayout(new GridLayout(10, 1));
		;
		dataPanel.add(nameLabel);
		dataPanel.add(nameField);
		dataPanel.add(dateLabel);
		dataPanel.add(dateField);
		dataPanel.add(recipeNameLabel);
		dataPanel.add(recipeBox);
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
	}
}
