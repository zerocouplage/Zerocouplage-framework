package org.zerocouplage.test.desktop.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.zerocouplage.test.desktop.bean.UserBeanResult;

public class UserDisplayView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel personDetail;

	public UserDisplayView() {
	}

	public void createResultGui(UserBeanResult out) {
		setLayout(new BorderLayout());
		String message = "Hello " + out.getFirstname() + " "
				+ out.getLastname() + "\n    vous avez age  :\n"
				+ out.getAgeRes() + " votre date de naissance: "
				+ out.getDate_naissance() + " taille : " + out.getTailleRes()
				+ " reponse : " + out.getQuestionRes() + " la liste est "
				+ out.getList();
		personDetail = new JLabel(message);

		this.add(personDetail, BorderLayout.CENTER);
		try {
			File f = out.getFile();
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			try {
				String line = br.readLine();

				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}

				br.close();
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : "
						+ exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
		JFrame frame = new JFrame();
		frame.setContentPane(this);
		frame.setTitle("Hello");
		frame.setPreferredSize(new Dimension(650, 100));
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		new UserDisplayView();

	}

}
