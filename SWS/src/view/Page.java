package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import model.Faculty;
import model.Person;

@SuppressWarnings("serial")
public abstract class Page extends JPanel {
	protected Faculty faculty;
	
	protected JLabel nameOfFaculty;
	protected JLabel nameOfUser;
	
	protected JTable table;
	
	protected JPanel northPanel;
	protected JScrollPane centerPanel;
	protected JPanel eastPanel;
	
	protected VerticalMenuBar vmb;
	
	public Page(Faculty faculty) {
		setLayout(new BorderLayout());
		
		this.faculty = faculty;
		
		this.table = new JTable();
		
		this.northPanel = new JPanel(new GridLayout(2, 1));
		this.centerPanel = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		
		this.eastPanel = new JPanel(new BorderLayout());
		
		nameOfFaculty = new JLabel(this.faculty.getName(), JLabel.CENTER); 
		nameOfFaculty.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		nameOfFaculty.setForeground(Color.BLUE);
		
		nameOfUser = new JLabel("", JLabel.CENTER); 
		nameOfUser.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		nameOfUser.setForeground(Color.BLUE);
		
		northPanel.add(nameOfFaculty);
		northPanel.add(nameOfUser);
		
		vmb = new VerticalMenuBar(faculty, this);
	
		//tmp.add(vmb);
		eastPanel.add(vmb, BorderLayout.NORTH);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(eastPanel, BorderLayout.EAST);
		
	}

	public JPanel getNorthPanel() { return northPanel; }
	public void setNorthPanel(JPanel northPanel) { this.northPanel = northPanel; }

	public JScrollPane getCenterPanel() { return centerPanel; }
	public void setCenterPanel(JScrollPane centerPanel) { this.centerPanel = centerPanel; }

	public JPanel getEastPanel() { return eastPanel; }
	public void setEastPanel(JPanel eastPanel) { this.eastPanel = eastPanel; }
	
	public Faculty getFaculty() { return faculty; }
	public void setFaculty(Faculty faculty) { this.faculty = faculty; }

	public JLabel getNameOfFaculty() { return nameOfFaculty; }
	public void setNameOfFaculty(JLabel nameOfFaculty) { this.nameOfFaculty = nameOfFaculty; }

	public JLabel getNameOfUser() { return nameOfUser; }
	public void setNameOfUser(JLabel nameOfUser) { this.nameOfUser = nameOfUser; }

	public JTable getTable() { return table; }
	public void setTable(JTable table) { this.table = table; }

	public VerticalMenuBar getVmb() { return vmb; }
	public void setVmb(VerticalMenuBar vmb) { this.vmb = vmb; }

	public void fillPage(Person person) {
		funcForNorthPanel(person);
		funcForCenterPanel(person);
		funcForEastPanel(person);
	}
	
	public void putMenuBar(String[] menusStr, String[][] items) {
		JMenu menu;
		MenuItem menuItem;
		
		for (int i = 0; i < menusStr.length ; i++) {
			menu = new JMenu(menusStr[i]);
			for (int j = 0; j < items[i].length; j++) {
				System.out.println(items[i].length);
				menuItem = new MenuItem(items[i][j], vmb);
				menuItem.addActionListener();
				menu.add(menuItem);
			}
			
			vmb.add(menu);
		}
		
		eastPanel.revalidate();
		eastPanel.repaint();
	
	}
	
	public abstract void funcForNorthPanel(Person person);
	
	public abstract void funcForCenterPanel(Person person);
	
	public abstract void funcForEastPanel(Person person);
}
