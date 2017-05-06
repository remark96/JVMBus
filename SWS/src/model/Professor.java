package model;

import java.util.ArrayList;

public class Professor extends Person{
	private String nameOfChair;
	private ArrayList<Course> courses;
	
	private final int NUM_ATTR =  4 + 2; // 4 redovnih atributa i 2 za user
	
	public Professor(String pin, String name, String surname, User user, String nameOfChair, ArrayList<Course> courses) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.user = user;
		this.nameOfChair = nameOfChair;
		this.courses = courses;
	}
	
	public Professor(String pin, String name, String surname, User user, String nameOfChair) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.user = user;
		this.nameOfChair = nameOfChair;
		this.courses = new ArrayList<Course>();
	}
	
	public Professor(String[] tokens) {
   		if (tokens.length == NUM_ATTR) {
   			this.pin = tokens[0].trim();
   			this.name = tokens[1].trim();
   			this.surname = tokens[2].trim();
   			this.user = new User(tokens[3].trim(), tokens[4].trim(), TYPE_OF_USER.PROFFESOR);
   			this.nameOfChair = tokens[5].trim();
		} 
   		else {
   			this.pin = "Not found";
   			this.name = "Not found";
   			this.surname = "Not found";
   			this.user = new User("Not found", "Not found", TYPE_OF_USER.PROFFESOR);
		}
   		
   		this.courses = new ArrayList<Course>();
		
	}
	
	public String[] getArrayStrings(int i) { return new String[] {"" + i + ".", pin, name, surname, nameOfChair, "Click here ..."}; }
	
	public ArrayList<Course> getCourses() { return courses; }
	public void setCourses(ArrayList<Course> courses) { this.courses = courses; }
	
	public boolean equals(String pin) { return this.pin.equals(pin); }
	public boolean equals(Professor p) { return this.pin.equals(p.pin); }
	public boolean equals(User user) { return this.user.equals(user); }
	
}
