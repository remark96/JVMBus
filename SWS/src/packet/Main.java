package packet;

import java.util.ArrayList;

import model.Faculty;
import view.MyWindow;

public class Main 
{
	public static void main(String[] args) 
	{
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);
		Faculty model = Faculty.createModel();
		System.out.println(model.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static void show(Object data)
	{
		for(int i=0; i< ((ArrayList<Object>) data).size(); i++)
		{
			System.out.println(((ArrayList<Object>) data).get(i).toString());
		}
	}
}
