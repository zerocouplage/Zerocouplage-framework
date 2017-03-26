package org.zerocouplage.test.desktop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.common.reflect.ReflectManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class UserView extends JPanel {

	private static final long serialVersionUID = 1L;

	private IZCManager manager;

	private static final String SHOW_BUTTON = "Submit";
	private static final String FIRST_NAME = "First Name ";
	private static final String LAST_NAME = "Last Name  ";
	private static final String BIRTHDAY = "Birthday";
	private static final String AGE = "Age ";
	private static final String SIZE = "Size ";
	private static final String FILE = "Upload your CV ";
	private static final String QUESTION = "Are you interested in ZeroCouplage?";
	private String[] listToString={"zerocouplage","zc_val","validateurjava"};
	
	private JLabel LabFirstName, LablastName, LabDateNaissance, LabAge,
			LabTaille, LabQuestion,Labfile,path;
	private JTextField firstName, lastName, birthday, age, size;
	private ButtonGroup question;
	private JButton parcourir;
	private JRadioButton repPos, repNeg;
	private JFileChooser fil;
	


	public String getFil() {
		
		String path = "";
		
		if(fil.getSelectedFile() != null)
		{
			path = fil.getSelectedFile().getPath();
		}
		
		return path;
	}


	private JButton submit,save;

	private JLabel errorLabel;

	private JFrame frame;

	public UserView() {
		manager = ZCManagerFactory.getNewManager(this);
	}

	public void createGui() {
		
		submit = new JButton(SHOW_BUTTON);
		save=new JButton("save");
		errorLabel = new JLabel("Welcome");
		LabFirstName = new JLabel(FIRST_NAME);
		LablastName = new JLabel(LAST_NAME);
		LabDateNaissance = new JLabel(BIRTHDAY);
		LabAge = new JLabel(AGE);
		LabTaille = new JLabel(SIZE);
		Labfile = new JLabel(FILE);
		LabQuestion = new JLabel(QUESTION);

		firstName = new JTextField("");
		lastName = new JTextField("");
		birthday = new JTextField("");
		age = new JTextField("");
		size = new JTextField("");
		path=new JLabel();
		question = new ButtonGroup();
		repPos = new JRadioButton("Yes", true);
		repNeg = new JRadioButton("No ");
		
		JPanel pan=new JPanel();
		parcourir=new JButton("parcourir");
		fil = new JFileChooser();

		parcourir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				fil.showOpenDialog(null);		
				path.setText(getFil());
			}
		});
	
	

		JPanel panel = new JPanel();

		JPanel editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));

		labelPanel.add(LabFirstName);
		labelPanel.add(LablastName);

		labelPanel.add(LabDateNaissance);
		labelPanel.add(LabAge);
		labelPanel.add(LabTaille);
		labelPanel.add(Labfile);
		labelPanel.add(LabQuestion);

		question.add(repPos);
		panel.add(repPos);
		question.add(repNeg);
		panel.add(repNeg);

		editPanel.add(labelPanel);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(0, 1));

		fieldPanel.add(firstName);
		fieldPanel.add(lastName);
		fieldPanel.add(birthday);
		fieldPanel.add(age);
		fieldPanel.add(size);
		pan.setLayout(new GridLayout(1, 2));
		pan.add(path);
		pan.add(parcourir);
		fieldPanel.add(pan);

		fieldPanel.add(panel);

		editPanel.add(fieldPanel);

		JPanel controlPanel = new JPanel();
		controlPanel.add(submit);
		controlPanel.add(save);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);

				try {

					try {
						manager.executeBusiness("processing");
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				}

			}
		});
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);

				try {

					try {
						manager.executeBusiness("processing2");
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				}

			}
		});
		setLayout(new BorderLayout());
		JPanel errorPanel = new JPanel();
		errorPanel.add(errorLabel);
		add(errorPanel, BorderLayout.NORTH);
		add(editPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		this.frame = new JFrame();
		frame.setContentPane(this);
		frame.setTitle("Form");
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

	public String getBirthday() {
		return birthday.getText();
	}

	public String getAge() {
		return age.getText();
	}

	public String getSizee() {
		return size.getText();
	}

	public String getQuestion() {
		String response="";
		if (repPos.isSelected()) {
			response ="true";			
		} else {
			response ="false";
		}
		return response;
	}
	public String[] getListToString() {
		return listToString;
		}

	public void processError(HashMap<String, String> listError) {
		StringBuilder builder = new StringBuilder();
		this.frame.setVisible(true);
		for (String fieldName : listError.keySet()) {
			builder.append(fieldName + " : " + listError.get(fieldName)
					+ " \n<br/> ");
		}
		this.errorLabel.setText("<html><font color = red >"
				+ builder.toString() + "</font><html>");
	}

	public static void main(String[] args) {
		UserView userView = new UserView();
		
		userView.createGui();
	}

}
