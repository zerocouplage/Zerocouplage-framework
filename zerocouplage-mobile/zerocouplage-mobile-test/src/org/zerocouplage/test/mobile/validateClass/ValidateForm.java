package org.zerocouplage.test.mobile.validateClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.test.mobile.bean.UserBeanIn;

public class ValidateForm implements IZCValidator {

	private static final String GLOBAL_MESSAGE = "validate java";

	private int seconds, minutes, hours, days, month, year;

	@Override
	public Map<String, String> validate(Map<String, String> ViewValue,
			Map<String, String> propertiesMap, Object beanIn) {

		Map<String, String> listeErrors = new HashMap<String, String>();

		UserBeanIn lbean = (UserBeanIn) beanIn;

		if (lbean.getNom() == null) {

			listeErrors.put("error_firstName", "nom est obligatoire");

		}
		if (lbean.getPrenom() == null) {

			listeErrors.put("error_lastName", "prenom est obligatoire");

		}

		Date currentDate = new Date();

		//System.out.println(lbean.getDan());
		System.out.println(currentDate);

		//System.out.println(lbean.getDan().getTime() + "  "
			//	+ currentDate.getTime());

		long v1 = currentDate.getTime();
		long v2 = lbean.getDateNaissance().getTime();

		long v3 = v1 - v2;

		//System.out.println(v3);

		seconds = (int) (v3 / 1000);
		if (seconds > 59) {
			minutes = seconds / 60;
			if (minutes > 59) {
				hours = minutes / 60;
				if (hours > 23) {
					days = hours / 24;
					if (days > 30) {
						month = days / 30;
						if (month > 11) {
							year = month / 12;

							System.out
									.println("Year " + year + " Month " + month
											% 12 + " Days " + days % 30
											+ " hours " + hours % 24
											+ " Minutes " + minutes % 60
											+ " Seconds " + seconds % 60);
						}
					}
				}
			}
		}

		if (year < 20) {

			listeErrors
					.put("error_birthday", "vous devez avoir aumoins 20 ans");
		}
		if (year > 45) {

			listeErrors.put("error_birthday",
					"vous devez avoir moins de 45 ans");
		}
//
//		if ((double) lbean.getCv().length() > 300000) {
//
//			listeErrors.put("error_Cv",
//					"la taille du cv ne doit pas d�passer 300 ko");
//
//		}
//
//		Double fileLengt = (double) lbean.getCv().length();
//
//		System.out.println(fileLengt + "octets");
//
//		
		

		if (!listeErrors.isEmpty()) {
			listeErrors.put("GLOBAL_MESSAGE", GLOBAL_MESSAGE);
		}
		return listeErrors;
	}

}
