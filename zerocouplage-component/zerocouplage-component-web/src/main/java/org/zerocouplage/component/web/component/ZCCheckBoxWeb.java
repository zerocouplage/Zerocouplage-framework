package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractCheckBox;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCCheckBoxWeb is the ZCCheckBox component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCCheckBoxWeb extends ZCAbstractCheckBox {

	@Override
	public Object display() throws Exception {

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
		if (getText() == null) {
			mapOfDataComponent.put("text", "");
		} else {
			mapOfDataComponent.put("text", getText());
		}
		
		if (isChecked()== true) {
			mapOfDataComponent.put("checked", isChecked());
		} else {
			mapOfDataComponent.put("checked", "false");
		}

		return zcve.ZCEngine(this, mapOfDataComponent);

	}

}
