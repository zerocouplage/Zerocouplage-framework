package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractImage;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCImageWeb is the ZCImage component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCImageWeb extends ZCAbstractImage {

	@Override
	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		if (getSource() == null) {
			mapOfDataComponent.put("source", "");
		} else {
			String source = getSource().replaceAll("\\/",	 "\\\\");
			System.out.println(source);
			mapOfDataComponent.put("source", source);
		}
		if (getAlt() == null) {
			mapOfDataComponent.put("alt", "");
		} else {
			mapOfDataComponent.put("alt", getAlt());
		}
		if (getStyle().getColor() == null) {
			mapOfDataComponent.put("color", "");
		} else {
			mapOfDataComponent.put("color", getStyle().getColor());
		}
		if (getStyle().getHeight() == 0) {
			mapOfDataComponent.put("height", "");
		} else {
			mapOfDataComponent.put("height", getStyle().getHeight());
		}

		if (getStyle().getWidth() == 0) {
			mapOfDataComponent.put("width", "");
		} else {
			mapOfDataComponent.put("width", getStyle().getWidth());
		}

		return zcve.ZCEngine(this, mapOfDataComponent);

	}

	public Class getImageClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setImageClass(Class imageClass) {
		// TODO Auto-generated method stub
		
	}

}
