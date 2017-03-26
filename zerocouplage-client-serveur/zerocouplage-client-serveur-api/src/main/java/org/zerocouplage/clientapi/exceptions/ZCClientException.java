package org.zerocouplage.clientapi.exceptions;

import java.io.IOException;

public class ZCClientException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ZCClientException(String message, IOException except) {
		super(message, except);
	}
																
}
