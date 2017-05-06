package model;

public interface Reader {
	
	public void readDepartments(String nameOfFile);

	public void readStudyPrograms(String nameOfFile);
	
	public void readChairs(String nameOfFile);
	
	public void readUsers(String nameOfFile);

	public void readStudents(String nameOfFile);
	
	public void readProfessors(String nameOfFile);
	
	public void readCourses(String nameOfFile);

	/*public static void readData() {
		readDepartments();
		readStudyPrograms();
		readStudents();
		readCourses();
	}*/
}
