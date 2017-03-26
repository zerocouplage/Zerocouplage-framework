package org.zerocouplage.component.api.view;

import java.io.IOException;

import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.page.ZCPage;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;
/**
 * <p>Interface ZCView most be implemented for displaying ZCComponent </p>
 * @author Taoufik RIFAI
 * 
 */

public interface ZCView {
	/**
	 * <p> Method that returns the ZeroCouplage page containing all the created ZCcomponent</p>
	 * @return object , can be a (String,Component,..)
	 * @throws ZCCompNotFoundException 
	 * @throws ZCExceptionConfig 
	 * @throws IOException 
	 * @throws Exception 
	 */
	public ZCPage display() throws IOException, ZCExceptionConfig, ZCCompNotFoundException, Exception;
}
