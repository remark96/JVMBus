package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.Chair;
import model.Course;
import model.Department;
import model.Faculty;
import model.Professor;
import model.Student;
import model.StudyProgram;

@SuppressWarnings("serial")
class VerticalMenuBar extends JMenuBar {
	  private static final LayoutManager grid = new GridLayout(0,1);
	  private Faculty faculty;
	  // private JTable table;
	  private Page page;
	  
	  public VerticalMenuBar(Faculty faculty, Page page) {
		  this.faculty = faculty;
		  this.page = page;
		  setLayout(grid);
	  }
	  
	  public void showDepartments() {
			ArrayList<Department> departments = faculty.getDepartments();

			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Name", "Study programs", "Chairs"});
			for (int i = 0; i < departments.size(); i++) {
				tm.addRow(departments.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void showStudyPrograms() {
			ArrayList<StudyProgram> studyPrograms = faculty.getStudyPrograms();
			
			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Name", "Mark", "Name of departments", "Students", "Semesters"});
			for (int i = 0; i < studyPrograms.size(); i++) {
				tm.addRow(studyPrograms.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void showChairs() {
			ArrayList<Chair> chairs = faculty.getChairs();
			
			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Name", "Name of departments", "Professors"});
			for (int i = 0; i < chairs.size(); i++) {
				tm.addRow(chairs.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void showStudents() {
			ArrayList<Student> students = faculty.getStudents();
			
			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Personal identification number", "Name", "Surname", "Index", "Year of study", "Group"});
			for (int i = 0; i < students.size(); i++) {
				tm.addRow(students.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void showProfessors() {
			ArrayList<Professor> professors = faculty.getProfessors();
			
			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Personal identification number", "Name", "Surname", "Name of department", "Courses"});
			for (int i = 0; i < professors.size(); i++) {
				tm.addRow(professors.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void showCourses() {
			ArrayList<Course> courses = faculty.getCourses();
			
			DefaultTableModel tm = new DefaultTableModel();
			tm.setColumnIdentifiers(new String[] {"Ordinal number", "Name", "Semester code", "Professor code", "ECTS"});
			for (int i = 0; i < courses.size(); i++) {
				tm.addRow(courses.get(i).getArrayStrings(i+1));
			}
			page.getTable().setModel(tm);
	  }
	  
	  public void signOut() {
		  MainWindow mainWindow = (MainWindow) SwingUtilities.windowForComponent(page);
		  mainWindow.putHomePage();
	  }
}
