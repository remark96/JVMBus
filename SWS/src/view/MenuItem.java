package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem implements ActionListener {
	private VerticalMenuBar vmb;
	
	public MenuItem(String nameOfMenuItem, VerticalMenuBar vmb) {
		super(nameOfMenuItem);
		//setBackground(Color.LIGHT_GRAY);
		this.vmb = vmb;
	}
	
	public void addActionListener() {
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
			case "Show departments":
				vmb.showDepartments();
				break;
				
			case "Show study programs":
				vmb.showStudyPrograms();
				break;
				
			case "Show chairs":
				vmb.showChairs();
				break;
				
			case "Show students":
				vmb.showStudents();
				break;
				
			case "Show professors":
				vmb.showProfessors();
				break;
				
			case "Show courses":
				vmb.showCourses();
				break;
	
			case "Sign out":
				vmb.signOut();
				break;
				
			default:
				break;
		}
	}
	

}
