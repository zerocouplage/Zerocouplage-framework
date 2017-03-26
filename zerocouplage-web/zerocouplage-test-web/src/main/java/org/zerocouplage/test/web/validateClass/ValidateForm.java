package org.zerocouplage.test.web.validateClass;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.test.web.bean.userBeanIn;

public class ValidateForm implements IZCValidator {
	private static final String GLOBAL_MESSAGE = "Some others are mistakens";

	@Override
	public Map<String, String> validate(Map<Object, Object> arg0,
			Map<String, String> arg1, Object bean) {
		Map<String, String> listeErrors = new HashMap<>();
		userBeanIn lbean = (userBeanIn) bean;

		
		if (lbean.getDateanniversaire() == null) {
			listeErrors.put("error_birthday", "Date is required");
		}
		
		if (lbean.getAge() < 18 ) {
			listeErrors.put("error_ageout", "must be more than 18");
		}

		if (lbean.getTaille() == 0 || !String.valueOf(lbean.getTaille()).matches("1.[0-9]*")) {
			listeErrors.put("error_tail", "Size is invalid");
		}

		if (!listeErrors.isEmpty()) {
			listeErrors.put("GLOBAL_MESSAGE", GLOBAL_MESSAGE);
		}
		return listeErrors;
	}

}
