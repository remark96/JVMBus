package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LoginActionListener implements ActionListener {
	private MainWindow frame;
	
	public LoginActionListener(MainWindow frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] namesOfFields = {"Username", "Password"};
		DialogWindow login= new DialogWindow(frame, "Login", namesOfFields, true);
		frame.setLogin(login);
		login.setVisible(true);

	}

}
