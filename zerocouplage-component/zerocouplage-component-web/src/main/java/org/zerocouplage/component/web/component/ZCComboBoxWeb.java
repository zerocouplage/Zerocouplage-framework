package org.zerocouplage.component.web.component;

import java.util.HashMap;

import org.zerocouplage.component.api.component.ZCComboBoxItem;
import org.zerocouplage.component.impl.component.ZCAbstractComboBox;
import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;

/**
 * <p>
 * ZCComboBoxWeb is the ZCComboBox component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCComboBoxWeb extends ZCAbstractComboBox {

	public Object display() throws Exception {
		ZCEngineVelocity zcve = new ZCEngineVelocity();
		 HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
		
		 mapOfDataComponent.put("items", getItems());
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
			
			if(getName()== null){
				mapOfDataComponent.put("name", "");
			}
			else{
				mapOfDataComponent.put("name", getName());
			}
		
		 
		 
		return zcve.ZCEngine(this, mapOfDataComponent);

}

	public String getSelectedName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSelectedName(ZCComboBoxItem item) {
		// TODO Auto-generated method stub
		
	}
}

