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

public class authentification implements ZCView {

	private ZCTextField login;
	private ZCPassword password;

	public String getLogin() {
		return login.getText();
	}


	public String getPassword() {
		return password.getText();
	}


	public  authentification() {
	
		try {
			password = (ZCPassword) ZCComponentFactory.newComponent(ZCPassword.class);
			login = (ZCTextField) ZCComponentFactory.newComponent(ZCTextField.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ZCCompNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (ZCExceptionConfig e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException, Exception {
		ZCPage page = (ZCPage) ZCComponentFactory.newComponent(ZCPage.class);
		page.setName("authentification");
		ZCGridLayout authentification = (ZCGridLayout) ZCComponentFactory
				.newComponent(ZCGridLayout.class);
		authentification.setCols(1);
		authentification.setRows(2);
		authentification.setForm(true);
		authentification.setName("connect");

		ZCStyle styleOfLayout = new ZCStyle();

		styleOfLayout.setColor("#0b8db3");

		ZCStyle styleOfComponent = new ZCStyle();

		styleOfComponent.setColor("black");
		styleOfComponent.setHeight(30);
		styleOfComponent.setWidth(200);

		ZCLabel labelOfLogin = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfLogin.setLabel("Nom : ");
		labelOfLogin.setStyle(styleOfComponent);

		ZCLabel labelOfPassword = (ZCLabel) ZCComponentFactory
				.newComponent(ZCLabel.class);
		labelOfPassword.setLabel("Password: ");
		labelOfPassword.setStyle(styleOfComponent);
		
		
		login.setName("login");
		login.setStyle(styleOfComponent);

		ZCButton registerButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		registerButton.setStyle(styleOfComponent);
		
		ZCButton submitButton = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		ZCButton Upload = (ZCButton) ZCComponentFactory
				.newComponent(ZCButton.class);
		
		registerButton.setText("s'inscrire");
		registerButton.setStyle(styleOfComponent);
		registerButton.setAction("goInscription", this);
		
		Upload.setText("upload");
		Upload.setStyle(styleOfComponent);
		

		submitButton.setText("s'authentifier");
		submitButton.setStyle(styleOfComponent);
		submitButton.setAction("download", this);
		
		
		password.setName("password");
		password.setStyle(styleOfComponent);
		
		authentification.addComponent(labelOfLogin);
		authentification.addComponent(login);
		authentification.addComponent(labelOfPassword);
		authentification.addComponent(password);
		authentification.addComponent(registerButton);
		authentification.addComponent(submitButton);
		authentification.addComponent(Upload);
		
		authentification.setStyle(styleOfLayout);
		
		page.setTitle("Page d'authentification");
		page.setBody(authentification);

		return page;

	}
	
public void processError(HashMap<String, String> listError) {
		
		for (String fieldName : listError.keySet()) {
			if(listError.get("error_login")!=null){
				login.setErrorMessage(listError.get("error_login"));
			}
			
			System.out.println(fieldName+" "+listError.get(fieldName));
			
		}
		
	}

}
