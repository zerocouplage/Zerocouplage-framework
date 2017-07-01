package org.zerocouplage.component.mobile.page;


import org.zerocouplage.component.impl.page.ZCAbstractPage;
/**
 * <p>
 * ZCPageMobile is the ZCPage component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCPageMobile extends ZCAbstractPage {
	

	public Object display() throws Exception {
		
		ZCActivityMobile context = ZCSharedMobilePage.getINSTANCE().getMainActivityForCurrentApp();
		
		context.setTitle(this.getTitle());
		
		return this.getBody().display();
	}

}
