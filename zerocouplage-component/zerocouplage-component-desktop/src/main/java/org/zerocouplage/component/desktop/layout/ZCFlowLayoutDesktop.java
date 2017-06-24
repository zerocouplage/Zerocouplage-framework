package org.zerocouplage.component.desktop.layout;

import org.zerocouplage.component.impl.layout.ZCAbstractFlowLayout;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

/**
 * <p>
 * ZCFlowLayoutDesktop is the ZCFlowLayout component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCFlowLayoutDesktop extends ZCAbstractFlowLayout {

	public Object display() throws Exception {
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 5, 5, 5));
		flow.setVgap(4);
		flow.setHgap(4);
		if(getStyle() != null && getStyle().getColor() != null){
		flow.setStyle("-fx-background-color:" + getStyle().getColor() + ";");
		}
		if (getStyle().getHeight() != 0) {
			flow.setPrefHeight(getStyle().getHeight());
		}
		if (getStyle().getWidth() != 0) {
			flow.setPrefWidth(getStyle().getWidth());
		}
		flow.setVgap(4);
		flow.setHgap(4);
		if (getDirection() == X_DIRECTION) {
			flow.setOrientation(Orientation.HORIZONTAL);
		} else if (getDirection() == Y_DIRECTION) {
			flow.setOrientation(Orientation.VERTICAL);
		}
		int tmpCounter = 0;
		while (tmpCounter < getComponent().size()) {
			flow.getChildren().add((Node) getComponent(tmpCounter).display());
			tmpCounter++;
		}
		
		return flow;
	}

}
