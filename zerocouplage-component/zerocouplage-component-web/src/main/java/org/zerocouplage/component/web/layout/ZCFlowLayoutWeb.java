package org.zerocouplage.component.web.layout;

import java.util.HashMap;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;
import org.zerocouplage.component.impl.layout.ZCAbstractFlowLayout;

/**
 * <p>
 * ZCFlowLayoutWeb is the ZCFlowLayout component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCFlowLayoutWeb extends ZCAbstractFlowLayout {

	public String display() throws Exception {
		
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();

		mapOfDataComponent.put("component", getComponent());
		mapOfDataComponent.put("flowObject", this);
		mapOfDataComponent.put("nameForm", getName());
		mapOfDataComponent.put("isForm", isForm());
		mapOfDataComponent.put("ParentName", getParentName());
		
		if(getStyle().getColor()==null){
			mapOfDataComponent.put("color", "");
		}
		else{
			mapOfDataComponent.put("color", getStyle().getColor());
		}
		if(getStyle().getHeight()== 0){
			mapOfDataComponent.put("height", "");
		}
		else{
			mapOfDataComponent.put("height", getStyle().getHeight());
		}
		
		if(getStyle().getWidth()== 0){
			mapOfDataComponent.put("width", "");
		}
		else{
			mapOfDataComponent.put("width", getStyle().getWidth());
		}


		return zcve.ZCEngine(this, mapOfDataComponent);

	}


}
