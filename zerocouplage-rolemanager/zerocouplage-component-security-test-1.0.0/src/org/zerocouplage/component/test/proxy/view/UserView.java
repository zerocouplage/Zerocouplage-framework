package org.zerocouplage.component.test.proxy.view;

import static org.zerocouplage.component.common.ZCComponentFactory.newComponent;

import java.io.IOException;

import org.zerocouplage.component.api.component.ZCButton;
import org.zerocouplage.component.api.component.ZCCheckBox;
import org.zerocouplage.component.api.component.ZCLabel;
import org.zerocouplage.component.api.component.ZCRadioButton;
import org.zerocouplage.component.api.component.ZCTextField;
import org.zerocouplage.component.api.layout.ZCGridBagLayout;
import org.zerocouplage.component.api.page.ZCPage;
import org.zerocouplage.component.api.view.ZCView;
import org.zerocouplage.component.api.exception.ZCCompNotFoundException;
import org.zerocouplage.component.impl.component.ZCAbstractLabel;
import org.zerocouplage.rolemanager.security.ProxyMapComponent;

import com.zerocouplage.api.controller.IZCManager;
import com.zerocouplage.common.exceptions.ZCExceptionConfig;
import com.zerocouplage.impl.controller.ZCManagerFactory;

public class UserView implements ZCView {

	@SuppressWarnings("unused")
	private IZCManager manager;
	

	public UserView() {
		manager = ZCManagerFactory.getNewManager(this);
		

	}

	public static void main(String[] args) {
		UserView userView = new UserView();

		try {
			System.out.println(userView.display().display());
		} catch (IOException | ZCCompNotFoundException | ZCExceptionConfig e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ZCPage display() throws IOException, ZCExceptionConfig,
			ZCCompNotFoundException {
		ZCPage page = (ZCPage) newComponent(ZCPage.class);
		page.setTitle("Bienvenue sur le formulaire d'inscription ");


		ZCGridBagLayout layout = (ZCGridBagLayout) newComponent(ZCGridBagLayout.class);
		ZCGridBagLayout layout_Sexe = (ZCGridBagLayout) newComponent(ZCGridBagLayout.class);

		ZCLabel nom = (ZCAbstractLabel) newComponent(ZCLabel.class);
		nom.setLabel("Nom : ");

		ZCLabel prenom = (ZCAbstractLabel) newComponent(ZCLabel.class);
		prenom.setLabel("Prénom : ");

		ZCLabel Age = (ZCAbstractLabel) newComponent(ZCLabel.class);
		Age.setLabel("Age : ");

		ZCLabel id_prof = (ZCAbstractLabel) newComponent(ZCLabel.class);
		id_prof.setLabel("id_prof  : ");
		id_prof.setIdComponent("textField_id_prof");

		ZCTextField value_name = (ZCTextField) newComponent(ZCTextField.class);
		value_name.setText("Please insert your Name ");

		ZCTextField value_id = (ZCTextField) newComponent(ZCTextField.class);
		value_id.setText("Insert your ID ");
		value_id.setIdComponent("textField_id_prof");

		ZCLabel Sexe = (ZCAbstractLabel) newComponent(ZCLabel.class);
		Sexe.setLabel("Sexe  : ");

		ZCTextField value_age = (ZCTextField) newComponent(ZCTextField.class);
		value_name.setText("Please Age here ");

		ZCTextField value_prenom = (ZCTextField) newComponent(ZCTextField.class);
		value_name.setText("Please Last name here ");

		ZCRadioButton choix_m = (ZCRadioButton) newComponent(ZCRadioButton.class);
		choix_m.setValue("Masculin");
		choix_m.setName("Sexe");

		ZCRadioButton choix_f = (ZCRadioButton) newComponent(ZCRadioButton.class);
		choix_f.setValue("Feminin");
		choix_f.setName("Sexe");

		ZCCheckBox radiobutton = (ZCCheckBox) newComponent(ZCCheckBox.class);
		radiobutton.setValue("J'accepte les conditions d'inscription ");

		ZCButton button = (ZCButton) newComponent(ZCButton.class);
		button.setText("OK");

		 ProxyMapComponent id_prof_secure = new ProxyMapComponent(id_prof);
		 ProxyMapComponent Value_secure = new ProxyMapComponent(value_id);
         
		layout.setSize(9, 2);

		layout.addComponent(nom);
		layout.addComponent(value_name);
		layout.addComponent(prenom);
		layout.addComponent(value_prenom);
		layout.addComponent(id_prof_secure);
		layout.addComponent(Value_secure);
		layout.addComponent(Age);
		layout.addComponent(value_age);
		layout.addComponent(Sexe);
		layout_Sexe.addComponent(choix_f);
		layout_Sexe.addComponent(choix_m);
		layout.addComponent(layout_Sexe);
		layout.addComponent(radiobutton);
		layout.addComponent(button);

		page.setBody(layout);
		return page;
	}
}
