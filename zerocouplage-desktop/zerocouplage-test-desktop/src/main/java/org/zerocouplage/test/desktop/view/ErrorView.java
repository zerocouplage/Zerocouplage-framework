package org.zerocouplage.test.desktop.view;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.zerocouplage.common.reflect.ReflectManager;

public class ErrorView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel values;
	private JFrame frame;

	public ErrorView() {
		frame = new JFrame();
		values = new JLabel();
		frame.setContentPane(this);
		frame.setTitle("Error");
		frame.setPreferredSize(new Dimension(300, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public void displayError(HashMap<String, String> values,
			HashMap<String, String> listError) {
		
		StringBuilder builder = new StringBuilder();
		this.frame.setVisible(true);
		for (String fieldName : values.keySet()) {
			builder.append(fieldName + " : " + values.get(fieldName)
					+ " \n<br/> ");
		}
		this.values.setText("<html>" + builder.toString() + "<html>");
		this.add(this.values);

		StringBuilder builderr = new StringBuilder();
		this.frame.setVisible(true);
		for (String fieldName : listError.keySet()) {
			builder.append(fieldName + " : " + listError.get(fieldName)
					+ " \n<br/> ");
		}
		this.values.setText("<html><font color = black >" + builder.toString()
				+ "</font><html>");
		this.add(this.values);

	}

	public static void main(String[] args) {
		new ErrorView();
	}
}
