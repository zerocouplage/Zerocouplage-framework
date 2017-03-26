package org.zerocouplage.component.desktop.component;

import java.awt.geom.CubicCurve2D;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import org.zerocouplage.component.impl.component.ZCAbstractHr;

/**
 * <p>
 * ZCHrDesktop is the ZCHr component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCHrDesktop extends ZCAbstractHr {

	private Label hr = new Label() ;

	@Override
	public Object display() {

		hr.setStyle("-fx-background-color:" + getStyle().getColor() + ";-fx-heigth:100");
		hr.setPrefWidth(100);
		return hr;
	}

}
