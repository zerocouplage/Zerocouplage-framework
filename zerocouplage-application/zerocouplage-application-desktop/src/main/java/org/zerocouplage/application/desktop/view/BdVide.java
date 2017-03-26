package org.zerocouplage.application.desktop.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class BdVide {
	JFrame frame;
	JButton retour;
	IZCManager manager;

	public BdVide() {
		manager = ZCManagerFactory.getNewManager(this);
	}

	public void createGui() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame = new JFrame("Erreur");
		retour = new JButton();
		retour.setIcon(new ImageIcon("images/btn2.png"));
		panel_vide pa = new panel_vide();
		frame.add(pa);
		pa.setLayout(null);

		retour.setBounds(230, 190, 90, 20);
		pa.add(retour);
		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);

				try {

					try {
						manager.executeBusiness("processingAcceuil");
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

		JLabel label = new JLabel("la base de données est vide");
		label.setBounds(110, 110, 400, 30);
		pa.add(label);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		BdVide vide = new BdVide();
		vide.createGui();
	}

}

class panel_vide extends JPanel {
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