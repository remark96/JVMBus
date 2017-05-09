package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student extends Person
{
	private String index;
	private int studyYear;
	private int group;
	
	public Student()
	{
		
	}
	
	public Student(String[] data)
	{
		this.pin = data[0];
		this.name = data[1];
		this.surname = data[2];
		this.index = data[3];
		this.studyYear = Integer.parseInt(data[4]);
		this.group = Integer.parseInt(data[5]);

		User newUser = new User(data[6], data[7]);
		super.setUser(newUser);
		//Faculty.users.add(newUser);
	}

	@Override
	public String toString() 
	{
		return pin + "|" + name + "|" + surname + "|" + index + "|"
				+ studyYear + "|" + group + "|" + super.user.getUsername() + "|" + super.user.getPassword();
	}
	
	public String getInfo()
	{
		return pin + "|" + name + "|" + surname + "|" + index + "|"
				+ studyYear + "|" + group;
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<Student> readStudents()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		String fileName = ".\\files\\students.txt";
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
				Student newStudent = new Student(data);
				Boolean flag = true;
				for(int j=0; j<students.size(); j++)
				{
					if(students.get(j).getIndex().equals(newStudent.getIndex()))
					{
						flag = false;
					}
				}
				if(flag)
				{
					students.add(newStudent);
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
		
		return students;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
