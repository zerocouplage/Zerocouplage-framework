package org.zerocouplage.test.desktop.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.zerocouplage.test.desktop.bean.UserBeanResult;

public class UserDisplayView1 extends JPanel {
	public UserDisplayView1() {
	}
	
	public void createResultGui() {
	JFrame frame = new JFrame();
	frame.setContentPane(this);
	frame.setTitle("Hello");
	frame.setPreferredSize(new Dimension(650, 100));
	frame.pack();
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {

		new UserDisplayView1();

	}
}
