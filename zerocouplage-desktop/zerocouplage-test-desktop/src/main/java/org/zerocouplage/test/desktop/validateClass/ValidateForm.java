package org.zerocouplage.test.desktop.validateClass;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.test.desktop.bean.UserBeanIn;

public class ValidateForm implements IZCValidator {
	private static final String GLOBAL_MESSAGE = "Some fields are required";


	@Override
	public Map<String, String> validate(Map<Object, Object> ViewValue,
			Map<String, String> propertiesMap, Object beanIn) {

     Map<String, String> listeErrors = new HashMap<String, String>();
		
		
		
		UserBeanIn lbean = (UserBeanIn) beanIn;

		
		if (lbean.getDateNaissance() == null) {
			listeErrors.put("error_birthday", "Date is required");
		}
		
		if (lbean.getAge() < 30 ) {
			listeErrors.put("error_age", "must be more than 30");
		}

		if (lbean.getTaille() == null
				|| !String.valueOf(lbean.getTaille()).matches("1.[0-9]*")) {
			listeErrors.put("error_size ", "Size is invalid");
		}

		if (!listeErrors.isEmpty()) {
			listeErrors.put("GLOBAL_MESSAGE", GLOBAL_MESSAGE);
		}
		return listeErrors;
	}}
