package org.zerocouplage.component.api.page;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComponent;
import org.zerocouplage.component.api.layout.ZCLayout;

/**
 * <p> ZCPage a page of ZeroCouplage component, that contains all the ZCComponent</p>
 * @author Yassine ABDELJALIL
 * 
 */

public interface ZCPage extends ZCComponent {

	/**
	 * <p> Sets the page title</p>
	 * @param title
	 */
	public void setTitle(String title);

	/**
	 * <p> Sets the Body of the page</p>
	 * @param zclayout
	 */

	public void setBody(ZCLayout zclayout);

	/**
	 * <p>
	 * Returns the title of the page</p>
	 * 
	 * @return title
	 */
	public String getTitle();

	/**
	 * <p>
	 * Returns the body of the page
	 * </p>
	 * 
	 * @return body
	 * @throws Exception 
	 */
	public ZCLayout getBody();
	

	public String getName();

	
	public void setName(String name);
	

}
