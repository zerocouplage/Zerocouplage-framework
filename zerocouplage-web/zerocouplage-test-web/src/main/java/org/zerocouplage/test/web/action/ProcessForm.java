package org.zerocouplage.test.web.action;


import org.zerocouplage.test.web.bean.UserBeanResult;
import org.zerocouplage.test.web.bean.userBeanIn;

public class ProcessForm {

	private UserBeanResult out;

	public UserBeanResult getOut() {
		return out;
	}

	public String process(userBeanIn in) {
		out = new UserBeanResult();
		out.setFirstname(in.getNom());
		out.setLastname(in.getPrenom());
		out.setAgeout(in.getAge());
        out.setBirthday(in.getDateanniversaire());
        out.setTail(in.getTaille());
        out.setQuestionout(in.getQuestion());
        out.setFile(in.getFile());
		
		return "success";
	}
}
