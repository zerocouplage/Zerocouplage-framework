package org.zerocouplage.application.desktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.application.desktop.business.RecrutBusiness;
import org.zerocouplage.impl.controller.ZCManagerFactory;

public class DataAccess extends JFrame {

	private static final long serialVersionUID = 1L;
	Vector<String> columnNames, data;
	static IZCManager manager;
	JTable table;
	private String path, id;
	private JScrollPane scroll;
	JButton retour;
	JFrame frame;
	Image image;

	public DataAccess() {
		manager = ZCManagerFactory.getNewManager(this);
	}

	public void creatGui() {
		this.setTitle("Consultation des données ");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		path = "";
		id = "";
		retour = new JButton();

		retour.setIcon(new ImageIcon("images/btn2.png"));

		JPanel ret_an = new JPanel();
		ret_an.setLayout(null);

		ret_an.add(retour);
		scroll = new JScrollPane();
		columnNames = new Vector<String>();
		data = new Vector();
		columnNames.addElement("Nom");
		columnNames.addElement("Prénom");
		columnNames.addElement("date de naissance");
		columnNames.addElement("Email");
		columnNames.addElement("Civilité");
		columnNames.addElement("nbre experience");
		columnNames.addElement("Type de la demande");
		columnNames.addElement("Date de la demande");
		columnNames.addElement("Action");
		columnNames.addElement("Supprimer");
		chargertableau();

		background_table p = new background_table();
		p.setLayout(new BorderLayout());
		p.add(scroll, BorderLayout.CENTER);
		p.add(retour, BorderLayout.SOUTH);

		this.setContentPane(p);
		frame = this;
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
		setSize(1010, 400);
		if (RecrutBusiness.getDataFromCandidat().size() == 0) {
			try {
				manager.executeBusiness("bdVide");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setVisible(false);
		} else {

			setVisible(true);
		}
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void chargertableau() {
		image = new ImageIcon("images/form_under.png").getImage();
		table = new JTable() {
			{

				setOpaque(false);
				setDefaultRenderer(Object.class,
						new DefaultTableCellRenderer() {
							{
								setOpaque(false);
							}
						});
			}

			protected void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
				super.paintComponent(g);
			}
		};

		table.setOpaque(false);
		DefaultTableModel dm;
		dm = new DefaultTableModel();
		data = RecrutBusiness.getDataFromCandidat();
		dm.setDataVector(data, columnNames);
		table.setModel(dm);

		DownloadButtonRenderer download;
		DeleteButtonRenderer delete;

		download = new DownloadButtonRenderer();

		delete = new DeleteButtonRenderer();

		table.getColumn("Action").setCellRenderer(download);
		table.getColumn("Action").setCellEditor(
				new Download(new JCheckBox(), this));

		table.getColumn("Supprimer").setCellRenderer(delete);
		table.getColumn("Supprimer").setCellEditor(
				new Delete(new JCheckBox(), this));
		table.setForeground(Color.WHITE);
		scroll.updateUI();
		scroll.setOpaque(false);

		scroll.setViewportView(table);

	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		DataAccess frame = new DataAccess();
		frame.creatGui();
	}

	public void setIdCandidat(String id) {
		this.id = id;
	}

	public void setPathCv(String path) {
		this.path = path;
	}

	public String getIdCandidat() {
		return this.id;
	}

	public String getPathCv() {
		return this.path;
	}

}

class DownloadButtonRenderer extends JButton implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DownloadButtonRenderer() {
		setOpaque(true);
		setIcon(new ImageIcon("images/voirCv.png"));
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setIcon(new ImageIcon("images/voirCv.png"));
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setIcon(new ImageIcon("images/voirCv.png"));
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		
		return this;
	}
}

class DeleteButtonRenderer extends JButton implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteButtonRenderer() {
		setOpaque(true);
		setIcon(new ImageIcon("images/supp.png"));
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
			setIcon(new ImageIcon("images/supp.png"));
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
			setIcon(new ImageIcon("images/supp.png"));
		}

		return this;
	}
}

class Download extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataAccess myDataAccess;
	protected JButton button;

	private String label;

	private boolean isPushed;

	public Download(JCheckBox checkBox, DataAccess dataAccess) {
		super(checkBox);
		this.myDataAccess = dataAccess;
		button = new JButton();
		button.setIcon(new ImageIcon("images/voirCv.png"));
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {

		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
			button.setIcon(new ImageIcon("images/voirCv.png"));
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
			button.setIcon(new ImageIcon("images/voirCv.png"));
		}
		label = (value == null) ? "" : value.toString();
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {

		if (isPushed) {
			myDataAccess.setPathCv(label);

			try {
				DataAccess.manager.executeBusiness("showCv", true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}

}

class Delete extends DefaultCellEditor {

	DataAccess myDataAccess;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JButton button;

	private String label;

	private boolean isPushed;

	public Delete(JCheckBox checkBox, DataAccess dataAccess) {
		super(checkBox);
		this.myDataAccess = dataAccess;
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {

		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText("supprimer candidat");
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			myDataAccess.setIdCandidat(label);
			if (myDataAccess.table.getRowCount() == 1) {
				myDataAccess.dispose();
			}
			try {

				DataAccess.manager.executeBusiness("deleteCandidat", true);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}

}

class background_table extends JPanel {
	Boolean dimensionAutomatique = true;

	private Image tof = new ImageIcon("images/form_under.png").getImage();

	public void paintComponent(Graphics g) {

		if (dimensionAutomatique) {
			g.drawImage(tof, 0, 0, getWidth(), getHeight(), null);

		} else {

			g.drawImage(tof, 0, 0, tof.getWidth(null), tof.getHeight(null),
					null);
		}
	}
}

class ImageViewport extends JViewport {
	Paint texture;

	public ImageViewport() {
		BufferedImage image = loadImage();
		int w = image.getWidth() / 2;
		int h = image.getHeight() / 2;
		Rectangle2D r = new Rectangle2D.Double(0, 0, w, h);
		texture = new TexturePaint(image, r);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		int w = getWidth();
		int h = getHeight();
		g2.setPaint(texture);
		g2.fillRect(0, 0, w, h);
	}

	private BufferedImage loadImage() {
		BufferedImage image = null;
		String fileName = "images/form_under_final.png";
		try {
			URL url = getClass().getResource(fileName);
			image = ImageIO.read(url);
		} catch (MalformedURLException mue) {
			System.out.println("url: " + mue.getMessage());
		} catch (IOException ioe) {
			System.out.println("read: " + ioe.getMessage());
		}
		return image;
	}
}