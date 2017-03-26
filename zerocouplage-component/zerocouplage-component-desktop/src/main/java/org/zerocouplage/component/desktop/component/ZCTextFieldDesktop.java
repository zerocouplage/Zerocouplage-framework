package org.zerocouplage.component.desktop.component;

import javafx.scene.control.TextField;

import org.zerocouplage.component.impl.component.ZCAbstractTextField;

/**
 * <p>
 * ZCTextFieldDesktop is the ZCTextField component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTextFieldDesktop extends ZCAbstractTextField {
	private TextField textF = new TextField();

	public Object display() {

		textF.setText(getText());
		textF.setId(getName());
		textF.setPromptText(getPlaceHolder());
		textF.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		textF.setPrefHeight(getStyle().getHeight());
		textF.setPrefWidth(getStyle().getWidth());
		return textF;
	}
	
	@Override
	public String getText() {
		return textF.getText();
	}
	@Override
	public void setText(String text) {
		textF.setText(text);
	}


}
