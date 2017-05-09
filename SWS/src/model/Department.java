package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Department {

	String name;
	ArrayList<StudyProgram> studyPrograms;
	ArrayList<Chair> chairs;
	
	public Department()
	{
		
	}
	
	public Department(String[] data) 
	{
		this.name = data[0];
		studyPrograms = new ArrayList<StudyProgram>();
		chairs = new ArrayList<Chair>();
	}

	@Override
	public String toString()
	{
		String studyPrograms = "";
		for(int i=0; i<this.studyPrograms.size(); i++)
		{
			studyPrograms += "\n";
			studyPrograms += this.studyPrograms.get(i).toString();
		}
		if(studyPrograms.equals(""))
		{
			return name;
		}
		else
		{
			return name + ":" + studyPrograms;
		}
	}
	

	@SuppressWarnings("resource")
	public static ArrayList<Department> readDepartments()
	{
		// 1) Read departments from file
		ArrayList<Department> departments = new ArrayList<Department>();
		String fileName = ".\\files\\departments.txt";
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// skip header in file
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] array = line.split("\\|");
				String[] data = new String[array.length];
				for (int i = 0; i < array.length; i++) 
				{
					data[i] = array[i].trim();
				}
				Department newDepartment = new Department(data);
				// check if department with the same name already exists
				Boolean flag = true;
				for(int j=0; j<departments.size(); j++)
				{
					if(departments.get(j).getName().equals(newDepartment.name))
					{
						flag = false;
					}
				}
				if(flag)
				{
					departments.add(newDepartment);	
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
		
		// 2) Connect departments with theirs studyPrograms
		ArrayList<StudyProgram> studyPrograms = StudyProgram.readStudyPrograms();
		for(StudyProgram sp : studyPrograms)
		{
			for(Department d : departments)
			{
				if(sp.getDeparmentName().equals(d.getName()))
				{
					d.getStudyPrograms().add(sp);
					break;
				}
			}
		}
		
		return departments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<StudyProgram> getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(ArrayList<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public ArrayList<Chair> getChairs() {
		return chairs;
	}

	public void setChairs(ArrayList<Chair> chairs) {
		this.chairs = chairs;
	}
	
}
