package org.zerocouplage.component.web.layout;

import java.util.Date;
import java.util.HashMap;

import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;
import org.zerocouplage.component.impl.layout.ZCAbstractGridLayout;

/**
 * <p>
 * ZCGridLayoutWeb is the ZCGridLayout component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCGridLayoutWeb extends ZCAbstractGridLayout {

	public String display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();

		mapOfDataComponent.put("component", getComponent());

		mapOfDataComponent.put("gridObject", this);

		mapOfDataComponent.put("ParentName", getParentName());

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
		if(getName() == null)
		{
			mapOfDataComponent.put("nameForm", new Date().getTime());
		}else
		{
			mapOfDataComponent.put("nameForm", getName());
		}
		mapOfDataComponent.put("isForm", isForm());
		return zcve.ZCEngine(this, mapOfDataComponent);

	}

}
