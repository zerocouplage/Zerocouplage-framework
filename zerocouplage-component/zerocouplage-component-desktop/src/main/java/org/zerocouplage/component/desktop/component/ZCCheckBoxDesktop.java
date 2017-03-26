package org.zerocouplage.component.desktop.component;

import javafx.scene.control.CheckBox;

import org.zerocouplage.component.impl.component.ZCAbstractCheckBox;

/**
 * <p>
 * ZCCheckBoxDesktop is the ZCCheckBox component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCCheckBoxDesktop extends ZCAbstractCheckBox {

	private CheckBox checkBox = new CheckBox();

	@Override
	public Object display() {

		checkBox.setId(getName());
		checkBox.setText(getText());
		checkBox.setStyle("-fx-text-fill:" + getStyle().getColor() + ";");
		checkBox.setPrefHeight(getStyle().getHeight());
		checkBox.setPrefWidth(getStyle().getWidth());
		checkBox.setSelected(isChecked());

		return checkBox;
	}

}
