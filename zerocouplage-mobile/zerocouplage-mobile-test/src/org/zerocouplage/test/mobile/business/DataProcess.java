package org.zerocouplage.test.mobile.business;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.zerocouplage.test.mobile.bean.Candidat;
import org.zerocouplage.test.mobile.bean.CandidatID;
import org.zerocouplage.test.mobile.bean.Path;
import org.zerocouplage.test.mobile.bean.PathOut;
import org.zerocouplage.test.mobile.bean.UserBeanResult;




public class DataProcess {
	
	private PathOut outCv;

	public PathOut getOutCv() {
		return outCv;
	}

	public String deleteCandidat(CandidatID id) {
		String result = null;
		Dao db = null;
		try {
			db = new Dao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			
			db.update("DELETE FROM candidat7 WHERE id_candidat = '" + id.getId()
					+ "'");
			
			if(db.select("SELECT * FROM candidat7").size()!=0){
				result="success";
			}else{
				result="failed";
			}
			db.shutdown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Vector getDataFromCandidat() {

		Vector result = new Vector();
		Dao db = null;
		try {
			db = new Dao();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {

			result = db
					.select("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat7  ORDER BY date_demande DESC");
			db.shutdown();

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return result;
	}
//	public static List<Candidat> getData() {
//
//		List<Candidat> listCandidat = new ArrayList<Candidat>();
//
//		Dao db = null;
//		try {
//			db = new Dao();
//		} catch (Exception ex1) {
//			ex1.printStackTrace();
//		}
//		try {
//			/*"create table administrateur ( id INTEGER, "
////										+ "login VARCHAR(100) , password VARCHAR(100));"*/
////			db.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal,"
////				+ "type_demande varchar(100),path varchar(100),date_demande timestamp)");
////			db.update("INSERT INTO candidat VALUES(0,'dddd','sara','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
////			db.update("INSERT INTO candidat VALUES(1,'dddd','salma','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
////			db.update("create table administrateur ( id INTEGER, login VARCHAR(100) , password VARCHAR(100));");
////			db.update("insert into administrateur(id, login, password) values (1, 'admin' , 'admin');");
//			listCandidat=db.selectCandidat("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat  ORDER BY date_demande DESC");
//			db.shutdown();
//
//		} catch (SQLException ex3) {
//			ex3.printStackTrace();
//		}
//		return listCandidat;
//
//
////	public String downloadCv(Path path) throws IOException {
////
////		Desktop desk = Desktop.getDesktop();
////		if (path.getPath() != null) {
////			desk.open(new File(path.getPath()));
////		} else {
////			System.out.println("impossible de trouver le fichier");
////		}
////		return "success";
////	}
//}

	public static List<Candidat> getData() {

		List<Candidat> listCandidat = new ArrayList<Candidat>();

		Dao db = null;
		try {
			db = new Dao();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {
			/*"create table administrateur ( id INTEGER, "
//										+ "login VARCHAR(100) , password VARCHAR(100));"*/
//			db.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal,"
//				+ "type_demande varchar(100),path varchar(100),date_demande timestamp)");
//			db.update("INSERT INTO candidat VALUES(0,'dddd','sara','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
//			db.update("INSERT INTO candidat VALUES(1,'dddd','salma','1991-12-12','sssa@gmail.com','madame',2,'Stage','E:\\saraCv.txt','2013-05-10 20:45:47.612000')");
//			db.update("create table administrateur ( id INTEGER, login VARCHAR(100) , password VARCHAR(100));");
//			db.update("insert into administrateur(id, login, password) values (1, 'admin' , 'admin');");
			listCandidat=db.selectCandidat("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat7  ORDER BY date_demande DESC");
			db.shutdown();

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return listCandidat;
	}
	
	public String VoirCv(Path path){
		outCv=new PathOut();
		outCv.setPath(path.getPath());
		return "success";
		
		
		
	}

	}