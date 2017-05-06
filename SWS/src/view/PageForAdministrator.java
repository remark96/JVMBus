package view;

import javax.swing.JMenu;

import model.Faculty;
import model.Person;
import model.Professor;
import model.Student;

@SuppressWarnings("serial")
public class PageForAdministrator extends Page {

	public PageForAdministrator(Faculty faculty) {
		super(faculty);
	}

	@Override
	public void funcForNorthPanel(Person person) {


	}

	@Override
	public void funcForCenterPanel(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void funcForEastPanel(Person person) {
		String[] menusStr = {"DEPARTMENTS", "STUDY PROGRAMS", "CHAIRS",  "STUDENTS", "PROFESSORS", "COURSES", "OTHER SERVICES"};
		String[][] items = {{"Show departments", "Add department", "Edit department", "Remove department"}, 
							{"Show study programs", "Add study program", "Edit study program", "Remove study program"},
							{"Show chairs", "Add chair", "Edit chair", "Remove chair"},
							{"Show students", "Add student", "Edit student", "Remove student"}, 
							{"Show professors", "Add professor", "Edit professor", "Remove professor"}, 
							{"Show courses", "Add course", "Edit course", "Remove course"},
							{"Change your password", "Sign out"}
						  };
		
		putMenuBar(menusStr, items);

	}

}
