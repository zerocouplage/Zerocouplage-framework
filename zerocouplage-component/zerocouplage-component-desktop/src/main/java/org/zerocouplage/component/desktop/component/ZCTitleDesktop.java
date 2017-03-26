package org.zerocouplage.component.desktop.component;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

import org.zerocouplage.component.impl.component.ZCAbstractTitle;
/**
 * <p>
 * ZCTitleDesktop is the ZCTitle component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTitleDesktop extends ZCAbstractTitle {

	private Label title =new Label();
	public Object display() {

		
		title.setText(getText());
		title.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		title.setFont(new Font(Double.parseDouble(getHi())));
		title.setPrefHeight(getStyle().getHeight());
		title.setPrefWidth(getStyle().getWidth());
		
		return title;
	}   

}
   