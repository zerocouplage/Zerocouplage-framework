package org.zerocouplage.tutorial.views;

import java.io.IOException;

import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.component.api.component.ZCLabel;
import org.zerocouplage.component.api.component.ZCTextField;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.layout.ZCGridLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.common.ZCComponentFactory;
import org.zerocouplage.component.impl.style.ZCStyle;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;

public class accueil implements ZCView {

	
	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("TodoMVC");
		
		//principal grid layout
		
		ZCGridLayout accueil = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		accueil.setCols(1);
		accueil.setRows(3);
		accueil.setForm(true);
		
		
		//input gride layout
		
		ZCGridLayout input = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		input.setCols(2);
		input.setRows(1);
		input.setForm(true);
		// element input 
		ZCTextField todoText = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);

		ZCButton submit = (ZCButton) ZCComponentFactory
		.newComponent(ZCButton.class);
		
		// add elements to input
		
		input.addComponent(todoText);
		input.addComponent(submit);
		
		//
		
		
		//add footer elements
		
		ZCButton all = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		ZCButton completed = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		ZCButton active = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		//footer grid
		
		ZCGridLayout footer = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		input.setCols(3);
		input.setRows(1);
		input.setForm(true);
		
		// insert elements footer
		
		footer.addComponent(all);
		footer.addComponent(active);
		footer.addComponent(completed);
		
		
		//add elements to accueil
		
		accueil.addComponent(input);
		
	

		page.setTitle("Bienvenue");
		page.setBody(accueil);

		return page;

	}
	
}






//package org.zerocouplage.tutorial.views;
//
//import java.io.IOException;
//
//import org.zerocouplage.component.api.component.ZCButton;
//import org.zerocouplage.component.api.component.ZCLabel;
//import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
//import org.zerocouplage.component.api.layout.ZCGridLayout;
//import org.zerocouplage.component.api.page.ZCPage;
//import org.zerocouplage.component.api.view.ZCView;
//import org.zerocouplage.component.common.ZCComponentFactory;
//import org.zerocouplage.component.impl.style.ZCStyle;
//import org.zerocouplage.tutorial.beans.UserBeanOut;
//
//import org.zerocouplage.common.exceptions.ZCExceptionConfig;
//
//public class accueil implements ZCView {
//
//	private UserBeanOut userOut;
//
//	public UserBeanOut getUserOut() {
//		return userOut;
//	}
//
//	public void setUserOut(UserBeanOut userOut) {
//		this.userOut = userOut;
//	}
//
//	public ZCPage executerResultat(UserBeanOut user) throws IOException,
//			ZCExceptionConfig, ZCCompNotFoundException, Exception {
//		userOut = user;
//		return display();
//	}
//
//	@Override
//	public ZCPage display() throws IOException, ZCExceptionConfig,
//			ZCCompNotFoundException, Exception {
//		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
//		page.setName("Accueil");
//
//		ZCGridLayout accueil = (ZCGridLayout) ZCComponentFactory
//				.newComponent(ZCGridLayout.class);
//		accueil.setCols(1);
//		accueil.setRows(1);
//		accueil.setForm(true);
//		accueil.setName("welcome");
//
//		ZCStyle styleOfLayout = new ZCStyle();
//
//		styleOfLayout.setColor("#ffOO00");
//
//		ZCStyle styleOfComponent = new ZCStyle();
//
//		styleOfComponent.setColor("black");
//		styleOfComponent.setHeight(30);
//		styleOfComponent.setWidth(270);
//
//		ZCLabel labelOfwelcome = (ZCLabel) ZCComponentFactory
//				.newComponent(ZCLabel.class);
//
//		ZCLabel labelvide = (ZCLabel) ZCComponentFactory
//				.newComponent(ZCLabel.class);
//		labelvide.setStyle(styleOfComponent);
//
//		ZCLabel labelvide2 = (ZCLabel) ZCComponentFactory
//				.newComponent(ZCLabel.class);
//		labelvide.setStyle(styleOfComponent);
//
//		ZCButton retour = (ZCButton) ZCComponentFactory
//				.newComponent(ZCButton.class);
//
//		retour.setText("se deconnecter");
//		retour.setStyle(styleOfComponent);
//		retour.setAction("index", this);
//
//		accueil.addComponent(labelOfwelcome);
//		accueil.addComponent(labelvide);
//		accueil.addComponent(labelvide2);
//		accueil.addComponent(retour);
//
//		accueil.setStyle(styleOfLayout);
//
//		page.setTitle("Bienvenue");
//		page.setBody(accueil);
//
//		return page;
//
//	}
//
//}
//
