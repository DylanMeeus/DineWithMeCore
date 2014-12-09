package net.itca.dwm.view.recipes;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class RecipeDetailsDialog extends JDialog
{
	
	private static final long serialVersionUID = 1L;

	private JTextArea detailsLabel;
	public RecipeDetailsDialog(String text)
	{
		detailsLabel = new JTextArea(text);
		detailsLabel.setEditable(false);
		this.setLayout(new BorderLayout());
		this.add(detailsLabel, BorderLayout.CENTER);
		this.setSize(300,500);
	}
	
	
}
