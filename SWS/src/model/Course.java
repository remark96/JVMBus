package model;

public class Course {

	private String name;
	private int semesterCode;
	private int professorCode;
   	private int ECTS; // ESPB
	
   	public Course(String name, int semesterCode, int professorCode, int ECTS) {
		this.name = name;
		this.semesterCode = semesterCode;
		this.professorCode = professorCode;
		this.ECTS = ECTS;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSemesterCode() { return semesterCode;}
	public void setSemesterCode(int semesterCode) { this.semesterCode = semesterCode; }

	public int getProfessorCode() { return professorCode; }
	public void setProfessorCode(int professorCode) { this.professorCode = professorCode; }

	public int getECTS() { return ECTS; }
	public void setECTS(int ECTS) { this.ECTS = ECTS; }
   	

}
