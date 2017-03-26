package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractLabel;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCLabelWeb is the ZCLabel component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public class ZCLabelWeb extends ZCAbstractLabel {

	@Override
	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		if (getLabel() == null) {
			mapOfDataComponent.put("label", "");
		} else {
			mapOfDataComponent.put("label", getLabel());
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

}
