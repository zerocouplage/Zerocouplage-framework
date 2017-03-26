package org.zerocouplage.component.desktop.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import org.zerocouplage.component.impl.component.ZCAbstractButton;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.impl.controller.ZCManagerFactory;


/**
 * <p>
 * ZCButtonDesktop is the ZCButton component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCButtonDesktop extends ZCAbstractButton {

	
	private Button button = new Button();
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCButtonDesktop.class);
	@Override
	public Object display() {

		button.setId(getName());
		button.setText(getText());
		button.setStyle("-fx-text-fill:" + getStyle().getColor());

		button.setPrefHeight(getStyle().getHeight());
		button.setPrefWidth(getStyle().getWidth());
		return button;
	}

	public void setAction(final String actionName, final Object thisClass) {
		this.action = actionName;
		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				try {

					IZCManager manager = ZCManagerFactory.getNewManager(thisClass);
					manager.executeBusiness(actionName);
				} catch (ClassNotFoundException e) {
					logger.error("the business indicated in you're button's action is not found in the zerocouplage.xml");
					e.printStackTrace();
				} catch (InstantiationException e) {
					logger.error("error while instanciating the class");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					logger.error("error illegalAccess");
					e.printStackTrace();
				}
			}
		});

	}

	public String getAction() {
		return this.action;
	}

}
