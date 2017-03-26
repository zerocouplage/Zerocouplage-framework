package org.zerocouplage.validator.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * the FormsValidatorConfig Class contains methods that allow to recover the globql  message 
 * and manipulate the listConstraint
 * @author bobmed
 *
 */
public class FormsValidatorConfig {
 
	private String golbalMessage;
	private Map<String, FieldConstraint> listConstraint;

	public FormsValidatorConfig() {
		super();
		this.listConstraint = new HashMap<String, FieldConstraint>();
	}

	/**
	 * Gets the global message
	 * @return the global message to display in case of error validation
	 */
	public String getGolbalMessage() {
		return golbalMessage;
	}

	/**
	 *  Sets the global message
	 * @param golbalMessage the global message to display in case of error validation
	 */
	public void setGolbalMessage(String golbalMessage) {
		this.golbalMessage = golbalMessage;
	}

	/**
	 * Gets a list of fieldConstraint
	 * @return list of fieldConstraint
	 */
	public Map<String, FieldConstraint> getListConstraint() {
		return listConstraint;
	}

	/** Sets a list of fieldConstraint
	 * @param listConstraint a list of fieldConstraint
	 */
	public void setListConstraint(Map<String, FieldConstraint> listConstraint) {
		this.listConstraint = listConstraint;
	}

	/**
	 * add fieldConstraint to the list
	 * @param fieldConstraint an instance of FieldConstraint
	 */
	public void addFieldConstraint(FieldConstraint fieldConstraint) {
		this.listConstraint
				.put(fieldConstraint.getFieldName(), fieldConstraint);
	}

}
