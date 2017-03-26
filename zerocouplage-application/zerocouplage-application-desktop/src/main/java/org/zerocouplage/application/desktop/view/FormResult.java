package org.zerocouplage.application.desktop.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.application.desktop.bean.BeanUserOut;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class FormResult extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel personDetail;
	private JButton retour;

	private JFrame frame = new JFrame();

	private IZCManager manager;

	public FormResult() {

		manager = ZCManagerFactory.getNewManager(this);
	}

	public void createResultGui(BeanUserOut out) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String message = "Merci " + out.getCivilite() + "  "
				+ out.getFirstName() + " " + out.getLastName()
				+ " votre demande a été envoyée avec succès !";
		personDetail = new JLabel(message, SwingConstants.CENTER);

		retour = new JButton();
		retour.setIcon(new ImageIcon("images/btn2.png"));

		retour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);

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

		panel p = new panel();
		p.setLayout(null);

		retour.setBounds(400, 240, 90, 30);

		personDetail.setBounds(90, 150, 400, 30);

		p.add(personDetail);
		p.add(retour);

		frame.setContentPane(p);
		frame.setTitle("Demande envoyée");
		frame.setPreferredSize(new Dimension(610, 400));
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		new FormResult();

	}
}

class panel extends JPanel {
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
