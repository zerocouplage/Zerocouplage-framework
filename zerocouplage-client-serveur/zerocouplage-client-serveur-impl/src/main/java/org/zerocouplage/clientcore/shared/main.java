package org.zerocouplage.clientcore.shared;

import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.tutorial.beans.UserBeanOut;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resultat12 = ZCjsonFormater.tojson(null);
		
		System.out.println(resultat12);
		
		String jsonResp = "{\"className\":\"org.zerocouplage.tutorial.beans.UserBeanOut\",\"viewName\":\"Accueil\",\"responseCode\":0}"+ ZCjsonFormater.ZC_SEPARATOR_JSON_RESPONSE +"{\"login\":\"admin\"}";
		
		
		String[] listContent = jsonResp.split(ZCjsonFormater.ZC_SEPARATOR_JSON_RESPONSE);
		String jsonZCResponse = listContent[0];
		String content = listContent[1];
		ZCResponse zcresp = (ZCResponse) ZCjsonFormater.tojava(jsonZCResponse, ZCResponse.class);
		
		
		Class classContentName;
		try 
		{
			classContentName = Class.forName(zcresp.getClassName());
			UserBeanOut userOut = (UserBeanOut) ZCjsonFormater.tojava(content, classContentName);
			zcresp.setContent(userOut);
		} catch (ClassNotFoundException e) {
			zcresp.setZcStatus("Error:ClassNotFoundException");
			e.printStackTrace();
		}
		
		
		MonObjet fouad = new MonObjet("fouad", "azioiz", "mehdi", "ilyass");
		MonBean yassine = new MonBean("fizazi", "yassine", "hayandalos",
				"066668666");

		String resultat1 = ZCjsonFormater.tojson(fouad);
		Object obj = ZCjsonFormater.tojava(resultat1, MonObjet.class);

		// test pour l autre bean :

		String resultat2 = ZCjsonFormater.tojson(yassine);
		Object obj2 = ZCjsonFormater.tojava(resultat2, MonBean.class);
		MonBean b = MonBean.class.cast(obj2);
		// MonObjet bean=(MonObjet) obj;

		MonObjet bean = MonObjet.class.cast(obj);
		bean.toString();
		b.toString();
		System.out.println("le champs 2:" + bean.getChamp2());
		System.out.println("---------------");
		System.out.println("Votre Nom:" + b.getNom());
		// String json = "{name:\"mkyong\"}";

	}

}
