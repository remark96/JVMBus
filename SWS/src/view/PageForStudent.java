package view;

import javax.swing.JLabel;

import model.Person;
import model.Student;

public class PageForStudent extends Page {
	
	public PageForStudent(MainWindow mainWindow) {
		super(mainWindow);
	}

	/*@Override
	public void fillPage(Person person) {
		Student student = (Student) person;

	}*/
	
	@Override
	public void funcForNorthPanel(Person person) {
		Student student = (Student) person;
		
		nameOfUser.setText(student.getIndex() + " - " + student.getName() + " " + student.getSurname());
		
		//mainWindow.refresh();
	}
	
	@Override
	public void funcForCenterPanel(Person person) {
		Student student = (Student) person;
		String[] items = {"Personal identification number", "Group", "Year of study"};
		
		centerPanel.add(new JLabel("Personal identification number"));
		centerPanel.add(new JLabel(student.getPin()));
		centerPanel.add(new JLabel("Group"));
		centerPanel.add(new JLabel("" + student.getGroup()));
		centerPanel.add(new JLabel("Year of study"));
		centerPanel.add(new JLabel("" + student.getStudyYear()));
	}

	@Override
	public void funcForEastPanel(Person person) {
		String[] itemsForMenu = {"Osnovni podaci", "Polozeni predmeti", "Nepolozeni predmeti", "Prijava ispita", "Finansijska kartica"};
		Menu menu;
		for (int i = 0; i < 5; i++) {
			menu = new Menu(itemsForMenu[i], vmb, i);
			menu.addActionListener();
			vmb.add(menu);
		}
		
		eastPanel.revalidate();
		eastPanel.repaint();
		
	}
	
	

}
