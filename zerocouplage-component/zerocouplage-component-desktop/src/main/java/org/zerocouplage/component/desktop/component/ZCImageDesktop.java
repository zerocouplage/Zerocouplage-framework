package org.zerocouplage.component.desktop.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.zerocouplage.component.impl.component.ZCAbstractImage;

/**
 * <p>
 * ZCImageDesktop is the ZCImage component in Desktop
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCImageDesktop extends ZCAbstractImage {

	private ImageView imageView = new ImageView();
	private Class imageClass;

	public Object display() {

		Image image;
		if (getSource().contains(":")) {
			image = new Image("file:///" + getSource());
		} else {
			image = new Image(getImageClass().getResource(getSource())
					.toExternalForm());
		}

		imageView.setStyle("-fx-background-color:" + getStyle().getColor()
				+ ";");
		imageView.setImage(image);
		imageView.setFitHeight(getStyle().getHeight());
		imageView.setFitWidth(getStyle().getWidth());
		return imageView;
	}

	public Class getImageClass() {
		return imageClass;
	}

	public void setImageClass(Class imageClass) {
		this.imageClass = imageClass;
	}

}
