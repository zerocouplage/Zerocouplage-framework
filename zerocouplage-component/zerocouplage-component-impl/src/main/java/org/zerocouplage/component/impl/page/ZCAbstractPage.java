package org.zerocouplage.component.impl.page;

import org.zerocouplage.component.api.layout.ZCLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;

/**
 * <p> ZCAbstractPage is an implementation of the ZCPage </p>
 * @author Yassine ABDELJALIL
 * @author ZCTeam 2014
 * 
 */
public abstract class ZCAbstractPage extends ZCAbstractComponent implements
		ZCPage {

	private String title;
	protected ZCLayout body;
	private String name;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ZCLayout getBody() {
		return body;
	}

	public void setBody(ZCLayout body) {
		body.setParentName(this.getName());
		body.setParent(this);
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
