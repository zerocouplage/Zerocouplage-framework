package org.zerocouplage.validator.forms;

/**
 * the FieldConstraint Class contains getters and setters of field name ,constraint and error message
 * @author bobmed
 * 
 */

public class FieldConstraint {
	
	private String   fieldName;
	private String constraint;
	private String messageError;
	
	
	/**
	 * Gets the constraint that field name must respect
	 * @return the constraint
	 */
	public String getConstraint() {
		return constraint;
	}
	/**
	 * Sets the constraint that field name must respect
	 * @param constraint the constraint to use
	 */
	
	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	/**
	 * Gets the error message that will be displayed if the field name is invalid 
	 * @return   the error message to display
	 */
	public String getMessageError() {
		return messageError;
	}
	/**
	 * Sets the error message that will be displayed if the field name is invalid  
	 * @param messageError the error  message to display
	 */
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	/**
	 * Gets the fieldName that will be verified by the validator
	 * @return the field name to verify
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * Sets the fieldName that will be verified by the validator
	 * @param fieldName the field name to verify
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
}
