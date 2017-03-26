package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCImage;

/**
 * <p>
 * ZCAbstractImage is an implementation of the ZCImage
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractImage extends ZCAbstractComponent implements
		ZCImage {

	String source;
	String alt;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAlt() {
		return alt;
	}

	/**
	 * 
	 * @param alt
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}

}
