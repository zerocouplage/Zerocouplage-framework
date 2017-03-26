package org.zerocouplage.component.desktop.component;

import javafx.scene.control.PasswordField;

import org.zerocouplage.component.impl.component.ZCAbstractPassword;

/**
 * <p>
 * ZCPasswordDesktop is the ZCPassword component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPasswordDesktop extends ZCAbstractPassword {
	private PasswordField passF = new PasswordField();
	@Override
	public Object display() throws Exception {
		passF.setId(getName());
		passF.setText(getText());
		passF.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		passF.setPrefHeight(getStyle().getHeight());
		passF.setPrefWidth(getStyle().getWidth());
		
		return passF;
	}
	
	@Override
	public String getText() {
		return passF.getText();
	}
	@Override
	public void setText(String text) {
		passF.setText(text);
	}

}
