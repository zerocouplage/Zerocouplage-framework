package org.zerocouplage.rolemanager.security;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.rolemanager.impl.controller.ZCRule;
import org.zerocouplage.rolemanager.impl.controller.ZCRuleManager;

import com.zerocouplage.api.config.ISecurityConfig;


public class ProxyMapComponent extends ZCAbstractComponent {

	private boolean response = true;
	private boolean prohibition = false;
	private RealMapComponent componentMap;
    private ZCRule rule ;
    private ZCRuleManager manager;
    private Object a;
 
	private Map<String, ZCComponent> in = new HashMap<String, ZCComponent>();
    
	public ProxyMapComponent(ZCComponent... args) {
        rule = new ZCRule();
		for (ZCComponent i : args) {
			in.put(i.getIdComponent(), i);

			 rule.setObject(i.getIdComponent());
			 manager =new ZCRuleManager(); 
			try {
				response=manager.isProhibited(rule.getSubject(),"show",rule.getObject());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}

	public Object display() throws Exception {
	
		 a= "";
		if (!response) {
			componentMap = new RealMapComponent(in);
			return componentMap.display();
		} else {
			
			return "";
		}

	}

}
