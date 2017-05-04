package controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Faculty;
import model.Person;
import model.Professor;
import model.Student;
import model.User;
import view.MainWindow;
import view.Page;
import view.PageForStudent;
import view.TextField;


public class Controller {
	private Faculty faculty;
	private MainWindow mainWindow;
	
	public Controller(Faculty faculty, MainWindow mainWindow) {
		this.faculty = faculty;
		this.mainWindow = mainWindow;
	}
	
	public Faculty getFaculty() { return faculty; }
	public void setFaculty(Faculty faculty) { this.faculty = faculty; }

	public MainWindow getMainWindow() { return mainWindow; }
	public void setMainWindow(MainWindow mainWindow) { this.mainWindow = mainWindow; }



	public void checkLogin() {
		User user = findUser();
		
		if (user == null) JOptionPane.showMessageDialog(mainWindow.getLogin(), "Invalid username and/or password!", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			mainWindow.getLogin().setVisible(false);
			
			Page page = null;
			Person person = null;
			
			switch (user.getTypeOfUser()) {
				case STUDENT:
					person = findStudent(user);
					page = new PageForStudent(mainWindow);
					break;
					
				case PROFFESOR:
					Professor proffesor = findProfessor(user);
					break;
					
				case ADMINISTRATOR:
					
					break;

				default:
					break;
			}
			
			page.fillPage(person);
			
			
		}
	}

	public User findUser() {
		TextField[] fields = mainWindow.getLogin().getFields(); 
		ArrayList<User> users = faculty.getUsers();
		
		for (User user : users) {
			if (user.equals(fields[0].getText(), fields[1].getText())) return user;
		}
		
		return null;
	}
	
	public Student findStudent(User user) {
		ArrayList<Student> students = faculty.getStudents();
		
		for (Student student : students) {
			if(student.equals(user)) return student;
		}
		
		return null;
	} 
	
	public Professor findProfessor(User user) {
		ArrayList<Professor> professors = faculty.getProfessors();
		
		for (Professor professor : professors) {
			if(professor.equals(user)) return professor;
		}
		return null;
	}
		
	
}
