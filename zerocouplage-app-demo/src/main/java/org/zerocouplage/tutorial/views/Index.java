package org.zerocouplage.tutorial.views;

import java.io.IOException;
import java.util.HashMap;

import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.layout.ZCGridLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.common.ZCComponentFactory;
import org.zerocouplage.component.impl.style.ZCStyle;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;

public class Index implements ZCView {

	public Index() {

	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("DownloadPageAcueil");
		ZCGridLayout download = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		download.setCols(1);
		download.setRows(0);
		download.setForm(true);
		download.setName("connect");

		ZCStyle styleOfLayout = new ZCStyle();

		styleOfLayout.setColor("#0b8db3");

		ZCStyle styleOfComponent = new ZCStyle();

		styleOfComponent.setColor("black");
		styleOfComponent.setHeight(30);
		styleOfComponent.setWidth(200);

		ZCButton registerButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		registerButton.setStyle(styleOfComponent);

		ZCButton submitButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);

		registerButton.setText("Vers Authentification");
		registerButton.setStyle(styleOfComponent);
		registerButton.setAction("do", this);

		submitButton.setText("Vers Upload/Download");
		submitButton.setStyle(styleOfComponent);
		submitButton.setAction("download", this);

		download.addComponent(registerButton);
		download.addComponent(submitButton);

		download.setStyle(styleOfLayout);

		page.setTitle("Page de Download");
		page.setBody(download);

		return page;

	}

	public void processError(HashMap<String, String> listError) {

		for (String fieldName : listError.keySet()) {
			if (listError.get("error_login") != null) {

			}

			System.out.println(fieldName + " " + listError.get(fieldName));

		}

	}

}
