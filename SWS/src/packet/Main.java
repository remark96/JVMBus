package packet;

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
	
}
