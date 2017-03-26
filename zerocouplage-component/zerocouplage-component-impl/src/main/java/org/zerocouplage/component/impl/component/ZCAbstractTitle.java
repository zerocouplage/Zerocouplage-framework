package org.zerocouplage.component.impl.component;

import org.zerocouplage.component.api.component.ZCTitle;

/**
 * <p>
 * ZCAbstractTitle is an implementation of the ZCTitle
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */

public abstract class ZCAbstractTitle extends ZCAbstractComponent implements
		ZCTitle {
	
	private String text;
	private String hi;


	public void setText(String s){
		text=s;
	}


	public String getText(){
		return text;
	}
	public String getHi(){
		return hi;
	}

	
	public void setHi(String hi){
		
		this.hi=hi;
	}
	
}
