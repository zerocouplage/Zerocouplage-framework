package org.zerocouplage.component.desktop.component;

import javafx.scene.control.RadioButton;

import org.zerocouplage.component.impl.component.ZCAbstractRadioButton;
/**
 * <p>
 * ZCRadioButtonDesktop is the ZCRadioButton component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCRadioButtonDesktop extends ZCAbstractRadioButton {

	private RadioButton radio = new RadioButton();
	
	public Object display() {

		radio.setId(getName());
		radio.setText(getText());
		radio.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		if (isChecked()) {
			radio.setSelected(true);
		}

		radio.setPrefHeight(getStyle().getHeight());
		radio.setPrefWidth(getStyle().getWidth());
		return radio;
	}

}
