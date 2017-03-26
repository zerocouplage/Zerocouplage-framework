package org.zerocouplage.component.api.exception;

/**
 * 
 * @author Nadia ELRHOUL
 * 
 */

public class ZCCompNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * The argument is a message error , that appear when we have a exception
	 * </p>
	 * 
	 * @param message
	 */
	public ZCCompNotFoundException(String message) {
		super(message);
	}
}
