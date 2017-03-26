package org.zerocouplage.application.desktop.view;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jpedal.examples.viewer.Commands;
import org.jpedal.examples.viewer.Viewer;

import org.zerocouplage.application.desktop.bean.BeanUserOut;

public class ShowFile {
	public ShowFile(){
		
	}

	public void createGui(BeanUserOut result){
		
		final JFrame frame = new JFrame();
	    frame.getContentPane().setLayout(new BorderLayout());
	    
	   
	    JPanel rootContainer = new JPanel();  

	    Viewer viewer = new Viewer(rootContainer, null);
	    viewer.setupViewer();
	    
	    frame.add(rootContainer, BorderLayout.CENTER);
	    
	    
	    rootContainer.setVisible(true);
	    
	    frame.setTitle("consultation du cv");
	    frame.setSize(800, 600);
	    frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}
		});
	    
	    frame.setVisible(true);
	    
	    Object[] input;
	    
	    input = new Object[]{result.getPathCv()};

	    viewer.executeCommand(Commands.OPENFILE, input);
	}
	 public static void main(String[] args) {
		    
		 new ShowFile();
  }


}
