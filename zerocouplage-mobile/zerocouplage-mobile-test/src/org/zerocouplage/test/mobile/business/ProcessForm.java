package org.zerocouplage.test.mobile.business;


import org.zerocouplage.test.mobile.bean.UserBeanIn;
import org.zerocouplage.test.mobile.bean.UserBeanResult;

public class ProcessForm {

	private UserBeanResult out;

	public UserBeanResult getOut() {
		return out;
	}
	
	public void setOut(UserBeanResult out){
		
		this.out=out;
	}

	public String process(UserBeanIn in) {
		
		out = new UserBeanResult();
		out.setFirstname(in.getNom());
		out.setLastname(in.getPrenom());
		out.setCivilite(in.getCivilite());
		out.setEmail(in.getEmail());
		out.setDate_naissance(in.getDateNaissance());
		out.setNbAnneeExp(in.getNbAnneeExp());
//		out.setFile(in.getFile());
		return "success";
	}
}

