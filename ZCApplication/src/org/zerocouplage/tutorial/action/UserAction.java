package org.zerocouplage.tutorial.action;

import org.zerocouplage.tutorial.beans.UserBeanIn;
import org.zerocouplage.tutorial.beans.UserBeanOut;

public class UserAction {

	UserBeanOut beanResult;

	public UserBeanOut getBeanResult() {
		return beanResult;
	}

	public void setBeanResult(UserBeanOut beanResult) {
		this.beanResult = beanResult;
	}

	public String traiterUser(UserBeanIn userIn) {
		String R;
		beanResult = new UserBeanOut();
		if("admin".equals(userIn.getNomUtilisateur()) && "admin".equals(userIn.getMotDepasse())){
			beanResult.setLogin(userIn.getNomUtilisateur());
			R="PageResultat";
			System.out.println("succes");
		}
		else{
			R="echec";
			System.out.println("fail");
		}

		
		return R;

	}
	public String process(UserBeanIn in) {
		beanResult = new UserBeanOut();
		beanResult.setLogin(in.getNomUtilisateur());
		beanResult.setPassword(in.getMotDepasse());
		beanResult.setEmail(in.getMail());
		beanResult.setDateNaissance(in.getDatN());


		return "success";
	}
}
