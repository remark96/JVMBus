package model;

import java.util.List;

public class Professor extends User{

	List<Subject> subjects;
	
	public Professor(String name, String surname, String pin, List<Subject> subjects) {
		super();
		this.name = name;
		this.surname = surname;
		this.pin = pin;
		this.subjects = subjects;
	}
	
	
}
