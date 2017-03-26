package org.zerocouplage.validator.forms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.constant.ZCValTagLib;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * the FormsValidatorLoader class contains methods to load the validation xml
 * file
 * 
 * @author bobmed version 1.0.0
 * @author Taj sara version 1.2.0
 * @author Bennadir Yasmine version 1.2.0
 * 
 */
public class FormsValidatorLoader {
	private String pathFile;
	private FormsValidatorConfig formsValidatorConfig;
	private static Document document;
	private static Element racine;
	private static Element ZCracine;
	private static Element ZBean;
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(FormsValidatorLoader.class);

	/**
	 * @param pathFile
	 *            the xml file path
	 * @param formsValidatorConfig
	 *            forms validators configuration
	 * @throws ZCExceptionConfig 
	 */
	public FormsValidatorLoader(String pathFile,
			FormsValidatorConfig formsValidatorConfig) throws ZCExceptionConfig {
		super();
		this.setPathFile(pathFile);
		this.setFormsValidatorConfig(formsValidatorConfig);
		SAXBuilder sxb = new SAXBuilder();
		InputStream path_ZCVal;
		try {
			 path_ZCVal= this.getClass().getClassLoader().getResourceAsStream(pathFile);
				if (path_ZCVal==null) 
					throw new ZCExceptionConfig();
			document = sxb.build(path_ZCVal);
		}
		catch (ZCExceptionConfig ex) {
			logger.error("loading error: please verify that your validation file exists in the pakcage ressources of your project and check that the path indicated in the attribute valueTarget in zerocouplage.xml is correct", ex);

		}
		catch (JDOMException ex) {
			logger.error("loading error: please verify that your validation file exists in the pakcage ressources of your project and check that the path indicated in the attribute valueTarget in zerocouplage.xml is correct", ex);

		} catch (IOException ex) {
			logger.error("loading error: please verify that your validation file exists in the pakcage ressources of your project and check that the path indicated in the attribute valueTarget in zerocouplage.xml is correct " + pathFile, ex);

		}

	}

	/**
	 * methods allows laoding the validation xml file
	 */
	public void startLoadedXml() {
		initDomParameter();
		fullGlobalMessage();
		fullAllFieldConstraint();
	}

	/**
	 * initialization reading validation xml file
	 */
	private void initDomParameter() {

		racine = document.getRootElement();
		ZCracine = racine;
		ZBean = ZCracine.getChild(ZCValTagLib.beanValidator);
	}

	/**
	 * recover the field name ,constraint and error message
	 */
	private void fullAllFieldConstraint() {

		List<Element> listFields = ZBean.getChildren(ZCValTagLib.field);
		Iterator<Element> iterFields = listFields.iterator();
		while (iterFields.hasNext()) {
			Element field = (Element) iterFields.next();
			String nameField = field.getAttributeValue(ZCValTagLib.name);
			String constraint = field.getAttributeValue(ZCValTagLib.constraint);
			String messageError = field.getChild(ZCValTagLib.message).getText();
			FieldConstraint fieldConstraint = new FieldConstraint();
			fieldConstraint.setFieldName(nameField);
			fieldConstraint.setConstraint(constraint);
			fieldConstraint.setMessageError(messageError);
			this.formsValidatorConfig.addFieldConstraint(fieldConstraint);
		}
	}

	/**
	 * recover the global message to display if one of fields is not filled or
	 * is invalid
	 */
	private void fullGlobalMessage() {
		// Element courant = ZCracine.getChild("global-message") ;
		String globalMessage = ZCracine.getChild(ZCValTagLib.globalMessage).getText();
		this.formsValidatorConfig.setGolbalMessage(globalMessage);
	}

	/**
	 * Gets the path of validation xml file
	 * 
	 * @return the path of validation xml file
	 */
	public String getPathFile() {
		return pathFile;
	}

	/**
	 * Sets the path of validation xml file
	 * 
	 * @param pathFile
	 *            the path of validation xml file
	 */
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	/**
	 * Gets the forms validators configuration
	 * 
	 * @return an instance of FormsValidatorsConfig
	 */
	public FormsValidatorConfig getFormsValidatorConfig() {
		return formsValidatorConfig;
	}

	/**
	 * Sets forms validator configuration
	 * 
	 * @param formsValidatorConfig
	 *            the form validator configuration
	 */
	public void setFormsValidatorConfig(
			FormsValidatorConfig formsValidatorConfig) {
		this.formsValidatorConfig = formsValidatorConfig;
	}

}
