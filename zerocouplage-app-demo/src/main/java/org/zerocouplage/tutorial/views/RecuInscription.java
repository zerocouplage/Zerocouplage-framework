package org.zerocouplage.tutorial.views;

import java.io.IOException;

import org.zerocouplage.component.api.component.ZCLabel;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.layout.ZCBorderLayout;
import org.zerocouplage.component.api.layout.ZCGridLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.common.ZCComponentFactory;
import org.zerocouplage.component.impl.style.ZCStyle;
import org.zerocouplage.tutorial.beans.UserBeanOut;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;

public class RecuInscription implements ZCView {

	private UserBeanOut userOut;

	public static String  message = null;
	public ZCPage executerResultat(UserBeanOut user) throws IOException,
			ZCExceptionConfig, ZCCompNotFoundException, Exception {
		userOut = user;
		return display();
	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("recuInscription");
		
		ZCBorderLayout Blayout = (ZCBorderLayout) ZCComponentFactory
				.newComponent(ZCBorderLayout.class);
		
		ZCGridLayout layout = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		layout.setCols(0);
		layout.setRows(3);
		layout.setForm(true);
		layout.setName("detail");

		ZCStyle styleOfLayout = new ZCStyle();

		styleOfLayout.setColor("#0b8db3");

		ZCStyle styleOfComponent = new ZCStyle();

		styleOfComponent.setColor("black");
		styleOfComponent.setHeight(50);
		styleOfComponent.setWidth(700);
		
		
		ZCLabel label1 = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		
		ZCLabel label2 = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		
		ZCLabel label3 = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		
		ZCLabel label4 = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);

		
		message = userOut.getLogin();
	
		
		label1.setLabel("Felicitation cher(e) "+userOut.getLogin()+", vous êtes insc"
				+ "ris avec succes sur notre plateforme realisé par le framwork zerocouplage v2.0.0");
		label2.setLabel("et voici les details de votre inscription :");		
		label3.setLabel("- votre mot de passe : "+userOut.getPassword());
		label4.setLabel("- votre email : "+userOut.getEmail());
		
		
		

		label1.setStyle(styleOfComponent);
		label2.setStyle(styleOfComponent);
		label3.setStyle(styleOfComponent);
		label4.setStyle(styleOfComponent);
		
		
		
		layout.addComponent(label1);
		layout.addComponent(label2);
		
		layout.addComponent(label3);
		layout.addComponent(label4);
		
		
		layout.setStyle(styleOfLayout);
		
		page.setTitle("Recu Inscription ");
		page.setBody(layout);

		return page;

	}
}
