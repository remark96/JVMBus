package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faculty {

	private static Faculty model = null;
	private String name;
	private String address;
	private String phoneNumber;
	private List<Department> departments = new ArrayList<Department>();
	public static List<User> users = new ArrayList<User>();
	
	private Faculty()
	{
		readData();
	}
	
	public static Faculty createModel()
	{
		if(model==null)
		{
			model = new Faculty();
		}
		return model;
	}
	
	@Override
	public String toString()
	{
		String departments = "";
		for(int i=0; i<this.departments.size(); i++)
		{
			departments += "\n";
			departments += this.departments.get(i).toString();
		}
		return name + "|" + address + "|" + phoneNumber + "\ndepartments:" + departments;
	}
	
	public String getInfo()
	{
		return name + "|" + address + "|" + phoneNumber;
	}
	
	@SuppressWarnings("resource")
	public void readData()
	{
		String fileName = ".\\files\\faculty.txt";
		try 
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// skip header in file
			line = br.readLine();
			line = br.readLine();
			String[] data = line.split("\\|");
			this.name = data[0];
			this.address = data[1];
			this.phoneNumber = data[2];
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		departments = Department.readDepartments();
	}

	public boolean addDepartment(Department d)
	{
		for(int i=0; i<departments.size(); i++)
		{
			if(d.name.equals(departments.get(i).name))
			{
				return false;
			}
		}
		departments.add(d);
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}
