package view;

import java.awt.Menu;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenu;

import model.Faculty;
import model.Person;
import model.Student;

@SuppressWarnings("serial")
public class PageForStudent extends Page {
	
	public PageForStudent(Faculty faculty) {
		super(faculty);
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
		//String[] items = {"Personal identification number", "Group", "Year of study"};
		
		centerPanel.add(new JLabel("Personal identification number"));
		centerPanel.add(new JLabel(student.getPin()));
		centerPanel.add(new JLabel("Group"));
		centerPanel.add(new JLabel("" + student.getGroup()));
		centerPanel.add(new JLabel("Year of study"));
		centerPanel.add(new JLabel("" + student.getStudyYear()));
	}

	@Override
	public void funcForEastPanel(Person person) {
		String[] menusStr = {"INDEX", "POLLS", "EXAM REGISTRATION / CANCELLATION", "OTHER SERVICES"};
		String[][] items = {{"Basic information", "Flow of study", "Exams passed", "Remaining courses (flunk)"},
							{"Activate polls"},
							{"Exam registration", "Cancel exam registration", "Financial card"},
							{"Change your password", "Sign out"}
						   };
		
		putMenuBar(menusStr, items);
		
	}

}
