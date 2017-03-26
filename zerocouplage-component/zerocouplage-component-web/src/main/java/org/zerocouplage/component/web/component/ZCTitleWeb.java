package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractButton;
import org.zerocouplage.component.impl.component.ZCAbstractTitle;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

import org.zerocouplage.api.controller.IZCManager;

/**
 * <p>
 * ZCTitleWeb is the ZCTitle component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTitleWeb extends ZCAbstractTitle {

	@Override
	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		if (getText() == null) {
			mapOfDataComponent.put("text", "");
		} else {
			mapOfDataComponent.put("text", getText());
		}

		if (getStyle().getColor() == null) {
			mapOfDataComponent.put("color", "");
		} else {
			mapOfDataComponent.put("color", getStyle().getColor());
		}

		if (getHi() == null) {
			mapOfDataComponent.put("h", "3");
		} else if (getHi().equals(H1)) {
			mapOfDataComponent.put("h", "1");
		} else if (getHi().equals(H2)) {
			mapOfDataComponent.put("h", "2");
		} else if (getHi().equals(H3)) {
			mapOfDataComponent.put("h", "3");
		} else if (getHi().equals(H4)) {
			mapOfDataComponent.put("h", "4");
		} else if (getHi().equals(H5)) {
			mapOfDataComponent.put("h", "5");
		} else if (getHi().equals(H6)) {
			mapOfDataComponent.put("h", "6");
		}

		return zcve.ZCEngine(this, mapOfDataComponent);

	}

}
