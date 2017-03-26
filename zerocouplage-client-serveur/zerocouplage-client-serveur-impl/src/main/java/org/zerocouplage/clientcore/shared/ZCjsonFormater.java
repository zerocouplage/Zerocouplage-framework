package org.zerocouplage.clientcore.shared;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import org.json.simple.JSONObject;
import java.util.HashMap;

public class ZCjsonFormater {

	public final static String ZC_SEPARATOR_JSON_RESPONSE = "_:zc:_";
	
	public static String tojson(Object obj) {

		String json = "";

		final GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		json = gson.toJson(obj);
		System.out.println("Resultat = " + json);
		return json;
	}

	public static Object tojava(String json, Class className) {

		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();

		try {

			// convert JSON string to Map
			map = mapper.readValue(json,
					new TypeReference<HashMap<String, String>>() {
					});
			// System.out.println(map.get("age"));
			System.out.println(map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
		Gson gson = new Gson();
		Object obj = new Object();

		// String className = map.get("className");
		Class classBean;

		// classBean = Class.forName(className);
		// convert the json string back to object
		obj = gson.fromJson(json, className);

		//

		System.out.println(obj);

		return obj;
	}

}
