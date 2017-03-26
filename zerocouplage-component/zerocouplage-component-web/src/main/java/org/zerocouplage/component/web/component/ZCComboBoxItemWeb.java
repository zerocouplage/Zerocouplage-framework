package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.impl.component.ZCAbstractComboBoxItem;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCComboBoxItemWeb is the ZCComboBoxItem component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCComboBoxItemWeb extends ZCAbstractComboBoxItem {

	public Object display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		 HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		
		 if (getValue() == null) {
				mapOfDataComponent.put("value", "");
			} else {
				mapOfDataComponent.put("value", getValue());
			}		
		 
		 
		return zcve.ZCEngine(this, mapOfDataComponent);

}
}

