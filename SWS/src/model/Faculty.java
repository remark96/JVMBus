package model;

import java.util.ArrayList;

public class Faculty implements Reader {

	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<Department> departments;
	private ArrayList<User> users;
	
	public Faculty() {
		this.name = "Faculty of Technical Sciences";
		this.address = "Trg Dositeja Obradovica 6, 21101 Novi Sad";
		this.phoneNumber = "(+381) 21 450 810";
		
		this.departments = new ArrayList<Department>();
		this.users = new ArrayList<User>();
	}
	
	public Faculty(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.departments = new ArrayList<Department>();
		this.users = new ArrayList<User>();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	
	public ArrayList<Department> getDepartments() { return departments; }
	public void setDepartments(ArrayList<Department> departments) { this.departments = departments; }
	
	public ArrayList<User> getUsers() { return users; }
	public void setUsers(ArrayList<User> users) { this.users = users; }
	
	public boolean addDepartment(String nameOfDepartment) {
		for (Department department : departments) {
			if (department.equals(nameOfDepartment)) return false;
		}
		
		departments.add(new Department(nameOfDepartment));
		
		return true;
	}
	
	public boolean addStudyProgram(String name, String nameOfDepartment, String mark) {
		ArrayList<StudyProgram> studyPrograms;
		
		for (Department department : departments) {
			if (department.equals(nameOfDepartment)) {
				studyPrograms = department.getStudyPrograms();
				
				for (StudyProgram studyProgram : studyPrograms) {
					if (studyProgram.equals(name)) return false;
				}
				
				studyPrograms.add(new StudyProgram(name, mark, department));
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addStudent(String pin, String name, String surname, String index, int studyYear, int group, String username, String password, TYPE_OF_USER typeOfUser, String nameOfStudyProgram) {
		ArrayList<StudyProgram> studyPrograms;
		ArrayList<Student> students;
		User user;
		
		for (Department department : departments) {
			studyPrograms = department.getStudyPrograms();
			
			for (StudyProgram studyProgram : studyPrograms) {
				if (studyProgram.equals(nameOfStudyProgram)) {
					students = studyProgram.getStudents();
					
					for (Student s : students) {
						if (s.equals(index)) return false;
					}
					
					user = new User(username, password, typeOfUser);
					students.add(new Student(pin, name, surname, index, studyYear, group, user));
					users.add(user);
					
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public ArrayList<Student> getStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<StudyProgram> studyPrograms;
		
		for (Department department : departments) {
			studyPrograms = department.getStudyPrograms();
			
			for (StudyProgram studyProgram : studyPrograms) {
				students.addAll(studyProgram.getStudents());
			}
		}
		
		return students;
	}
	
	public ArrayList<Professor> getProfessors() {
		ArrayList<Professor> professors = new ArrayList<Professor>();
		ArrayList<Chair> chairs;
		
		for (Department department : departments) {
			chairs = department.getChairs();
			
			for (Chair chair : chairs) {
				professors.addAll(chair.getProfessors());
			}
		}
		
		return professors;
	}

	@Override
	public void readDepartments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readStudyPrograms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readStudents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCourses() {
		// TODO Auto-generated method stub
		
	}
	
}
