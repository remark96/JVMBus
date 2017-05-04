package model;

public class Student extends Person{

	private String index; // student knows which is his StudyProgram by index prefix, also we know year when he started studying
	private int studyYear;
	private int group;
	
	public Student(String pin, String name, String surname, String index, int studyYear, int group, User user) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.index = index;
		this.studyYear = studyYear;
		this.group = group;
		this.user = user;
	}
	
	public String getIndex() { return index; }
	public void setIndex(String index) { this.index = index; }

	public int getStudyYear() { return studyYear; }
	public void setStudyYear(int studyYear) { this.studyYear = studyYear; }

	public int getGroup() { return group; }
	public void setGroup(int group) { this.group = group; }

	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	
	
	public boolean equals(String index) { return this.index.equals(index); }
	public boolean equals(User user) { return this.user.equals(user); }
	
}
