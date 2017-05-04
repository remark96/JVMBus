package model;

import java.util.ArrayList;

public class Chair {
	private String name;
	private ArrayList<Professor> professors;
	
	public Chair(String name, ArrayList<Professor> professors) {
		this.name = name;
		this.professors = professors;
	}
	
	public Chair(String name) {
		this.name = name;
		this.professors = new ArrayList<Professor>();
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<Professor> getProfessors() { return professors; }
	public void setProfessors(ArrayList<Professor> professors) { this.professors = professors; }
	
}
