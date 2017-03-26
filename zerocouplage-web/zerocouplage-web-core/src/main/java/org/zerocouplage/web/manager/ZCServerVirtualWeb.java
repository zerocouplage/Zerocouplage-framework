package org.zerocouplage.web.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.clientcore.shared.ZCjsonFormater;

/**
 * @author Mestari Salma version 1.2.0
 * @author Nasseur Hinde version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author hmiza 2.0.0
 */
public class ZCServerVirtualWeb extends ZCComponentVirtualWeb {

	@Override
	//cas d'erreur de saisie
	public void goToPageError(String pageName,
			Map<String, String> listParamsError) {

		String agent = ((HttpServletRequest) request).getHeader("User-Agent");//récupérer l'agent de la requête zc_type_d'application

		if ("ZCDesktop".equalsIgnoreCase(agent)
				|| "ZCMobile".equalsIgnoreCase(agent)) {
			// TODO : ZC 2.1.0
						ZCResponse zcResponse = new ZCResponse();
						zcResponse.setViewName(pageName);//retourner la page d'erreur
						
						if(listParamsError != null)//si la liste est remplie
						{
							zcResponse.setClassName(listParamsError.getClass().getName());
						}
						try {
							writeJSONResponst(zcResponse, listParamsError);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

		} else {
			super.goToPageError(pageName, listParamsError);
		}


	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue,
			boolean useSameViewInstance) {

		String agent = ((HttpServletRequest) request).getHeader("User-Agent");

		if ("ZCDesktop".equalsIgnoreCase(agent)
				|| "ZCMobile".equalsIgnoreCase(agent)) {

			
			if(beanValue instanceof File)
			{
				try {
					download((File)beanValue);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				// TODO : ZC 2.1.0
				ZCResponse zcResponse = new ZCResponse();
				zcResponse.setViewName(pageName);
				if(beanValue != null)
				{
					zcResponse.setClassName(beanValue.getClass().getName());
				}
			
				try {
					writeJSONResponst(zcResponse, beanValue);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} else {
			super.goToPage(pageName, beanName, beanValue, useSameViewInstance);
		}

	}


	private void writeJSONResponst(ZCResponse zcResponse, Object beanValue)
			throws Exception {

		PrintWriter out = this.response.getWriter();

		// /zcResponse -----> JSonresponse

		String jSonresponse = ZCjsonFormater.tojson(zcResponse);
		String jSonContent = ZCjsonFormater.tojson(beanValue);

		out.println(jSonresponse + ZCjsonFormater.ZC_SEPARATOR_JSON_RESPONSE
				+ jSonContent);

		out.close();

	}


}
