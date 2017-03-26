package org.zerocouplage.tutorial.views;

import java.io.IOException;
import java.util.HashMap;

import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.component.api.component.ZCLabel;
import org.zerocouplage.component.api.component.ZCPassword;
import org.zerocouplage.component.api.component.ZCTextField;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.api.layout.ZCGridLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.common.ZCComponentFactory;
import org.zerocouplage.component.impl.style.ZCStyle;

import org.zerocouplage.common.exceptions.ZCExceptionConfig;

public class Inscription implements ZCView {

	private ZCTextField login;
	private ZCPassword password;
	private ZCTextField dateNaissance;
	private ZCTextField email;
	private ZCButton valider;
	private ZCButton reset;

	public String getLogin() {
		return login.getText();
	}

	public String getPassword() {
		return password.getText();
	}

	public String getBirth() {
		return dateNaissance.getText();
	}

	public String getMail() {
		return email.getText();
	}

	public Inscription() throws IOException, ZCCompNotFoundException,
			ZCExceptionConfig {

		login = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);

		password = (ZCPassword) ZCComponentFactory
				.newComponent(ZCPassword.class);

		dateNaissance = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);

		email = (ZCTextField) ZCComponentFactory
				.newComponent(ZCTextField.class);

		valider = (ZCButton) ZCComponentFactory.newComponent(ZCButton.class);

		reset = (ZCButton) ZCComponentFactory.newComponent(ZCButton.class);

	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("inscription");
		ZCGridLayout layout = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		layout.setCols(1);
		layout.setRows(4);
		layout.setForm(true);
		layout.setName("sign in");

		ZCStyle styleOfLayout = new ZCStyle();

		styleOfLayout.setColor("#0000ff");

		ZCStyle styleOfComponent = new ZCStyle();

		styleOfComponent.setColor("black");
		styleOfComponent.setHeight(30);
		styleOfComponent.setWidth(200);

		ZCLabel labelOfLogin = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);

		ZCLabel labelOfPassword = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);

		ZCLabel labelOfBirth = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);

		ZCLabel labelOfEmail = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);

		labelOfLogin.setLabel("Entrer Login :");
		labelOfPassword.setLabel("Entrer Mot de passe ;");

		labelOfBirth.setLabel("Date of Birth :");
		labelOfEmail.setLabel("email :");

		login.setName("login");
		password.setName("password");
		dateNaissance.setName("birth");
		email.setName("mail");
		valider.setText("Valider");
		reset.setText("Reset");

		labelOfBirth.setStyle(styleOfComponent);

		labelOfLogin.setStyle(styleOfComponent);
		labelOfEmail.setStyle(styleOfComponent);
		labelOfPassword.setStyle(styleOfComponent);

		login.setStyle(styleOfComponent);
		password.setStyle(styleOfComponent);

		dateNaissance.setStyle(styleOfComponent);
		email.setStyle(styleOfComponent);
		reset.setStyle(styleOfComponent);
		reset.setAction("goInscription", this);
		valider.setStyle(styleOfComponent);
		valider.setAction("goTraitementInscription", this);

		layout.addComponent(labelOfLogin);
		layout.addComponent(login);
		layout.addComponent(labelOfPassword);
		layout.addComponent(password);

		layout.addComponent(labelOfEmail);
		layout.addComponent(email);
		layout.addComponent(labelOfBirth);
		layout.addComponent(dateNaissance);
		layout.addComponent(reset);
		layout.addComponent(valider);

		layout.setStyle(styleOfLayout);

		page.setTitle("Inscription ");
		page.setBody(layout);

		return page;

	}

	public void processError(HashMap<String, String> listError) {

		if (listError.get("error_login") != null) {
			login.setErrorMessage(listError.get("error_login"));
		}
		if (listError.get("error_mail") != null) {
			email.setErrorMessage(listError.get("error_mail"));
		}
		if (listError.get("error_birth") != null) {
			dateNaissance.setErrorMessage(listError.get("error_birth"));
		}

	}

}
