package org.zerocouplage.component.desktop.component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import org.zerocouplage.component.api.component.ZCComboBoxItem;
import org.zerocouplage.component.impl.component.ZCAbstractComboBox;

/**
 * <p>
 * ZCComboBoxDesktop is the ZCComboBox component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCComboBoxDesktop extends ZCAbstractComboBox {

	private ComboBox<Object> comboBox = new ComboBox<Object>();
	private String selectedItem;

	public Object display() {

		ObservableList<String> values = FXCollections.observableArrayList();
		int tmp = 0;
		while (tmp < getItems().size()) {
			values.add(getItems().get(tmp).getValue());
			tmp++;
		}

		comboBox.getItems().addAll(values);
		if (getSelectedName() != null) {
			comboBox.setValue(getSelectedName());
		}
		comboBox.setVisibleRowCount(3);
		comboBox.setPrefHeight(getStyle().getHeight());
		comboBox.setPrefWidth(getStyle().getWidth());
		return comboBox;
	}

	public String getSelectedName() {

		return selectedItem;
	}

	public void setSelectedName(ZCComboBoxItem item) {
		selectedItem = item.getValue();
	}

}
