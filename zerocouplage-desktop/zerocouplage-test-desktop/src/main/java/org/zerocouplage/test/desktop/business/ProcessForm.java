package org.zerocouplage.test.desktop.business;

import org.zerocouplage.test.desktop.bean.UserBeanIn;
import org.zerocouplage.test.desktop.bean.UserBeanResult;

public class ProcessForm {

	private UserBeanResult out;

	public UserBeanResult getOut() {
		return out;
	}

	public String process(UserBeanIn in) {
		
		out = new UserBeanResult();
		
		out.setFirstname(in.getNom());
		out.setLastname(in.getPrenom());
		out.setDate_naissance(in.getDateNaissance());
		out.setAgeRes(in.getAge());
		out.setTailleRes(in.getTaille());
		out.setQuestionRes(in.getQuestion());
		out.setFile(in.getFile());
		System.out.println(in.getList());
        out.setList(in.getList());

		
		return "success";
	}
}
