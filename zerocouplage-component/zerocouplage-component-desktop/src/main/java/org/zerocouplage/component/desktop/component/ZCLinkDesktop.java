package org.zerocouplage.component.desktop.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

import org.zerocouplage.component.impl.component.ZCAbstractlink;

import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.impl.controller.ZCManagerFactory;


/**
 * <p>
 * ZCLinkDesktop is the ZCLink component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public class ZCLinkDesktop extends ZCAbstractlink {
	private Hyperlink link = new Hyperlink();

	@Override
	public Object display() {

		link.setId(getName());
		link.setText(getText());
		link.setStyle("-fx-text-fill:" + getStyle().getColor());

		link.setPrefHeight(getStyle().getHeight());
		link.setPrefWidth(getStyle().getWidth());
		return link;
	}

	public void setAction(final String actionName, final Object thisClass) {
		this.action = actionName;
		link.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				try {

					IZCManager manager = ZCManagerFactory.getNewManager(thisClass);
					manager.executeBusiness(actionName);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (InstantiationException e) {
				
					e.printStackTrace();
				} catch (IllegalAccessException e) {
				
					e.printStackTrace();
				}
			}
		});

	}

	public String getAction() {
		return this.action;
	}

}
