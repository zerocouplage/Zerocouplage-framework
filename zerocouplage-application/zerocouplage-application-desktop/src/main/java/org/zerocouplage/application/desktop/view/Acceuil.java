package org.zerocouplage.application.desktop.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class Acceuil extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IZCManager manager;

	private static final String lien1 = "Liste des candidatures ";
	private static final String lien2 = "Poster une demande de recrutement ";

	private JLabel liste;

	private FormCandidature form;
	private JLabel inscription;
	private JFrame frame;

	public JLabel getListe() {
		return liste;
	}

	public Acceuil() {

		manager = ZCManagerFactory.getNewManager(this);

	}

	public void createGui() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		liste = new JLabel();
		liste.setIcon(new ImageIcon("images/fleche1.png"));

		inscription = new JLabel();
		inscription.setIcon(new ImageIcon("images/fleche2.png"));

		liste.addMouseListener(new RedirectAction());
		inscription.addMouseListener(new RedirectAction());

		panneau po = new panneau();
		po.setLayout(new BoxLayout(po, BoxLayout.Y_AXIS));
		po.setBorder(new EmptyBorder(50, 91, 100, 100));

		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));

		po.add(liste);
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(new JLabel("      "));
		po.add(inscription);

		frame = new JFrame();
		frame.setContentPane(po);

		frame.setTitle("Gestion des rectrutements");
		frame.setExtendedState(JFrame.MAXIMIZED_HORIZ);

		frame.setSize(700, 550);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		Acceuil user = new Acceuil();
		user.createGui();

	}

	class RedirectAction implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == liste) {

				try {

					manager.executeBusiness("processingToAuthentification");
					frame.setVisible(false);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (e.getSource() == inscription) {

				try {
					manager.executeBusiness("processingToForm");
					frame.setVisible(false);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

			if (e.getSource() == inscription) {

				inscription.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.RAISED));

			}

			if (e.getSource() == liste) {

				liste.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.RAISED));

			}

		}

		@Override
		public void mouseExited(MouseEvent e) {

			if (e.getSource() == inscription) {

				inscription.setBorder(new EmptyBorder(0, 0, 0, 0));

			}
			if (e.getSource() == liste) {

				liste.setBorder(new EmptyBorder(0, 0, 0, 0));

			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}

class panneau extends JPanel {
	Boolean dimensionAutomatique = true;

	private Image tof = new ImageIcon("images/ac_final.png").getImage();

	public void paintComponent(Graphics g) {

		if (dimensionAutomatique)

			g.drawImage(tof, 0, 0, getWidth(), getHeight(), null);

		else

			g.drawImage(tof, 0, 0, tof.getWidth(null), tof.getHeight(null),
					null);
	}

}