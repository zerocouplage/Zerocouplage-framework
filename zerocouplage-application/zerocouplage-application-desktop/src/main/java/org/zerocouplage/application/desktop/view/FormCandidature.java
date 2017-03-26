package org.zerocouplage.application.desktop.view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class FormCandidature extends JPanel {

	private static final long serialVersionUID = 1L;

	private IZCManager manager;
	IZCLogger logger = ZCLoggerFactory.getLogger(this.getClass());
	private JLabel errorLabel;
	private static final String SHOW_BUTTON = "Postuler";
	private static final String SHO_BUTTON = "Retour";
	private static final String UploadCV = "Upload  ";

	private static final String FIRST_NAME = "Prenom ";
	private static final String LAST_NAME = "Nom  ";
	private static final String EMAIl = "Email ";
	private static final String BIRTHDAY = "Date de naissance ";

	private static final String NbExp = "Nombre d'années d'experience ";

	private static final String CIVILITE = "Civilité ";
	private static final String DEMANDE = "Nature de la demande ";

	private JLabel LabNom, LabPrenom, LabEmail, LabDateNaissance, LabNbrExp,
			LabCivilite, LabCV, LabDemande;
	private JTextField firstName, lastName, birthday, email, nbAnneeExp;
	private JScrollPane scroll;

	public String getNbAnneeExp() {
		return nbAnneeExp.getText();
	}

	public String getMail() {
		return email.getText();
	}

	public String getBirthday() {
		return birthday.getText();
	}

	public String getNatureDemande() {
		return liste1.getSelectedItem().toString();

	}

	private JComboBox liste1;
	private JFileChooser fil;

	private ButtonGroup civilite;

	public String getCivilite() {

		String response = "";
		if (mme.isSelected()) {
			response = "madame";
			return response;

		} else if (mlle.isSelected()) {
			response = "mademoiselle";
			return response;
		} else {
			response = "monsieur";
			return response;
		}

	}

	public String getCv() {

		String path = "";

		if (fil.getSelectedFile() != null) {
			path = fil.getSelectedFile().getPath();
		}

		return path;

	}

	private JRadioButton mme, mlle, mr;
	private JButton annuler, postuler, cv;

	private JFrame frame;

	public FormCandidature() {

		manager = ZCManagerFactory.getNewManager(this);

	}

	public void createGui() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		annuler = new JButton();
		annuler.setIcon(new ImageIcon("images/return.png"));
		System.out.println("test ");
		logger.info("application " + new Date().getTime());
		postuler = new JButton();
		postuler.setIcon(new ImageIcon("images/post.png"));
		cv = new JButton(UploadCV);
		fil = new JFileChooser();

		final JTextField FilePath = new JTextField("");

		cv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fil.showOpenDialog(null);
				FilePath.setText(fil.getSelectedFile().getPath());
			}
		});

		errorLabel = new JLabel();
		LabNom = new JLabel(LAST_NAME);
		LabPrenom = new JLabel(FIRST_NAME);
		LabEmail = new JLabel(EMAIl);
		LabDateNaissance = new JLabel(BIRTHDAY);
		LabCivilite = new JLabel(CIVILITE);
		LabNbrExp = new JLabel(NbExp);
		LabCV = new JLabel(UploadCV);
		LabDemande = new JLabel(DEMANDE);

		firstName = new JTextField("");
		lastName = new JTextField("");
		birthday = new JTextField("");
		email = new JTextField("");
		nbAnneeExp = new JTextField("");
		nbAnneeExp = new JTextField("");

		JPanel panCv = new JPanel();
		panCv.setLayout(new BoxLayout(panCv, BoxLayout.X_AXIS));
		panCv.add(FilePath);
		panCv.add(cv);

		civilite = new ButtonGroup();
		mme = new JRadioButton("Mme", true);
		mme.setOpaque(false);
		mlle = new JRadioButton("Mlle ");
		mlle.setOpaque(false);
		mr = new JRadioButton("Mr ");
		mr.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		Object[] elements = new Object[] { "Stage", "Poste" };

		liste1 = new JComboBox(elements);

		LabNom.setBounds(100, 120, 110, 25);
		firstName.setBounds(270, 120, 190, 25);

		LabPrenom.setBounds(100, 160, 110, 25);
		lastName.setBounds(270, 160, 190, 25);

		LabDateNaissance.setBounds(100, 200, 110, 25);
		birthday.setBounds(270, 200, 190, 25);

		LabEmail.setBounds(100, 240, 110, 25);
		email.setBounds(270, 240, 190, 25);

		LabCivilite.setBounds(100, 300, 110, 25);
		panel.setBounds(270, 300, 240, 25);

		LabNbrExp.setBounds(100, 340, 150, 25);
		nbAnneeExp.setBounds(270, 340, 190, 25);

		LabDemande.setBounds(100, 400, 110, 25);
		liste1.setBounds(270, 400, 190, 25);

		LabCV.setBounds(100, 440, 110, 25);
		panCv.setBounds(270, 440, 190, 25);

		civilite.add(mme);
		panel.add(mme);
		civilite.add(mlle);
		panel.add(mlle);
		civilite.add(mr);
		panel.add(mr);

		postuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					try {
						manager.executeBusiness("Formprocessing");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
		});

		annuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					try {
						manager.executeBusiness("processingAcceuil");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
		});

		JPanel errorPanel = new JPanel();
		errorPanel.add(errorLabel);
		errorPanel.add(new JLabel(""));
		errorPanel.add(new JLabel(""));

		background_under global = new background_under();

		global.setLayout(null);
		postuler.setBounds(320, 560, 110, 25);
		annuler.setBounds(440, 560, 190, 25);

		global.add(LabNom);
		global.add(firstName);

		global.add(LabPrenom);
		global.add(lastName);

		global.add(LabDateNaissance);
		global.add(birthday);

		global.add(LabEmail);
		global.add(email);

		global.add(LabCivilite);
		global.add(panel);
		global.add(LabNbrExp);
		global.add(nbAnneeExp);
		global.add(LabDemande);
		global.add(liste1);

		global.add(LabCV);
		global.add(panCv);
		postuler.setSize(100, 30);
		global.add(postuler);
		annuler.setSize(100, 30);
		global.add(annuler);

		this.frame = new JFrame();
		scroll = new JScrollPane(global,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		frame.getContentPane().add(errorPanel, BorderLayout.NORTH);
		frame.getContentPane().add(scroll);
		frame.setTitle("Recrut Space");
		frame.setSize(670, 658);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		FormCandidature user = new FormCandidature();
		user.createGui();
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

}

class background_under extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Boolean dimensionAutomatique = true;

	private Image tof = new ImageIcon("images/form_under_final.png").getImage();

	public void paintComponent(Graphics g) {

		if (dimensionAutomatique) {
			g.drawImage(tof, 0, 0, getWidth(), getHeight(), null);

		} else {

			g.drawImage(tof, 0, 0, tof.getWidth(null), tof.getHeight(null),
					null);
		}
	}
}

class background extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Boolean dimensionAutomatique = true;

	private Image tof = new ImageIcon("images/tr.png").getImage();

	public void paintComponent(Graphics g) {

		if (dimensionAutomatique) {
			g.drawImage(tof, 0, 0, getWidth(), getHeight(), null);

		} else {

			g.drawImage(tof, 0, 0, tof.getWidth(null), tof.getHeight(null),
					null);
		}
	}
}