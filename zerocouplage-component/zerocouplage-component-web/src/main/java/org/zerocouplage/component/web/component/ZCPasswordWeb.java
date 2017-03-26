package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractPassword;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;
/**
 * <p>
 * ZCPasswordWeb is the ZCPassword component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPasswordWeb extends ZCAbstractPassword {

	@Override
	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		if (getName() == null) {
			mapOfDataComponent.put("name", "");
		} else {
			mapOfDataComponent.put("name", getName());
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
		
		if (getErrorMessage() == null) {
			mapOfDataComponent.put("error", "");
		} else {
			mapOfDataComponent.put("error", getErrorMessage());
		}

		return zcve.ZCEngine(this, mapOfDataComponent);
	}

}
