package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

@SuppressWarnings("serial")
public class Menu extends JMenu implements ActionListener {
	private VerticalMenuBar vmb;
	
	public Menu(String nameOfMenuItem, VerticalMenuBar vmb, int it) {
		super(nameOfMenuItem);
		setBackground(Color.LIGHT_GRAY);
		this.vmb = vmb;
	}
	
	public void addActionListener() {
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		/*for (int i = 0; i < vmb.getMenuCount(); i++) {
			vmb.getMenu(i).setBackground(Color.LIGHT_GRAY);
		}
		setBackground(Color.BLUE);*/
	}
	
	

}
