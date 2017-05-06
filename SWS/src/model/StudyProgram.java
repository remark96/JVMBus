package model;

import java.util.ArrayList;

public class StudyProgram {

	private String name;
	private String mark;
	private Department department;
	private ArrayList<Student> students;
	private ArrayList<Semester> semesters;
	
	private static int  numberImportantForSemesterCode= 5;
	
	public StudyProgram(String name, String mark, Department department, ArrayList<Student> students, ArrayList<Semester> semesters) {
		this.name = name;
		this.mark = mark;
		this.department = department;
		this.students = students;
		this.semesters = semesters;

	}
	
	public StudyProgram(String name, String mark, Department deparment) {
		this.name = name;
		this.mark = mark;
		this.department = deparment;
		this.students = new ArrayList<Student>();
		this.semesters = new ArrayList<Semester>();
		
		for (int i = 0; i < 8; i++) {
			this.semesters.add(new Semester(numberImportantForSemesterCode*10 + i + 1, i+1));
		}
		
		numberImportantForSemesterCode++;
	}
	
	public String[] getArrayStrings(int i) { return new String[] {"" + i + ".", name, mark, department.getName(), "Click here ..." , "Click here ..."}; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMark() { return mark; }
	public void setMark(String mark) { this.mark = mark; }
	
	public Department getDeparment() { return department; }
	public void setDeparment(Department deparment) { this.department = deparment; }
	
	public ArrayList<Student> getStudents() { return students; }
	public void setStudents(ArrayList<Student> students) { this.students = students; }
	
	public ArrayList<Semester> getSemesters() { return semesters; }
	public void setSemesters(ArrayList<Semester> semesters) { this.semesters = semesters; }
	
	public boolean equals(String mark) { return this.mark.equals(mark); }
}
