package net.itca.dwm.view.recipes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.itca.dwm.controller.recipes.CreateRecipeController;

public class CreateRecipePanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private CreateRecipeController controller;
	private JButton menuButton, createButton;
	private JTextArea ingredients, instructions;
	private JLabel nameLabel;
	private JTextField nameField;

	public CreateRecipePanel(CreateRecipeController crc)
	{
		controller = crc;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		menuButton = new JButton("Menu");
		createButton = new JButton("Create");
		nameLabel = new JLabel("name");
		nameField = new JTextField(5);
		ingredients = new JTextArea();
		instructions = new JTextArea();

		JPanel textfieldsPanel = new JPanel();
		textfieldsPanel.setLayout(new GridLayout(4, 1));
		textfieldsPanel.add(new JLabel("ingredients"));
		textfieldsPanel.add(ingredients);
		textfieldsPanel.add(new JLabel("instructions"));
		textfieldsPanel.add(instructions);
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(2, 1));
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		JPanel combiPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());
		combiPanel.add(namePanel, BorderLayout.NORTH);
		combiPanel.add(textfieldsPanel, BorderLayout.CENTER);
		combiPanel.add(createButton, BorderLayout.SOUTH);
		// Add buttons to layout
		this.add(menuButton, BorderLayout.WEST);
		this.add(combiPanel, BorderLayout.CENTER);
		addListeners();
	}

	private void addListeners()
	{
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
				String recipeName = nameField.getText();
				String recipeIngr = ingredients.getText();
				String recipeInstr = instructions.getText();
				controller.createRecipe(recipeName, recipeIngr, recipeInstr);
			}
		});
	}
}
