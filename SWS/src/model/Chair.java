package model;

import java.util.ArrayList;

public class Chair {
	private String name;
	private Department department;
	private ArrayList<Professor> professors;
	
	public Chair(String name, ArrayList<Professor> professors) {
		this.name = name;
		this.professors = professors;
	}
	
	public Chair(String name) {
		this.name = name;
		this.professors = new ArrayList<Professor>();
	}

	public String[] getArrayStrings(int i) { return new String[] {"" + i + ".", name, department.getName(), "Click here ..."}; }

	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Department getDepartment() { return department; }
	public void setDepartment(Department department) { this.department = department; }

	public ArrayList<Professor> getProfessors() { return professors; }
	public void setProfessors(ArrayList<Professor> professors) { this.professors = professors; }
	
	public boolean equals(String nameOfChair) { return name.equals(nameOfChair); }
}
