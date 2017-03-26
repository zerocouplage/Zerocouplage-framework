package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCFile;

/**
 * <p>
 * ZCAbstractFile is an implementation of the ZCFile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractFile extends ZCAbstractComponent implements
		ZCFile {

	private String name;
	private String filter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFilter(){
		return filter;
	}
	
	public void setFilter(String Filter){
		filter=Filter;
	}

}
