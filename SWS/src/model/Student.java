package model;

public class Student extends Person{

	private String index; // student knows which is his StudyProgram by index prefix, also we know year when he started studying
	private int studyYear;
	private int group;
	
	private final int NUM_ATTR =  6 + 2; // 6 redovnih atributa i 2 za user
	
	public Student(String pin, String name, String surname, String index, int studyYear, int group, User user) {
		this.pin = pin;
		this.name  = name;
		this.surname = surname;
		this.index = index;
		this.studyYear = studyYear;
		this.group = group;
		this.user = user;
	}
	
	public Student(String line) {
   		String[] tokens = line.split("\\|");
   		if (tokens.length == NUM_ATTR) {
   			this.pin = tokens[0].trim();
   			this.name = tokens[1].trim();
   			this.surname = tokens[2].trim();
   			this.index = tokens[3].trim();
   			
   			try {
				this.studyYear = Integer.parseInt(tokens[4].trim());
			} catch (NumberFormatException e) {
				this.studyYear = -1;
			}
   			
   			try {
				this.group = Integer.parseInt(tokens[5].trim());
			} catch (NumberFormatException e) {
				this.group = -1;
			}
   			
   			this.user = new User(tokens[6].trim(), tokens[7].trim(), TYPE_OF_USER.STUDENT);
		} 
   		else {
   			this.pin = "Not found";
   			this.name = "Not found";
   			this.surname = "Not found";
   			this.index = "Not found";
   			this.studyYear = -1;
   			this.group = -1;
   			this.user = new User("Not found", "Not found", TYPE_OF_USER.STUDENT);
		}
		
	}
	
	public String[] getArrayStrings(int i) { return new String[] {"" + i + ".", pin, name, surname, index, "" + studyYear, "" + group}; }
	
	public String getIndex() { return index; }
	public void setIndex(String index) { this.index = index; }

	public int getStudyYear() { return studyYear; }
	public void setStudyYear(int studyYear) { this.studyYear = studyYear; }

	public int getGroup() { return group; }
	public void setGroup(int group) { this.group = group; }

	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	
	public boolean equals(Student s) { return this.index.equals(s.index) && !s.index.equals("Not found"); }
	public boolean equals(String index) { return this.index.equals(index); }
	public boolean equals(User user) { return this.user.equals(user); }
	
}
