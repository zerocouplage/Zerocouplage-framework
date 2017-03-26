package org.zerocouplage.component.desktop.layout;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import org.zerocouplage.component.impl.layout.ZCAbstractBorderLayout;

/**
 * <p>
 * ZCBorderLayoutDesktop is the ZCBorderLayout component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCBorderLayoutDesktop extends ZCAbstractBorderLayout {

	public Object display() throws Exception {
		BorderPane border = new BorderPane();

		border.setPadding(new Insets(5, 5, 5, 5));
		if (!getStyle().equals(null)) {
			border.setStyle("-fx-background-color:" + getStyle().getColor()
					+ ";");
		}
		if (getStyle().getHeight() != 0) {
			border.setPrefHeight(getStyle().getHeight());
		}
		if (getStyle().getWidth() != 0) {
			border.setPrefWidth(getStyle().getWidth());
		}
		if (getComponentNorth() != null) {
			int Ntmp = 0;
			while (Ntmp < getComponentNorth().size()) {
				border.setTop((Node) getComponentNorth().get(Ntmp).display());
				Ntmp++;
			}
		}
		if (getComponentWest() != null) {
			int Wtmp = 0;
			while (Wtmp < getComponentWest().size()) {
				border.setLeft((Node) getComponentWest().get(Wtmp).display());
				Wtmp++;
			}
		}
		if (getComponentEast() != null) {
			int Etmp = 0;
			while (Etmp < getComponentEast().size()) {
				border.setRight((Node) getComponentEast().get(Etmp).display());
				Etmp++;
			}
		}
		if (getComponentCenter() != null) {
			int Ctmp = 0;
			while (Ctmp < getComponentCenter().size()) {
				border.setCenter((Node) getComponentCenter().get(Ctmp)
						.display());
				Ctmp++;
			}
		}
		if (getComponentSouth() != null) {
			int Stmp = 0;
			while (Stmp < getComponentSouth().size()) {
				border.setBottom((Node) getComponentSouth().get(Stmp).display());
				Stmp++;
			}
		}

		return border;
	}
}
