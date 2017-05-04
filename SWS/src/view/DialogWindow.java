package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.Controller;

@SuppressWarnings("serial")
public class DialogWindow extends JDialog {
	
	private JLabel title;
	
	private String[] namesOfFields;
	private TextField[] fields;
	
	private JPanel mainPanel;
	private JPanel panelForButtons;
	
	private JButton button1;
	private JButton buttonCancel;
	
	private final int SIZE = 500;
	
	public DialogWindow (JFrame frame, String typeOfDialog, String[] namesOfFields, boolean modal) {
		super(frame, typeOfDialog, modal);
		setLocation(frame.getLocation().x + frame.getWidth()/4, frame.getLocation().y + frame.getHeight()/4);
		setSize(SIZE, SIZE);
		setLayout(new BorderLayout());
		this.namesOfFields = namesOfFields;
		
		title = new JLabel(typeOfDialog.toUpperCase(), JLabel.CENTER);
		title.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		title.setForeground(Color.BLUE);
		
		mainPanel = new JPanel(new GridLayout(namesOfFields.length*2 + 4, 1));
		panelForButtons = new JPanel(new FlowLayout());
		
		button1 = new JButton(typeOfDialog);
		buttonCancel = new JButton("Cancel");
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller controller = ((MainWindow) getParent()).getController();
				controller.checkLogin();
				
			}
		});
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		panelForButtons.add(button1);
		panelForButtons.add(buttonCancel);
		
		fields = new TextField[namesOfFields.length];
		
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		JLabel label;
		for (int i = 0; i < namesOfFields.length; i++) {
			label = new JLabel(namesOfFields[i], JLabel.CENTER);
			label.setForeground(Color.BLUE);
			mainPanel.add(label);
			
			fields[i] = new TextField(35);
			fields[i].addFocusListener();
			mainPanel.add(fields[i]);
			
		}
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		
		getContentPane().add(title, BorderLayout.NORTH);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(panelForButtons, BorderLayout.SOUTH);
	}

	public String[] getNamesOfFields() {
		return namesOfFields;
	}

	public void setNamesOfFields(String[] namesOfFields) {
		this.namesOfFields = namesOfFields;
	}

	public TextField[] getFields() {
		return fields;
	}

	public void setFields(TextField[] fields) {
		this.fields = fields;
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

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(JButton buttonCancel) {
		this.buttonCancel = buttonCancel;
	}
	
	
}
