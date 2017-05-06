package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Faculty implements Reader {

	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<Department> departments;
	private ArrayList<User> users;
	
	private boolean filesLoaded;
	
	public Faculty(String nameOfUsersFile) {
		this.name = "Faculty of Technical Sciences";
		this.address = "Trg Dositeja Obradovica 6, 21101 Novi Sad";
		this.phoneNumber = "(+381) 21 450 810";
		
		this.departments = new ArrayList<Department>();
		this.users = new ArrayList<User>();
		this.filesLoaded = false;
		
		readUsers(nameOfUsersFile);
		
		//users.add(new User("0000", "1111", TYPE_OF_USER.ADMINISTRATOR)); // dodavanje prvog administratora
		
	}
	
	public Faculty(String name, String address, String phoneNumber, String nameOfUsersFile) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.departments = new ArrayList<Department>();
		this.users = new ArrayList<User>();
		
		readUsers(nameOfUsersFile);
		
		//users.add(new User("0000", "1111", TYPE_OF_USER.ADMINISTRATOR)); // dodavanje prvog administratora
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
	
	
	
	public boolean isFilesLoaded() { return filesLoaded; }
	public void setFilesLoaded(boolean filesLoaded) { this.filesLoaded = filesLoaded; }

	public boolean addDepartment(String nameOfDepartment) {
		for (Department department : departments) {
			if (department.equals(nameOfDepartment)) return false;
		}
		
		departments.add(new Department(nameOfDepartment));
		
		return true;
	}
	
	public boolean addChair(String line) {
		ArrayList<Chair> chairs;
		
		String[] tokens = line.split("\\|");
		Chair c;
		
		if (tokens.length == 2) {
			for (Department department : departments) {
				if (department.equals(tokens[1].trim())) {
					chairs = department.getChairs();
					
					for (Chair chair : chairs) {
						if (chair.equals(tokens[0].trim())) return false;
					}
					
					c =  new Chair(tokens[0].trim());
					c.setDepartment(department);
					chairs.add(c);
					
					return true;
				}
			}
		}
		
		
		return false;
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
	
	public boolean addStudyProgram(String line) {
		ArrayList<StudyProgram> studyPrograms;
		
		String[] tokens = line.split("\\|");
		
		if (tokens.length == 3) {
			for (Department department : departments) {
				if (department.equals(tokens[2].trim())) {
					studyPrograms = department.getStudyPrograms();
					
					for (StudyProgram studyProgram : studyPrograms) {
						if (studyProgram.equals(tokens[0].trim())) return false;
					}
					
					studyPrograms.add(new StudyProgram(tokens[0].trim(), tokens[1].trim(), department));
					
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Student> getRquiredStudents (String mark) {
		ArrayList<StudyProgram> studyPrograms;
		
		for (Department department : departments) {
			studyPrograms = department.getStudyPrograms();
			
			for (StudyProgram studyProgram : studyPrograms) {
				if (studyProgram.equals(mark)) {
					return studyProgram.getStudents();
				}
			}
		}
		
		return null;
	}
	
	public boolean addUser(String line) {
		String[] tokens = line.split("\\|");
		
		if (tokens.length == 3) {
			tokens[0] = tokens[0].trim();
			tokens[1] = tokens[1].trim();
			
			int i ;
			try {
				i = Integer.parseInt(tokens[2].trim());
			} 
			catch (Exception e) {
				return false;
			}
			
			if(!tokens[0].equals("") && !tokens[1].equals("")) {
				for (User u : users) {
					if (u.equals(tokens[0], tokens[1])) return false;
				}
				
				users.add(new User(tokens[0], tokens[1], TYPE_OF_USER.values()[i]));
				
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean addStudent(String pin, String name, String surname, String index, int studyYear, int group, String username, String password, String mark) {
		ArrayList<Student> students = getRquiredStudents(mark);
		if (students == null) return false;
					
		for (Student s : students) {
			if (s.getIndex().equals(index)) return false;
		}
		
		User user = new User(username, password, TYPE_OF_USER.STUDENT);
		students.add(new Student(pin, name, surname, index, studyYear, group, user));
		users.add(user);
		
		return true;
		
	}
	
	public boolean addStudent(String line) {
		Student student = new Student(line);
		String index = student.getIndex();
		
		ArrayList<Student> students = getRquiredStudents(index.substring(0, 2));
		if (students == null) return false;
					
		
		for (Student s : students) {
			if (s.equals(student)) return false;
		}
		
		students.add(student);
		//if (!student.getUser().getUsername().equals("Not found") && !student.getUser().getPassword().equals("Not found")) users.add(student.getUser());
		
		return true;
		
	}
	
	public ArrayList<Professor> getRquiredProfessors (String nameOfChair) {
		ArrayList<Chair> chairs;
		
		for (Department department : departments) {
			chairs = department.getChairs();
			
			for (Chair chair : chairs) {
				if (chair.equals(nameOfChair)) {
					return chair.getProfessors();
				}
			}
		}
		
		return null;
	}
	
	public boolean addProfessor(String pin, String name, String surname, String username, String password, String nameOfChair) {
		ArrayList<Professor> professors = getRquiredProfessors(nameOfChair);
		if (professors == null) return false;
					
		for (Professor p : professors) {
			if (p.equals(pin)) return false;
		}
		
		User user = new User(username, password, TYPE_OF_USER.PROFFESOR);
		professors.add(new Professor(pin, name, surname, user, nameOfChair));
		//users.add(user);
		
		return true;
	}
	
	public boolean addProfessor(String line) {
		String[] tokens = line.split("\\|");
		ArrayList<Professor> professors = getRquiredProfessors(tokens[tokens.length - 1].trim());
		if (professors == null) return false;
					
		Professor professor = new Professor(tokens);
		
		for (Professor p : professors) {
			if (p.equals(professor)) return false;
		}
		
		professors.add(professor);
		if (!professor.getUser().getUsername().equals("Not found") && !professor.getUser().getPassword().equals("Not found")) users.add(professor.getUser());
		
		return true;
		
	}
	
	public ArrayList<Course> getRquiredCourses (int semesterCode) {
		ArrayList<StudyProgram> studyPrograms = getStudyPrograms();
		ArrayList<Semester> semesters;
		
		for (StudyProgram studyProgram : studyPrograms) {
			semesters = studyProgram.getSemesters();
			
			for (Semester semester : semesters) {
				if (semester.equals(semesterCode)) {
					return semester.getCourses();
				}
			}
		}
		
		return null;
	}
	
	public boolean addCourses(String line) {
		String[] tokens = line.split("\\|");
		
		int semesterCode = 0;
		try {
			semesterCode = Integer.parseInt(tokens[1].trim());
		} 
		catch (Exception e) {
			return false;
		}
		
		ArrayList<Course> courses = getRquiredCourses(semesterCode);
		if (courses == null) return false;
					
		Course course = new Course(tokens);
		
		for (Course c : courses) {
			if (c.equals(courses)) return false;
		}
		
		courses.add(course);
		if (!course.getName().equals("Not found") && course.getProfessorCode().equals("Not found")) assignToProfessor(course);
		
		return true;
		
	}
	
	public void assignToProfessor(Course course) {
		ArrayList<Professor> professors = getProfessors();
		
		for (Professor professor : professors) {
			if (professor.equals(course.getProfessorCode())) {
				professor.getCourses().add(course);
				return;
			}
		}
		
	}

	public ArrayList<StudyProgram> getStudyPrograms() {
		ArrayList<StudyProgram> studyPrograms = new ArrayList<StudyProgram>();
		
		for (Department department : departments) {
			studyPrograms.addAll(department.getStudyPrograms());
			
		}
		
		return studyPrograms;
	}
	
	public ArrayList<Chair> getChairs() {
		ArrayList<Chair> chairs = new ArrayList<Chair>();
		
		for (Department department : departments) {
			chairs.addAll(department.getChairs());
			
		}
		
		return chairs;
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
	
	public ArrayList<Course> getCourses() {
		ArrayList<StudyProgram> studyPrograms = getStudyPrograms();
		ArrayList<Semester> semesters;
		ArrayList<Course> courses = new ArrayList<Course>();
		
		for (StudyProgram studyProgram : studyPrograms) {
			semesters = studyProgram.getSemesters();
			
			for (Semester semester : semesters) {
				courses.addAll(semester.getCourses());
			}
		}
		
		return courses;
	}

	@Override
	public void readDepartments(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addDepartment(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void readStudyPrograms(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addStudyProgram(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void readChairs(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addChair(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void readUsers(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addUser(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void readStudents(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addStudent(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void readProfessors(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addProfessor(line);
			}
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readCourses(String nameOfFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nameOfFile));
			String line = "";
			
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
				if (line.equals("") || line.startsWith("#")) continue;
				
				addCourses(line);
			}
			
			
			br.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void readData(String nameOfDepartmentsFile, String nameOfStudyProgramsFile, String nameOfChairsFile, String nameOfStudentsFile, String nameOfProfessorsFile, String nameOfCoursesFile) {
		readDepartments(nameOfDepartmentsFile);
		readStudyPrograms(nameOfStudyProgramsFile);
		readChairs(nameOfChairsFile);
		readStudents(nameOfStudentsFile);
		readProfessors(nameOfProfessorsFile);
		readCourses(nameOfCoursesFile);
		
		filesLoaded = true;
	}
	
}
