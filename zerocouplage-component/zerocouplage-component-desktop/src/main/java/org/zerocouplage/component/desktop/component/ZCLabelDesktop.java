package org.zerocouplage.component.desktop.component;

import org.zerocouplage.component.impl.component.ZCAbstractLabel;

import javafx.scene.control.Label;
/**
 * <p>
 * ZCLabelDesktop is the ZCLabel component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCLabelDesktop extends ZCAbstractLabel {

	private Label label =new Label();
	public Object display() {

		
		label.setText(getLabel());
		label.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		label.setPrefHeight(getStyle().getHeight());
		label.setPrefWidth(getStyle().getWidth());
		
		return label;
	}   

}
   