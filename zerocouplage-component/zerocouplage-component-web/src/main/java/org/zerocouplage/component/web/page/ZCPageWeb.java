package org.zerocouplage.component.web.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.component.impl.enginevm.ZCEngineVelocity;
import org.zerocouplage.component.impl.page.ZCAbstractPage;
/**
 * <p>
 * ZCButtonWeb is the ZCButton component in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPageWeb extends ZCAbstractPage {


	  public Object display() throws Exception {
		  

			Map<String, Object> m = new HashMap<String, Object>();
			m.put("body", body.display());
			ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(m);
		

			 ZCEngineVelocity zcve = new ZCEngineVelocity();
			 HashMap<String, Object> mapOfDataComponent = new HashMap<String, Object>();
			
			 mapOfDataComponent.put("title", getTitle());
			 mapOfDataComponent.put("layout", list);
			return zcve.ZCEngine(this, mapOfDataComponent);
			 
			 
			 
			 
			 
			 
			
	}

	public void setCurrentInstance(Object view) {
		// TODO Auto-generated method stub
		
	}

}