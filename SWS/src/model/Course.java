package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Course {

	private String name;
	private int semesterCode;
	private String professorCode;
	private int ECTS; // ESPB
	
	public Course()
	{
		
	}

	public Course(String[] data)
	{
		this.name = data[0];
		this.semesterCode = Integer.parseInt(data[1]);
		this.professorCode = data[2];
		this.ECTS = Integer.parseInt(data[3]);
	}
	
	@Override
	public String toString() {
		return name + "|" + semesterCode + "|" + professorCode
				+ "|" + ECTS;
	}

	@SuppressWarnings("resource")
	public static ArrayList<Course> readCourses()
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		String fileName = ".\\files\\courses.txt";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// skip header in file
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] array = line.split("\\|");
				String[] data = new String[array.length];
				for (int i = 0; i < array.length; i++) {
					data[i] = array[i].trim();
				}
				Course newCourse = new Course(data);
				courses.add(newCourse);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return courses;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSemesterCode() {
		return semesterCode;
	}
	public void setSemesterCode(int semesterCode) {
		this.semesterCode = semesterCode;
	}
	public String getProfessorCode() {
		return professorCode;
	}
	public void setProfessorCode(String professorCode) {
		this.professorCode = professorCode;
	}
	public int getECTS() {
		return ECTS;
	}
	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

}
