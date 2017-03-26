package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractButton;
import org.zerocouplage.component.impl.component.ZCAbstractHr;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

import org.zerocouplage.api.controller.IZCManager;

/**
 * <p>
 * ZCHrWeb is the ZCHr component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public class ZCHrWeb extends ZCAbstractHr {

	@Override
	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		

		if (getStyle().getColor() == null) {
			mapOfDataComponent.put("color", "");
		} else {
			mapOfDataComponent.put("color", getStyle().getColor());
		}
	

		return zcve.ZCEngine(this, mapOfDataComponent);

	}

}
