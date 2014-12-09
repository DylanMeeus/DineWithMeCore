package net.itca.dwm.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.itca.dwm.core.DineWithMeFacade;

/**
 * 
 * @author Dylan
 * Main view (change panel to change window)
 * Singleton class to access the main view anywhere
 */
public class MainView extends JFrame
{

	
	private static final long serialVersionUID = 1L;
	private DineWithMeFacade facade = new DineWithMeFacade();
	private static MainView mainView;
	private JPanel currentPanel;
	private static JButton menuButton;
	private MainView()
	{
		
	}
	
	public static MainView getMainView()
	{
		if(mainView==null)
		{
			mainView = new MainView();
			mainView.setSize(600,400);
			mainView.setTitle("Dine with me");
			mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainView.setLayout(new BorderLayout());
			mainView.setVisible(true);		
		}
		return mainView;
	}
	

	public void setMainPanel(JPanel panel)
	{
		
		if(currentPanel != null)
		{
			mainView.remove(currentPanel);
		}
		currentPanel = panel;
		mainView.add(panel,BorderLayout.CENTER);
		mainView.revalidate();
		mainView.repaint();
	}
}
