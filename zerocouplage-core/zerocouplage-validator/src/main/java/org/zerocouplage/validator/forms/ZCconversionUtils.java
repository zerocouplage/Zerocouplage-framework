package org.zerocouplage.validator.forms;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.constant.ZCconfigConstant;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * @author Nasseur Hinde version 1.2.0
 * @author Mestari salma version 1.2.0
 * @author Taj Sara version 1.2.0
 * @author Belouchi Ahlam version 1.2.0
 * 
 */
public class ZCconversionUtils {
	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCconversionUtils.class);

	public String format;

	public ZCconversionUtils() {

		super();
	}

	/**
	 * <p>
	 * Converts String to Date.
	 * 
	 * </p>
	 * 
	 * @param sDate
	 * 
	 * @param sFormat
	 * 
	 * @return Object instance
	 */
	private Date stringToDate(String sDate, String sFormat) {

		DateFormat sdf;
		Date date = null;

		sdf = new SimpleDateFormat(sFormat);
		try {
			date = sdf.parse(sDate);
		} catch (ParseException e) {

			logger.error("the format of Date is invalid, please check the file zerocouplage.xml");
		}
		return date;
	}

	/**
	 * <p>
	 * Converts paramter chaine to an Envelop type .
	 * </p>
	 * 
	 * @param chaine
	 * 
	 * @param type
	 * 
	 * @return Object CastedObjectType
	 */
	private Object CastTypeEnveloppe(String chaine, Class type)
			throws ClassNotFoundException {
		Object CastedObjectType = chaine;

		if (type.equals(Integer.class)) {
			try {
				CastedObjectType = Integer.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}

		} else if (type.equals(Double.class)) {
			try {
				CastedObjectType = Double.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Float.class)) {
			try {
				CastedObjectType = Float.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Long.class)) {
			try {
				CastedObjectType = Long.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Boolean.class)) {
			try {
				CastedObjectType = new Boolean(chaine);
			} catch (NumberFormatException e) {

			}
		} else if (type.equals(String.class)) {

			CastedObjectType = chaine;

		} else if (type.equals(Character.class)) {
			CastedObjectType = chaine.charAt(0);

		} else if (type.equals(Date.class)) {
			try {
				if (getFormat() != null) {
					CastedObjectType = stringToDate(chaine, getFormat());

				} else {
					CastedObjectType = stringToDate(chaine,
							ZCconfigConstant.DateFormat);
				}

			} catch (Exception e) {
				logger.error("the format of Date is invalid, please check the file zerocouplage.xml");
			}
		} else if (type.equals(File.class)) {

			CastedObjectType = new File(chaine);

		}
		return CastedObjectType;

	}

	/**
	 * <p>
	 * Converts parameter chaine to a primitive type.
	 * </p>
	 * 
	 * @param chaine
	 * 
	 * @param type
	 * 
	 * @return Object CastedObjectType
	 */
	private Object CastTypePrimitif(String chaine, Class type) {

		Object CastedObjectType = chaine;
		if (type.equals(Integer.TYPE)) {
			try {
				CastedObjectType = Integer.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Float.TYPE)) {
			try {
				CastedObjectType = Float.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Double.TYPE)) {
			try {
				CastedObjectType = Double.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Long.TYPE)) {
			try {
				CastedObjectType = Long.valueOf(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}
		} else if (type.equals(Boolean.TYPE)) {
			try {
				CastedObjectType = new Boolean(chaine);
			} catch (NumberFormatException e) {

				logger.error("the number format is invalid");

			}

		} else if (type.equals(Character.TYPE)) {

			CastedObjectType = chaine.charAt(0);

		}

		return CastedObjectType;

	}

	/**
	 * <p>
	 * Converts paramter chaine to an List type .
	 * </p>
	 * 
	 * @param chaine
	 * 
	 * @param type
	 * 
	 * @return Object CastTypeList
	 */
	public Object CastTypeList(Class type, String... chaine) {
		List<String> CastedObjectType = Arrays.asList(chaine);
		return CastedObjectType;
	}

	/**
	 * <p>
	 * Converts paramter chaine to a type .
	 * </p>
	 * 
	 * @param chaine
	 * 
	 * @param type
	 * 
	 * @return Object
	 */
	public Object CastTypeForm(String chaine, Class type)
			throws ClassNotFoundException {
		Object CastedObjectType;
		if (!type.isPrimitive()) {
			CastedObjectType = CastTypeEnveloppe(chaine, type);

		} else {
			CastedObjectType = CastTypePrimitif(chaine, type);

		}

		return CastedObjectType;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
