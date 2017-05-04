package model;

import java.util.ArrayList;

public class Department {

	private String name;
	private ArrayList<StudyProgram> studyPrograms;
	private ArrayList<Chair> chairs;
	
	public Department(String name, ArrayList<StudyProgram> studyPrograms, ArrayList<Chair> chairs) {
		this.name = name;
		this.studyPrograms = studyPrograms;
		this.chairs = chairs;
	}
	
	public Department(String name) {
		this.name = name;
		this.studyPrograms = new ArrayList<StudyProgram>();
		this.chairs = new ArrayList<Chair>();
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public ArrayList<StudyProgram> getStudyPrograms() { return studyPrograms; }
	public void setStudyPrograms(ArrayList<StudyProgram> studyPrograms) { this.studyPrograms = studyPrograms; }

	public ArrayList<Chair> getChairs() { return chairs; }
	public void setChairs(ArrayList<Chair> chairs) { this.chairs = chairs; }
	
	public boolean equals(String nameOfDepartment) { return name.equals(nameOfDepartment); }
}
