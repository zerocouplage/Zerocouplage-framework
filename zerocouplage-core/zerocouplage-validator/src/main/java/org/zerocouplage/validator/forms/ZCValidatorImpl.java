package org.zerocouplage.validator.forms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.zerocouplage.api.config.IValidatorConfig;
import org.zerocouplage.api.validator.IZCValidator;
import org.zerocouplage.common.constant.ZCValTagLib;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;

/**
 * the ZCValidatorImpl class implements IZCValidator interface contains all
 * treatment to validate form fields
 * 
 * @author bobmed version 1.0.0
 * 
 * @author Yasmine Bennadir  version 1.2.0
 * 
 */
public class ZCValidatorImpl implements IZCValidator {

	private IValidatorConfig validatorConfig;
	private FormsValidatorConfig formsValidatorConfig;

	/**
	 * @param iValidatorConfig
	 *            an instance of IvalidtorConfig
	 * 
	 */
	public ZCValidatorImpl(IValidatorConfig iValidatorConfig) {
		this.validatorConfig = iValidatorConfig;
		this.formsValidatorConfig = new FormsValidatorConfig();
		loadValidatorFromXML();

	}

	/**
	 * loading the validator based on xml file
	 * 
	 */
	public void loadValidatorFromXML() {
		
		//  si les config dans zerocouplage.xml de validator sont rempli ,et que
        //  la validation se fait avec un fichier xml alors 
		
		if (this.validatorConfig != null
				&& this.validatorConfig.isConfigFromFile()) {
			
			//path = le chemin du fichier de validation : zc_val.xml
			String pathValFile = this.validatorConfig.getValueTarget();
			
			//j'instancie le loader et lui donne le path du validateur +
			//les infos concernant un field
			FormsValidatorLoader formsValidatorLoader = null;
			
				try {
					formsValidatorLoader = new FormsValidatorLoader(
							pathValFile, this.formsValidatorConfig);
				} catch (ZCExceptionConfig e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			
			//il charge le fichier zc_val.xml
			formsValidatorLoader.startLoadedXml();
		}

	}

	
	/* (non-Javadoc)
	 * @see org.zerocouplage.api.validator.IZCValidator#validate(java.lang.Object)
	 */
	@Override
	public Map<String, String> validate(Map<Object, Object> ViewValue,Map<String, String> propertiesMap,Object BeanIn) {
        String  beanProperty = null;
		Map<String, String> listError = new HashMap<String, String>();
		
		if (this.validatorConfig != null) {
			//make a loop in the map ViewValue in order to extract the keys ViewPropeties
			for (Object viewProperty : ViewValue.keySet()) {
				//search the suitable key beanProperty associated to the viewProperty
				for(Entry<String, String> entry: propertiesMap.entrySet()){
		            if(viewProperty.equals(entry.getValue())){
		              beanProperty = entry.getKey();
		                break;
		            }
				}
				// get the value entered from the map ViewValue
				Object fieldValue = ViewValue.get(viewProperty);
              // extract the constraint associated to the beanProperty
				if (this.formsValidatorConfig.getListConstraint().containsKey(beanProperty)) {
					FieldConstraint fieldConstraint = this.formsValidatorConfig.getListConstraint().get(beanProperty);
					//add an error to the map listError if the fieldValue doesn't match the constraint 
					if (!((String) fieldValue).matches(fieldConstraint.getConstraint())) {
						listError.put(ZCValTagLib.error + viewProperty,fieldConstraint.getMessageError());
						
						
				     }
		         }
	        }
	   }
		

		if (!listError.isEmpty()) {
			listError.put(ZCValTagLib.GLOBAL_MESSAGE,
					this.formsValidatorConfig.getGolbalMessage());
		}
		return listError;
	}

}
