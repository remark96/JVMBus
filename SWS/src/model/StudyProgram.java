package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudyProgram
{
	private String name;
	private String deparmentName;
	private String mark;
	private ArrayList<Student> students;
	private ArrayList<Semester> semesters;
	
	public StudyProgram()
	{
		
	}
	
	public StudyProgram(String[] data)
	{
		this.name = data[0];
		this.deparmentName = data[1];
		this.mark = data[2];
		this.students = new ArrayList<Student>();
		this.semesters = new ArrayList<Semester>();
	}
	
	@Override
	public String toString() 
	{
		String students = "";
		String semesters = "";
		for(Student s : this.students)
		{
			students += "\n";
			students += s.toString();
		}
		for(Semester sm : this.semesters)
		{
			semesters += "\n";
			semesters += sm.toString();
		}
		return name + "|" + deparmentName + "|" + mark +
			   "\nstudents:" + students + "\nsemesters:" + semesters;
	}

	public String getInfo()
	{
		return name + "|" + mark;
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<StudyProgram> readStudyPrograms()
	{
		// 1) Read studyPrograms from file
		ArrayList<StudyProgram> studyPrograms = new ArrayList<StudyProgram>();
		String fileName = ".\\files\\studyPrograms.txt";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// skip header in file
			line = br.readLine();
			while ((line = br.readLine()) != null)
			{
				String[] array = line.split("\\|");
				String[] data = new String[array.length];
				for (int i = 0; i < array.length; i++) 
				{
					data[i] = array[i].trim();
				}
				StudyProgram newStudyProgram = new StudyProgram(data);
				Boolean flag = true;
				for(int j=0; j<studyPrograms.size(); j++)
				{
					if(studyPrograms.get(j).getName().equals(newStudyProgram.getName()))
					{
						flag = false;
					}
				}
				for(int j=0; j<studyPrograms.size(); j++)
				{
					if(studyPrograms.get(j).getMark().equals(newStudyProgram.getMark()))
					{
						flag = false;
					}
				}
				if(flag)
				{
					studyPrograms.add(newStudyProgram);	
				}
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
		
		// 2) Connect studyPrograms with theirs students
		//    and theirs semesters
		ArrayList<Student> students = Student.readStudents();
		ArrayList<Semester> semesters = Semester.readSemesters();
		for(StudyProgram sp : studyPrograms)
		{
			for(Student student : students)
			{
				if(student.getIndex().startsWith(sp.getMark()))
				{
					sp.getStudents().add(student);
				}
			}
			for(Semester s : semesters)
			{
				if(s.getStudyProgramName().equals(sp.getName()))
				{
					sp.getSemesters().add(s);
				}
			}
		}
		
		return studyPrograms;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeparmentName() {
		return deparmentName;
	}
	public void setDeparmentName(String deparmentName) {
		this.deparmentName = deparmentName;
	}	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public ArrayList<Semester> getSemesters() {
		return semesters;
	}
	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}
}
