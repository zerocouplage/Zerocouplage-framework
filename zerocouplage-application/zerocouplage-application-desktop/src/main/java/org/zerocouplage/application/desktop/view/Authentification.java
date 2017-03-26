package org.zerocouplage.application.desktop.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class Authentification extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String SUBMIT_BUTTON = "Se connecter";
	private static final String CANCEL_BUTTON = "Annuler";
	private static final String LOGIN = "Login ";
	private static final String PASSWORD = "Password";
	private static final String TITLE = "Authentification ";
	private IZCManager manager;
	private JLabel errorLabel;

	public Authentification() {
		manager = ZCManagerFactory.getNewManager(this);
	}

	private JLabel LabLogin, LabPass;
	private static JTextField login;
	private static JTextField pass;
	private JButton submit, cancel;

	public static String getLogin() {
		return login.getText();
	}

	public static String getPassword() {
		return pass.getText();
	}

	public void createGui() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		submit = new JButton();
		submit.setIcon(new ImageIcon("images/btn1.png"));
		cancel = new JButton();
		cancel.setIcon(new ImageIcon("images/btn2.png"));
		errorLabel = new JLabel("");
		LabLogin = new JLabel(LOGIN);
		LabPass = new JLabel(PASSWORD);
		login = new JTextField(15);
		pass = new JPasswordField(15);

		JPanel errorPanel = new JPanel();

		pann panel = new pann();
		panel.setLayout(null);
		errorPanel.add(errorLabel);
		add(errorPanel, BorderLayout.NORTH);
		LabLogin.setBounds(90, 130, 180, 30);
		login.setBounds(150, 130, 180, 25);

		LabPass.setBounds(90, 180, 180, 30);
		pass.setBounds(150, 180, 180, 25);

		submit.setBounds(230, 260, 110, 25);
		cancel.setBounds(360, 260, 90, 25);

		panel.add(LabLogin);
		panel.add(LabPass);
		panel.add(login);
		panel.add(submit);
		panel.add(pass);
		panel.add(cancel);

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

				try {

					try {
						try {
							manager.executeBusiness("processingAcceuil");
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				}

			}
		});

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

				try {

					try {
						try {
							manager.executeBusiness("processingToFullDB");
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				}

			}
		});

		super.setTitle(TITLE);
		setSize(610, 458);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setLocationRelativeTo(null);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void processError(HashMap<String, String> listError) {
		StringBuilder builder = new StringBuilder();
		setVisible(true);
		for (String fieldName : listError.keySet()) {
			builder.append(fieldName + " : " + listError.get(fieldName)
					+ " \n<br/> ");
		}
		System.out.println("erreur");
		this.errorLabel.setText("<html><font color = red >"
				+ builder.toString() + "</font><html>");
	}

	public static void main(String[] args) {
		Authentification auth = new Authentification();
		auth.createGui();
	}
}

class pann extends JPanel {
	Boolean dimensionAutomatique = true;

	private Image tof = new ImageIcon("images/login_final.png").getImage();

	public void paintComponent(Graphics g) {

		if (dimensionAutomatique) {
			g.drawImage(tof, 0, 0, getWidth(), getHeight(), null);

		} else {

			g.drawImage(tof, 0, 0, tof.getWidth(null), tof.getHeight(null),
					null);
		}
	}
}