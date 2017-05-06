package model;

public class Course {

	private String name;
	private int semesterCode;
	private String professorCode;
   	private int ECTS; // ESPB
   	
   	private final int NUM_ATTR = 4;
	
   	public Course(String name, int semesterCode, String professorCode, int ECTS) {
		this.name = name;
		this.semesterCode = semesterCode;
		this.professorCode = professorCode;
		this.ECTS = ECTS;
	}
   	
   	public Course(String[] tokens) {
   		if (tokens.length == NUM_ATTR) {
   			this.name = tokens[0].trim();
   			
   			try {
				this.semesterCode = Integer.parseInt(tokens[1].trim());
			} catch (NumberFormatException e) {
				this.semesterCode = -1;
			}
   			
   			try {
				this.professorCode = tokens[2].trim();
			} catch (NumberFormatException e) {
				this.professorCode = "Not found";
			}
   			
   			try {
				this.ECTS = Integer.parseInt(tokens[3].trim());
			} catch (NumberFormatException e) {
				this.ECTS = -1;
			}
		} 
   		else {
   			this.name = "Not found";
   			this.semesterCode = -1;
   			this.professorCode = "Not found";
   			this.ECTS = -1;
		}
		
	}

	public String[] getArrayStrings(int i) { return new String[] {"" + i + ".", name, "" + semesterCode, professorCode, "" + ECTS}; }
   	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getSemesterCode() { return semesterCode;}
	public void setSemesterCode(int semesterCode) { this.semesterCode = semesterCode; }

	public String getProfessorCode() { return professorCode; }
	public void setProfessorCode(String professorCode) { this.professorCode = professorCode; }

	public int getECTS() { return ECTS; }
	public void setECTS(int ECTS) { this.ECTS = ECTS; }
	
	public boolean equals(Course c) { return this.name.equals(c.name); }

}
