package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.Controller;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private JLabel title;
	
	private JPanel mainPanel;
	private JPanel panelForButtons;
	
	private DialogWindow login;
	private DialogWindow register;
	
	private JLabel labelForImage;
	
	private JButton buttonLogin;
	private JButton buttonRegister;
	private JButton buttonExit;
	
	private Controller controller;

	public MainWindow(Controller controller) {
		super("Student Web Service");
		setSize(800, 450);
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.controller = controller;
	
		title = new JLabel("WELCOME TO APPLICATION",JLabel.CENTER); 
		title.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		title.setForeground(Color.BLUE);
		
		labelForImage = new JLabel("", new ImageIcon("images/logo.jpg"), JLabel.CENTER);
		
		mainPanel = new JPanel(new BorderLayout());
		panelForButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,25, 25));
		
		buttonLogin = new JButton("Login");
		buttonRegister = new JButton("Register");
		buttonExit = new JButton("Exit");
		
		buttonLogin.addActionListener(new LoginActionListener(this));
		buttonRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] namesOfFields = {"Name","Surname", "Username", "Password"};
				register = new DialogWindow(null, "Register", namesOfFields, true);
				register.setVisible(true);
				
			}
		});
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
				
			}
		});
		
		panelForButtons.add(buttonLogin);
		panelForButtons.add(buttonRegister);
		panelForButtons.add(buttonExit);
		
		mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(labelForImage, BorderLayout.CENTER);
		mainPanel.add(panelForButtons, BorderLayout.SOUTH);
	
		homePage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	/*public JLabel getTitle() {
	return title;
	}*/
	
	public void setTitle(JLabel title) {
		this.title = title;
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public JPanel getPanelForButtons() {
		return panelForButtons;
	}
	
	public void setPanelForButtons(JPanel panelForButtons) {
		this.panelForButtons = panelForButtons;
	}
	
	public DialogWindow getLogin() {
		return login;
	}
	
	public void setLogin(DialogWindow login) {
		this.login = login;
	}
	
	public DialogWindow getRegister() {
		return register;
	}
	
	public void setRegister(DialogWindow register) {
		this.register = register;
	}
	
	public JLabel getLabelForImage() {
		return labelForImage;
	}
	
	public void setLabelForImage(JLabel labelForImage) {
		this.labelForImage = labelForImage;
	}
	
	public JButton getButtonLogin() {
		return buttonLogin;
	}
	
	public void setButtonLogin(JButton buttonLogin) {
		this.buttonLogin = buttonLogin;
	}
	
	public JButton getButtonRegister() {
		return buttonRegister;
	}
	
	public void setButtonRegister(JButton buttonRegister) {
		this.buttonRegister = buttonRegister;
	}
	
	public JButton getButtonExit() {
		return buttonExit;
	}
	
	public void setButtonExit(JButton buttonExit) {
		this.buttonExit = buttonExit;
	}
	
	public void homePage() {
		getContentPane().remove(mainPanel);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		refresh();
	}
	
	public void refresh() {
		revalidate();
		repaint();
	}

}
