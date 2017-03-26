package org.zerocouplage.tutorial.views;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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

public class DownloadPageAcueil implements ZCView {

	private ZCTextField rep1;
	private ZCTextField rep2;
	private File fileToUpload;

	public String getLogin() {
		return rep1.getText();
	}

	public String getPassword() {
		return rep2.getText();
	}

	public DownloadPageAcueil() {

		try {
			rep2 = (ZCTextField) ZCComponentFactory
					.newComponent(ZCTextField.class);
			rep1 = (ZCTextField) ZCComponentFactory
					.newComponent(ZCTextField.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZCCompNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ZCExceptionConfig e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("DownloadPageAcueil");
		ZCGridLayout download = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		download.setCols(1);
		download.setRows(2);
		download.setForm(true);
		download.setName("connect");

		ZCStyle styleOfLayout = new ZCStyle();

		styleOfLayout.setColor("#0b8db3");

		ZCStyle styleOfComponent = new ZCStyle();

		styleOfComponent.setColor("black");
		styleOfComponent.setHeight(30);
		styleOfComponent.setWidth(200);

		ZCLabel labelOfLogin = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfLogin.setLabel("Repértoire1: ");
		labelOfLogin.setStyle(styleOfComponent);

		ZCLabel labelOfPassword = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfPassword.setLabel("Répértoire2: ");
		labelOfPassword.setStyle(styleOfComponent);

		rep1.setName("login");
		rep1.setStyle(styleOfComponent);

		ZCButton registerButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		registerButton.setStyle(styleOfComponent);

		ZCButton submitButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);

		registerButton.setText("DownloadFile");
		registerButton.setStyle(styleOfComponent);
		registerButton.setAction("downlaodFile", this);

		submitButton.setText("UploadFile");
		submitButton.setStyle(styleOfComponent);
		submitButton.setAction("traitement", this);

		rep2.setName("password");
		rep2.setStyle(styleOfComponent);

		download.addComponent(labelOfLogin);
		download.addComponent(rep1);
		download.addComponent(labelOfPassword);
		download.addComponent(rep2);
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
				rep1.setErrorMessage(listError.get("error_login"));
			}

			System.out.println(fieldName + " " + listError.get(fieldName));

		}

	}

	public File getFileToUpload() {

		fileToUpload = new File(rep1.getText());

		return fileToUpload;
	}

	public void setFileToUpload(File fileToUpload) {
		this.fileToUpload = fileToUpload;
	}

}
