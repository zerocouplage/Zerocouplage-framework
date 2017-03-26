package com.zerocouplage.test.web.action;


import com.zerocouplage.test.web.bean.UserBeanResult;
import com.zerocouplage.test.web.bean.userBeanIn;

public class GNote {
	
	private UserBeanResult out;

	public UserBeanResult getOut() {
		return out;  
	}  
	
	public String show(userBeanIn in) {
		out = new UserBeanResult();

		out.setLastname(in.getPrenom());
		out.setOut_action(in.getAction());
		return "Show"; 
	}
	
	public String save(userBeanIn in) {
		out = new UserBeanResult();

		out.setLastname(in.getPrenom());
		out.setOut_action(in.getAction());
		return "Save";
	}
	
	public String rectify(userBeanIn in){
		out = new UserBeanResult();

		out.setLastname(in.getPrenom());
		out.setOut_action(in.getAction());
		return "Rectify";
	}
	
}