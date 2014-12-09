package net.itca.dwm.view.recipes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import net.itca.dwm.controller.recipes.ViewRecipesController;

public class ViewRecipesPanel extends JPanel
{

	ViewRecipesController controller;

	private JList recipeList;
	private JButton menuButton, detailButton, deleteButton;

	public ViewRecipesPanel(ViewRecipesController VRC) // OLD VRC!
	{
		controller = VRC;
		setup();
	}

	private void setup()
	{
		this.setLayout(new BorderLayout());
		menuButton = new JButton("Menu");
		detailButton = new JButton("View details");
		deleteButton = new JButton("Delete");
		recipeList = new JList();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(detailButton);
		buttonPanel.add(deleteButton);
		JPanel combiPanel = new JPanel();
		combiPanel.setLayout(new BorderLayout());
		combiPanel.add(recipeList, BorderLayout.CENTER);
		combiPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Add to main panel
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
				recipeList.setListData(controller.getRecipes());
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
				String details = controller.getDetails(recipeList
						.getSelectedValue().toString());
				RecipeDetailsDialog detailDialog = new RecipeDetailsDialog(
						details);
				detailDialog.show();
			}
		});

		deleteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				controller.deleteRecipe(recipeList.getSelectedValue().toString());
			}
		});
	}
}
