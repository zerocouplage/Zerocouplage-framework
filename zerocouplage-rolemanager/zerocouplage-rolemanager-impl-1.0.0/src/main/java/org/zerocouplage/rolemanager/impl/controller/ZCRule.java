package org.zerocouplage.rolemanager.impl.controller;
import java.io.*;

import org.zerocouplage.rolemanager.api.controller.IZCRule;



public class ZCRule implements IZCRule{
	private String nameSubject="";
	
	
	public String getSubject() {
		
		InputStream lect ;
		BufferedReader br=null ;
	
		try
		{
			
			lect = this.getClass().getClassLoader().getResourceAsStream("ressources/subject.txt");//feredReader(new FileReader("ressources/subject.txt"));
			br = new BufferedReader(new InputStreamReader(lect));
			while (br.ready()==true) 
			{
				nameSubject = br.readLine() ; 
			}
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null creer le dossier ressources/ dans eclipse ");
		}
		catch (IOException a) 
		{
			System.out.println("Problï¿½me d'IO");
		}
		
	
		return nameSubject;
	}


	public String getObject() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setObject(String object) {
		// TODO Auto-generated method stub
		
	}

}
