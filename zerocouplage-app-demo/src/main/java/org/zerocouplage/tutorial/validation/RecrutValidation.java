package org.zerocouplage.tutorial.validation;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.tutorial.beans.UserBeanIn;

import org.zerocouplage.api.validator.IZCValidator;

public class RecrutValidation implements IZCValidator {

	

	

	@Override
	public Map<String, String> validate(Map<Object, Object> ViewValue,
			Map<String, String> propertiesMap, Object beanIn) {

		Map<String, String> listeErrors = new HashMap<String, String>();

		UserBeanIn lbean = (UserBeanIn) beanIn;

		if (lbean.getNomUtilisateur() == null) {

			listeErrors.put("error_login", "login est obligatoire");

		}
		if (lbean.getMail() == null) {

			listeErrors.put("error_mail", "email est obligatoire");

		}
				

		return listeErrors;
	}

}
