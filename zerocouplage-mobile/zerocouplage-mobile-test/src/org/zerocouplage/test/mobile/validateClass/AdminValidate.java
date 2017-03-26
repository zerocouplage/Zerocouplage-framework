package org.zerocouplage.test.mobile.validateClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.test.mobile.bean.AdminBeanIn;
import org.zerocouplage.test.mobile.business.Dao;

public class AdminValidate implements IZCValidator {
	private static final String GLOBAL_MESSAGE = "Some fields are required";
 
	
	public Map<String, String> validate(Map<String, String> ViewValue,
			Map<String, String> propertiesMap, Object beanIn) {

		Dao db = null;
		AdminBeanIn Ibean = (AdminBeanIn) beanIn;
		System.out.println("the bean is "+Ibean.getLogin_admin());
	
		Map<String, String> listeErrors = new HashMap<String, String>();
		try {
			db = new Dao();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			
			ResultSet rs=db.query("SELECT * FROM administrateur");
			while(rs.next()){
				
				if(!rs.getString("login").equals(Ibean.getLogin_admin())){
					listeErrors.put("error_login", "ce login n'existe pas");
				}
				if(!rs.getString("pass").equals(Ibean.getPassword_admin())){
					listeErrors.put("error_password","le mot de passe est incorrecte");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!listeErrors.isEmpty()) {
			listeErrors.put("GLOBAL_MESSAGE", GLOBAL_MESSAGE);
		}
		return listeErrors;
	}
}
