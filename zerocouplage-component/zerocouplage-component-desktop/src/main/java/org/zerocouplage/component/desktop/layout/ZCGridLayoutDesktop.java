package org.zerocouplage.component.desktop.layout;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import org.zerocouplage.component.impl.layout.ZCAbstractGridLayout;
/**
 * <p>
 * ZCGridLayoutDesktop is the ZCGridLayout component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCGridLayoutDesktop extends ZCAbstractGridLayout {

	public Object display() throws Exception {
		GridPane gride = new GridPane();
		gride.setPadding(new Insets(5, 5, 5, 5));
		gride.setVgap(4);
		gride.setHgap(4);
		if (!getStyle().equals(null)) {
			gride.setStyle("-fx-background-color:" + getStyle().getColor());
		}
		if (getStyle().getHeight() != 0) {
			gride.setPrefHeight(getStyle().getHeight());
		}
		if (getStyle().getWidth() != 0) {
			gride.setPrefWidth(getStyle().getWidth());
		}
		int tmpCounter = 0;
		while (tmpCounter < getNodes().size()) {
			gride.add((Node) getNodes().get(tmpCounter).getComp().display(),
					getNodes().get(tmpCounter).getIndexOfComponentCol(),
					getNodes().get(tmpCounter).getIndexOfComponentRow());
			tmpCounter++;
		}
		return gride;
	}

}
