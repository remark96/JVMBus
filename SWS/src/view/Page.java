package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Person;

public abstract class Page {
	protected MainWindow mainWindow;
	protected JLabel nameOfFaculty;
	protected JLabel nameOfUser;
	
	protected JPanel northPanel;
	protected JPanel centerPanel;
	protected JPanel eastPanel;
	
	protected VerticalMenuBar vmb;
	
	public Page(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.northPanel = new JPanel(new GridLayout(2, 1));
		this.centerPanel = new JPanel(new GridLayout(3,1));
		
		this.eastPanel = new JPanel(new BorderLayout());
		
		this.mainWindow.getContentPane().removeAll();
		
		nameOfFaculty = new JLabel(mainWindow.getController().getFaculty().getName(), JLabel.CENTER); 
		nameOfFaculty.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		nameOfFaculty.setForeground(Color.BLUE);
		
		nameOfUser = new JLabel("", JLabel.CENTER); 
		nameOfUser.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		nameOfUser.setForeground(Color.BLUE);
		
		northPanel.add(nameOfFaculty);
		northPanel.add(nameOfUser);
		
		JPanel tmp = new JPanel(new GridLayout(5, 1, 0, 15)); 
		
		vmb = new VerticalMenuBar();
	
		tmp.add(vmb);
		eastPanel.add(tmp, BorderLayout.NORTH);
		
		mainWindow.getContentPane().add(northPanel, BorderLayout.NORTH);
		mainWindow.getContentPane().add(centerPanel, BorderLayout.CENTER);
		mainWindow.getContentPane().add(eastPanel, BorderLayout.EAST);
		
	}

	public JPanel getNorthPanel() { return northPanel; }
	public void setNorthPanel(JPanel northPanel) { this.northPanel = northPanel; }

	public JPanel getCenterPanel() { return centerPanel; }
	public void setCenterPanel(JPanel centerPanel) { this.centerPanel = centerPanel; }

	public JPanel getEastPanel() { return eastPanel; }
	public void setEastPanel(JPanel eastPanel) { this.eastPanel = eastPanel; }
	
	public void fillPage(Person person) {
		funcForNorthPanel(person);
		funcForCenterPanel(person);
		funcForEastPanel(person);
	}
	
	public abstract void funcForNorthPanel(Person person);
	
	public abstract void funcForCenterPanel(Person person);
	
	public abstract void funcForEastPanel(Person person);
}
