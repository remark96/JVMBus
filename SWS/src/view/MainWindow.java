package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.LoginActionListener;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private JLabel welcomeMessage;
	
	private Page pageForUser = null;
	private JPanel mainPanel;
	private JPanel panelForButtons;
	
	private DialogWindow login;
	
	private JLabel labelForImage;
	
	private JButton buttonLogin;
	private JButton buttonExit;
	
	private Controller controller;

	public MainWindow(Controller controller) {
		super("Student Web Service");
		setSize(800, 450);
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.controller = controller;
	
		welcomeMessage = new JLabel("WELCOME TO APPLICATION",JLabel.CENTER); 
		welcomeMessage.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		welcomeMessage.setForeground(Color.BLUE);
		
		labelForImage = new JLabel("", new ImageIcon("images/logo.jpg"), JLabel.CENTER);
		
		mainPanel = new JPanel(new BorderLayout());
		panelForButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,25, 25));
		
		buttonLogin = new JButton("Login");
		buttonExit = new JButton("Exit");
		
		buttonLogin.addActionListener(new LoginActionListener(this));
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
				
			}
		});
		
		panelForButtons.add(buttonLogin);
		panelForButtons.add(buttonExit);
		
		mainPanel.add(welcomeMessage, BorderLayout.NORTH);
		mainPanel.add(labelForImage, BorderLayout.CENTER);
		mainPanel.add(panelForButtons, BorderLayout.SOUTH);
	
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public JLabel getWelcomeMessage() { return welcomeMessage; }
	public void setWelcomeMessage(JLabel welcomeMessage) { this.welcomeMessage = welcomeMessage; }
	
	public Page getPageForUser() { return pageForUser; }
	public void setPageForUser(Page pageForUser) { this.pageForUser = pageForUser;	}

	public JPanel getMainPanel() { return mainPanel; }
	public void setMainPanel(JPanel mainPanel) { this.mainPanel = mainPanel; }
	
	public JPanel getPanelForButtons() { return panelForButtons; }
	public void setPanelForButtons(JPanel panelForButtons) { this.panelForButtons = panelForButtons; }
	
	public DialogWindow getLogin() { return login; }
	public void setLogin(DialogWindow login) { this.login = login; }
	
	public JLabel getLabelForImage() { return labelForImage; }
	public void setLabelForImage(JLabel labelForImage) { this.labelForImage = labelForImage; }
	
	public JButton getButtonLogin() { return buttonLogin; }
	public void setButtonLogin(JButton buttonLogin) { this.buttonLogin = buttonLogin; }
	
	public JButton getButtonExit() { return buttonExit; }
	public void setButtonExit(JButton buttonExit) { this.buttonExit = buttonExit; }
	
	public  void putHomePage() {
		getContentPane().removeAll();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		refresh();
	}
	
	public void putPageForUser() {
		getContentPane().removeAll();
		getContentPane().add(pageForUser, BorderLayout.CENTER);
		refresh();
	}
	
	public void refresh() {
		revalidate();
		repaint();
	}

}
