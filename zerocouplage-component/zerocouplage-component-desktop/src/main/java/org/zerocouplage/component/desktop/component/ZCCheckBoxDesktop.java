package org.zerocouplage.component.desktop.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.component.impl.component.ZCAbstractCheckBox;
import org.zerocouplage.impl.controller.ZCManagerFactory;

/**
 * <p>
 * ZCCheckBoxDesktop is the ZCCheckBox component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCCheckBoxDesktop extends ZCAbstractCheckBox {

	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCCheckBoxDesktop.class);
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

	public void setAction(final String actionName, final Object thisClass) {
		this.action = actionName;
		checkBox.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				try {
					IZCManager manager = ZCManagerFactory.getNewManager(thisClass);
					manager.executeBusiness(actionName, false, getName());
				} catch (ClassNotFoundException e) {
					logger.error("the business indicated in you're button's action is not found in the zerocouplage.xml", e);
					e.printStackTrace();
				} catch (InstantiationException e) {
					logger.error("error while instanciating the class", e);
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					logger.error("error illegalAccess", e);
					e.printStackTrace();
				}
			}
		});

	}

	public String getAction() {
		return this.action;
	}

}
