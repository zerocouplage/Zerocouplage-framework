package org.zerocouplage.clientapi.httpmanager;

import org.zerocouplage.clientapi.bean.ZCRequest;
import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.clientapi.exceptions.ZCClientException;

public interface IZCHttpManager {
	
	/**
	 * 
	 * @param agent : zcdesktop or zcmobile
	 */
	void setAgent(String agent);
	 String getAgent();
	 
	 void setURLApplication(String URLApps);
	 String getURLApplication();
	 
	 ZCResponse send(ZCRequest request) throws ZCClientException;
}
