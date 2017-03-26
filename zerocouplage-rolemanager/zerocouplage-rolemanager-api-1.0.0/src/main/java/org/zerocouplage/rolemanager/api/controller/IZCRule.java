package org.zerocouplage.rolemanager.api.controller;

public interface IZCRule {
	// LE developpeur implemente cette méthode pour recupérer le sujet concret
	// de la politique
	/**
	 * <p>
	 * A method to get the Orbac "Subject", in a concrete way it is the session
	 * User
	 * </p>
	 * 
	 * @return Subject
	 */

	public String getSubject();

	public String getObject();

	public void setObject(String object);
}
