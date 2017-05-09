package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Semester
{
	private int code;
	private String studyProgramName;
	private int ordinalNumber;
	private List<Course> courses;

	public Semester()
	{
		
	}
	
	public Semester(String[] data)
	{
		this.code = Integer.parseInt(data[0]);
		this.studyProgramName = data[1];
		this.ordinalNumber = Integer.parseInt(data[2]);
		courses = new ArrayList<Course>();
	}
	
	@Override
	public String toString() {
		String courses = "";
		for(int i=0; i<this.courses.size(); i++)
		{
			courses += "\n";
			courses += this.courses.get(i).toString();
		}
		return code + "|" + studyProgramName + "|" + ordinalNumber + "\ncourses:" + courses;
	}

	public String getInfo()
	{
		return code + "|"  + ordinalNumber;
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<Semester> readSemesters()
	{
		// 1) Read semesters from file
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		String fileName = ".\\files\\semesters.txt";
		try 
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			line = br.readLine();
			while((line=br.readLine())!=null)
			{
				String array[] = line.split("\\|");
				String data[] = new String[array.length];
				for(int i=0; i<array.length; i++)
				{
					data[i] = array[i].trim();
				}
				Semester newSemester = new Semester(data);
				Boolean flag = true;
				for(int j=0; j<semesters.size(); j++)
				{
					if(semesters.get(j).getCode() == newSemester.getCode())
					{
						flag = false;
					}
				}
				if(flag)
				{
					semesters.add(newSemester);
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
		
		// 2) Connect semesters with theirs courses
		ArrayList<Course> courses = Course.readCourses();
		for(Course c : courses)
		{
			for(Semester sm : semesters)
			{
				if(sm.getCode() == c.getSemesterCode())
				{
					sm.getCourses().add(c);
				}
			}
		}
		
		return semesters;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStudyProgramName() {
		return studyProgramName;
	}

	public void setStudyProgramName(String studyProgramName) {
		this.studyProgramName = studyProgramName;
	}

	public int getOrdinalNumber() {
		return ordinalNumber;
	}

	public void setOrdinalNumber(int ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
