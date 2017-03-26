package org.zerocouplage.rolemanager.api.controller;

import orbac.exception.COrbacException;

public interface IZCRuleManager {
	//Tester si l'utiliteur peut accéder à la view_ou (Object) à travers l'action (action)
	/**
	 * <p>The hasAccess Method with a given "View" which is an "Orbac Object" tests if the "Action" is allowed on that 
	 * Object by a given "Orbac Subject".</p> 
	 * @param subject
	 * @param action
	 * @param objectOrbac
	 * 
	 * @return Access Allowed/Denied
	 * 
	 * @throws COrbacException
	 * @throws Exception
	 */
	public boolean hasAccess(String subject, String action, String objectOrbac) throws COrbacException, Exception;
	/**
	 * 
	 * @param subject
	 * @param action
	 * @param id_object
	 * @return prohibition True/False
	 * @throws COrbacException
	 * @throws Exception
	 */
	public boolean isProhibited(String subject, String action, String id_object) throws COrbacException, Exception;
}
