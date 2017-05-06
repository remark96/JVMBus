package view;

import model.Faculty;
import model.Person;
import model.Professor;

@SuppressWarnings("serial")
public class PageForProfessor extends Page {

	public PageForProfessor(Faculty faculty) {
		super(faculty);
	}

	@Override
	public void funcForNorthPanel(Person person) {
		Professor professor = (Professor) person;
		
		nameOfUser.setText(professor.getName() + " " + professor.getSurname());

	}

	@Override
	public void funcForCenterPanel(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void funcForEastPanel(Person person) {
		String[] menusStr = {"DATA", "OTHER SERVICES"};
		String[][] items = {{"Basic informations", "Financial card"}, 
							{"Change your password", "Sign out"}
						   };
		
		putMenuBar(menusStr, items);
	}

}
