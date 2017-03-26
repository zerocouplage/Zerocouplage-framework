package org.zerocouplage.component.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.zerocouplage.rolemanager.api.controller.IZCRule;

public class ZCRule implements IZCRule {
	private String Subject = "";
	private String Object;
	
	

	public String getSubject() {

		InputStream lect;
		BufferedReader br = null;

		try {

			lect = this.getClass().getClassLoader()
					.getResourceAsStream("ressources/subject.txt");
			br = new BufferedReader(new InputStreamReader(lect));
			while (br.ready() == true) {
				Subject = br.readLine();
			}
		} catch (NullPointerException a) {
			System.out
					.println("Erreur : pointeur null creer le dossier ressources/ dans eclipse ");
		} catch (IOException a) {
			System.out.println("Problï¿½me d'IO");
		}

		return Subject;
	}



	public void setSubject(String nameSubject) {
		this.Subject = nameSubject;
	}



	public String getObject() {
		return Object;
	}



	public void setObject(String object) {
		Object = object;
	}



	public void setObject() {
		// TODO Auto-generated method stub
		
	}



	

}
