package org.zerocouplage.component.impl.style;

import org.zerocouplage.component.api.style.IZCStyle;


/**
 * <p>
 * ZCStyle is an implementation of the IZCStyle 
 * </p>
 * 
 * @author Yassine ABDELJALIL
 * 
 */

public class ZCStyle implements IZCStyle {

	private int width = 0;
	private int height = 0;
	private String color = null;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
