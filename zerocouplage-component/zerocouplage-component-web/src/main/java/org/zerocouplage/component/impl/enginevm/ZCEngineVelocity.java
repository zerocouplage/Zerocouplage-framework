package org.zerocouplage.component.impl.enginevm;

import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;

/**
 * <p>
 * ZCEngineVelocity is the loader of ZC components in web
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCEngineVelocity {

	/**
	 * <p>
	 * Method loads our ZC components
	 * </p>
	 * @param ZCComponentClass
	 * @param mapOfDataComponent
	 * @throws Exception
	 */
	public String ZCEngine(ZCAbstractComponent ZCComponentClass,
			HashMap<String, Object> mapOfDataComponent) throws Exception {
		VelocityEngine zcEngine;
		VelocityContext zcContext = new VelocityContext();
		String Package;
		String PathOfTemplate;
		Template template;
		Package = ZCComponentClass.getClass().getPackage().getName();
		PathOfTemplate = Package.replaceAll("\\.", "\\/");
		PathOfTemplate = PathOfTemplate + "/" + "templates" + "/"
				+ ZCComponentClass.getClass().getSimpleName() + ".vm";
		zcEngine = new VelocityEngine();
		zcEngine.setProperty("resource.loader", "class");
		zcEngine.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		URL url = this.getClass().getClassLoader().getResource(".");
		zcEngine.setProperty("file.resource.loader.path", url.toExternalForm());

		zcEngine.init();
		template = zcEngine.getTemplate("/" + PathOfTemplate);
		System.out.println("test");
		Set mapSet = mapOfDataComponent.entrySet();
		Iterator mapIterator = mapSet.iterator();
		while (mapIterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) mapIterator.next();
			String keyValue = (String) mapEntry.getKey();
			Object value = mapEntry.getValue();

			zcContext.put(keyValue, value);
		}

		StringWriter writer = new StringWriter();
		template.merge(zcContext, writer);
		return writer.toString();
	}
}
