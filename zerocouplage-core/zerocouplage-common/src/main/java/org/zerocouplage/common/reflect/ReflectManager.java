/**
 * 
 */
package org.zerocouplage.common.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;

/**
 * <p>
 * ReflectManager provides a means for invoking methods on a class
 * </p>
 * 
 * @author Guelmbaye Djikoloum version 1.0.0
 * 
 * @author Hinde Nasseur version 1.2.0
 * @author Sara Taj version 1.2.0
 * @author Ahlam Belouchi version 1.2.0
 * 
 */
public class ReflectManager {

	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ReflectManager.class);

	/**
	 * <p>
	 * Invoke and execute the class method whose name and parameters is
	 * specified
	 * </p>
	 * 
	 * @param className
	 *            The method class name
	 * @param methodeName
	 *            The method name
	 * @param listArgument
	 *            The set of parameters
	 * @return
	 */
	public static Object executeMethodeByClassName(String className,
			String methodeName, Object... arguments) {
		Object newInstance = creatInstanceByClassName(className);
		return executeMethode(newInstance, methodeName, arguments);
	}

	/**
	 * <p>
	 * Invokes and executes the class method whose name is specified
	 * </p>
	 * 
	 * @param className
	 *            The method class name
	 * @param methodeName
	 *            The method name
	 * @return
	 */
	public static Object executeMethodeByClassName(String className,
			String methodeName) {
		Object newInstance = creatInstanceByClassName(className);
		return executeMethode(newInstance, methodeName, new Object[0]);
	}

	/**
	 * <p>
	 * Constructs an instance for the class whose name is supplied
	 * </p>
	 * 
	 * @param className
	 *            The name of the class
	 * @return
	 */
	public static Object creatInstanceByClassName(String className) {
		Object instance = null;

		try {
			Class<?> cls = Class.forName(className);
			instance = cls.newInstance();
		} catch (InstantiationException e) {
			logger.error(
					"The class for the specified name cannot be instantiated. Please check that the class is not an abstract class, an interface, an array class...",
					e);
		} catch (ClassNotFoundException e) {
			logger.error("The class whose name is specified is not found", e);
		} catch (IllegalAccessException e) {
			logger.error(
					"The constructor of the class for the specified class name is inaccessible",
					e);
		}
		return instance;
	}

	/**
	 * <p>
	 * Invokes and executes the method whose name and parameters are specified,
	 * using the supplied Object instance
	 * </p>
	 * 
	 * @param instance
	 *            The Object instance
	 * @param methodeName
	 *            The method name
	 * @param Arguments
	 *            The set of parameters
	 * @return
	 */
	public static Object executeMethode(Object instance, String methodeName,
			Object... Arguments) {
		Object result = null;
		try {
			Method methode = null;
			if (Arguments.length == 0) {
				methode = instance.getClass().getDeclaredMethod(methodeName);
				result = methode.invoke(instance);
			} else {
				Class[] listClass = getListClassParam(instance, methodeName);
				methode = instance.getClass().getDeclaredMethod(methodeName,
						listClass);
				result = methode.invoke(instance, Arguments);

			}

		} catch (NoSuchMethodException e) {
			logger.error("The method whose name is specified is not found", e);
		} catch (IllegalArgumentException e) {
			logger.error(
					"The method to be invoked has not the right arguments : please check that the method arguments are the correct one",
					e);
		} catch (InvocationTargetException e) {
			logger.error("The method throws an exception", e);
		} catch (IllegalAccessException e) {
			logger.error("The method to be invoked is inaccessible", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Invokes and executes the method whose name and parameters are specified,
	 * using the supplied Object instance </p>
	 * 
	 * @param instance
	 *            The Object instance
	 * @param methodeName
	 *            The method name
	 * @return
	 */
	public static Object executeMethode(Object instance, String methodeName) {
		return executeMethode(instance, methodeName, new Object[0]);
	}

	/**
	 * <p>
	 * Returns a set of properties for the specified Class instance
	 * </p>
	 * 
	 * @param cls
	 *            The Class instance
	 * @return
	 */
	public static List<String> getAllField(Class<?> cls) {
		List<String> allField = new ArrayList<String>();
		Field[] fields = cls.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			allField.add(fieldName);
		}

		return allField;

	}

	/**
	 * <p>
	 * Returns the number of parameters of nameMethod
	 * </p>
	 * 
	 * @param instance
	 *            The Object instance
	 * @param methodName
	 *            The method name
	 * 
	 * @return
	 */

	public static int getNbrOfParameter(Object instance, String methodName)
			throws ClassNotFoundException {
		int number = 0;

		Method[] methodes = instance.getClass().getMethods();

		for (int i = 0; i < methodes.length; i++) {

			if (methodes[i].getName().equals(methodName)) {
				number = methodes[i].getParameterTypes().length;
			}
		}
		return number;
	}

	/**
	 * <p>
	 * Returns the number of parameters of nameMethod
	 * </p>
	 * 
	 * @param className
	 *            The method class name
	 * @param methodName
	 *            The method name
	 * 
	 * @return
	 */
	public static int getNbrOfParameter(String className, String methodName)
			throws ClassNotFoundException {
		Object instance = creatInstanceByClassName(className);
		return getNbrOfParameter(instance, methodName);

	}

	/**
	 * <p>
	 * Returns return type of nameMethod
	 * </p>
	 * 
	 * @param BeanIn
	 *            the class name of BeanIn
	 * @param nameMethod
	 *            the method name
	 * 
	 * @return
	 */
	public static Class returnTypeMethod(String BeanIn, String nameMethod)
			throws ClassNotFoundException {
		Class s = null;
		Class c = Class.forName(BeanIn);
		Method[] m = c.getMethods();

		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().equals(nameMethod)) {
				s = m[i].getReturnType();
			}
		}
		return s;
	}

	/**
	 * <p>
	 * Returns type of parameters of nameMethod
	 * </p>
	 * 
	 * @param BeanIn
	 * @param nameMethod
	 * 
	 * @return
	 */

	private static Class[] getParamTypeMethod(String BeanIn, String nameMethod)
			throws ClassNotFoundException {

		Class[] listClass = null;
		Class c = Class.forName(BeanIn);
		Method[] methodes = Class.forName(BeanIn).getMethods();

		for (int i = 0; i < methodes.length; i++) {

			if (methodes[i].getName().equals(nameMethod)) {
				listClass = new Class[methodes[i].getParameterTypes().length];

				for (int j = 0; j < methodes[i].getParameterTypes().length; j++) {

					listClass[j] = methodes[i].getParameterTypes()[j];
				}
			}
		}

		return listClass;
	}

	/**
	 * <p>
	 * Returns a set of Class instance for the parameters of the specified
	 * method methodeName using the supplied Object instance
	 * </p>
	 * 
	 * @param instance
	 *            The Object instance
	 * @param methodeName
	 *            The method name
	 * 
	 * @return
	 */

	private static Class[] getListClassParam(Object instance, String methodeName)
			throws ClassNotFoundException {

		Class[] params = getParamTypeMethod(instance.getClass()
				.getCanonicalName(), methodeName);
		Class[] listClass = new Class[params.length];
		for (int i = 0; i < params.length; i++) {

			if (params[i].equals(Integer.TYPE)) {
				listClass[i] = Integer.TYPE;

			} else if (params[i].equals(Float.TYPE)) {

				listClass[i] = Float.TYPE;

			} else if (params[i].equals(Double.TYPE)) {

				listClass[i] = Double.TYPE;
			} else if (params[i].equals(Long.TYPE)) {

				listClass[i] = Long.TYPE;
			} else if (params[i].equals(Boolean.TYPE)) {

				listClass[i] = Boolean.TYPE;
			} else {
				listClass[i] = params[i];
			}

		}
		return listClass;
	}

}
