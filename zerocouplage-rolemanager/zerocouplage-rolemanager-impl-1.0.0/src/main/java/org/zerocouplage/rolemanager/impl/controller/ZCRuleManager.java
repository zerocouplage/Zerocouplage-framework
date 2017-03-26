package org.zerocouplage.rolemanager.impl.controller;



import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import orbac.AbstractOrbacPolicy;
import orbac.COrbacCore;
import orbac.exception.COrbacException;

import org.zerocouplage.rolemanager.api.controller.IZCRuleManager;

public class ZCRuleManager implements IZCRuleManager{
	private COrbacCore core ;
	
	private AbstractOrbacPolicy p ;

	private String pathToPolicy;
	  
	public ZCRuleManager() {
		
		
	}
	
	private void loadXmlConfi()
	{
      core= COrbacCore.GetTheInstance();
		
      URL urlpath = this.getClass().getClassLoader().getResource(pathToPolicy);
      String absolutpath= urlpath.getFile();
      String true_path= absolutpath.replaceFirst("%20", " ");
		try {
			p= core.LoadPolicy(true_path);
		} catch (COrbacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean hasAccess(String subject, String action, String objectOrbac) throws Exception {
		
		if(p == null)
		{
		  loadXmlConfi();
		}
		
		Set<String> object = p.GetObjectsForView(objectOrbac);
		String obj1 = null;
		@SuppressWarnings("rawtypes")
		Iterator it= object.iterator();
		if(it.hasNext()){
			obj1=it.next().toString();
		}
		System.out.println("ok hass access");	
		boolean r= p.IsPermited(subject, action, obj1);
		System.out.println(r+"has access");
		
		return r;
	}
	public boolean isProhibited(String subject, String action, String id_object) throws Exception{
		// TODO Auto-generated method stub
		
		if(p == null)
		{
		  loadXmlConfi();
		}
		
		Set<String> object = null;
		try {
			object = p.GetObjectsForView(id_object);
		} catch (COrbacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String obj1 = null;
		@SuppressWarnings("rawtypes")
		Iterator it= object.iterator();
		if(it.hasNext()){
			obj1=it.next().toString();
		}
		System.out.println("ok hass access");	
		boolean r= p.IsProhibited(subject, action, obj1);
		System.out.println(r+"is Prohabited");
		
		return r;
	}

	public String getPathToPolicy() {
		return pathToPolicy;
	}

	public void setPathToPolicy(String pathToPolicy) {
		this.pathToPolicy = pathToPolicy;
	}
	
	
}
