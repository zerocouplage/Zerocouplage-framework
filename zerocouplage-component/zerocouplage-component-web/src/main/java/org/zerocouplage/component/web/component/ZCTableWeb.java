package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractTable;
import org.zerocouplage.component.impl.component.ZCAbstractTextField;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCTableWeb is the ZCTable component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCTableWeb extends ZCAbstractTable {

	@Override
	public Object display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		mapOfDataComponent.put("headdata", getHead());
		mapOfDataComponent.put("coredata", getCore());
		mapOfDataComponent.put("style", getStyle());

		return zcve.ZCEngine(this, mapOfDataComponent);
	}

}
