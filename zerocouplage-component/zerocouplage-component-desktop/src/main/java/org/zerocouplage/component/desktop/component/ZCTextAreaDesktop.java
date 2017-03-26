package org.zerocouplage.component.desktop.component;

import javafx.scene.control.TextArea;

import org.zerocouplage.component.impl.component.ZCAbstractTextArea;

/**
 * <p>
 * ZCTextAreaDesktop is the ZCTextArea component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTextAreaDesktop extends ZCAbstractTextArea {
	private TextArea textA = new TextArea();
	public Object display() {
		
		textA.setText(getText());
		textA.setId(getName());
		textA.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		textA.setPrefHeight((int)getStyle().getHeight());
		textA.setPrefWidth((int)getStyle().getWidth());
		textA.setPrefHeight(getStyle().getHeight());
		textA.setPrefWidth(getStyle().getWidth());
		
		return textA;
	}

}

