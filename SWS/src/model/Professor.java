package model;

import java.util.ArrayList;

public class Professor extends Person{
	private User user;
	//String departmentNames[];
	private ArrayList<Course> courses;
	
	public Professor(String pin, String name, String surname, User user, ArrayList<Course> courses) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.user = user;
		this.courses = courses;
	}
	
	public Professor(String pin, String name, String surname, User user) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.user = user;
		this.courses = new ArrayList<Course>();
	}
	
	public ArrayList<Course> getCourses() { return courses; }
	public void setCourses(ArrayList<Course> courses) { this.courses = courses; }
	
	
}
