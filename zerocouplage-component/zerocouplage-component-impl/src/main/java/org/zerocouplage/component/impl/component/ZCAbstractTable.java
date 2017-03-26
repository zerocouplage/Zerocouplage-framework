package org.zerocouplage.component.impl.component;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCTable;

/**
 * <p>
 * ZCAbstractTable is an implementation of the ZCTable
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractTable extends ZCAbstractComponent implements
		ZCTable {

	private ArrayList<String> headData;
	private Array[][] coreData;

	public void setHead(ArrayList<String> headData) {
		this.headData = headData;
	}

	public ArrayList<String> getHead() {
		return headData;

	}

	public void setCore(Array[][] coreData) {

		this.coreData = coreData;

	}

	public Array[][] getCore() {
		return coreData;

	}

}
