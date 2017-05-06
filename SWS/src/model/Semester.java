package model;

import java.util.ArrayList;

public class Semester {
	private int code;
	private int ordinalNumber;
	private ArrayList<Course> courses;
	
	public Semester(int code, int ordinalNumber, ArrayList<Course> courses) {
		this.code = code;
		this.ordinalNumber = ordinalNumber;
		this.courses = courses;
	}
	
	public Semester(int code, int ordinalNumber) {
		this.code = code;
		this.ordinalNumber = ordinalNumber;
		this.courses = new ArrayList<Course>();
	}

	public int getCode() { return code; }
	public void setCode(int code) { this.code = code; }

	public int getOrdinalNumber() { return ordinalNumber; }
	public void setOrdinalNumber(int ordinalNumber) { this.ordinalNumber = ordinalNumber; }

	public ArrayList<Course> getCourses() { return courses; }
	public void setCourses(ArrayList<Course> courses) { this.courses = courses; }

	public boolean equals(int code) { return this.code == code; }
}
