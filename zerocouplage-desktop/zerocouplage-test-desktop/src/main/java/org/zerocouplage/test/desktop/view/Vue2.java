package org.zerocouplage.test.desktop.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vue2 extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel values;
	private JFrame frame;
	
	public void createGui(){
		
		frame = new JFrame();
		values=new JLabel();
		frame.setContentPane(this);
		frame.setTitle("vue2");
		frame.setPreferredSize(new Dimension(300, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args){
		new Vue2();
	}
}
