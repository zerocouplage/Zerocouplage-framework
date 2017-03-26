package org.zerocouplage.test.mobile.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.zerocouplage.test.mobile.bean.AdminBeanOut;
import org.zerocouplage.test.mobile.bean.UserBeanIn;
import org.zerocouplage.test.mobile.bean.UserBeanResult;


public class Business {

	private UserBeanResult userout;
    private AdminBeanOut adminout;
	

	
    Dao gestionnaireUtilisateurs= null;

	public AdminBeanOut getAdminout() {
		return adminout;
	}

	public UserBeanResult getUserout() {
		return userout;
	}

	public String Formprocess(UserBeanIn in) {
		 

		try {
//			gestionnaireUtilisateurs = new Dao();
////			gestionnaireUtilisateurs.update("CREATE TABLE candidatt(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal)");
//			
//			gestionnaireUtilisateurs.update("CREATE TABLE candidat1(id_candidat int identity,nom varchar(30),prenom varchar(30)");
//			
//			System.out.println("table cr�ee");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(0,'test','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(1,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(2,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(3,'test3','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(4,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(5,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//			gestionnaireUtilisateurs.update("INSERT INTO candidat VALUES(6,'test3','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");


//			System.out.println(gestionnaireUtilisateurs.select("SELECT * FROM candidat"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		userout = new UserBeanResult();

		userout.setFirstname(in.getNom());
		userout.setLastname(in.getPrenom());
		userout.setDate_naissance(in.getDateNaissance());
		userout.setEmail(in.getEmail());
		userout.setCivilite(in.getCivilite());
		userout.setNbAnneeExp(in.getNbAnneeExp());
		userout.setMySpinner(in.getNatureDemande());
		userout.setCv(in.getCv());

		System.out.println("chemin du file  "+in.getCv());
//		System.out.println(in.getCivilite());
//		System.out.println(in.getCv());


		try {

			try {
				gestionnaireUtilisateurs = new Dao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			gestionnaireUtilisateurs
//					.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),path longblob,date_demande  date)");

			
//			gestionnaireUtilisateurs
//			.update("CREATE TABLE candidat2(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL)");

//			gestionnaireUtilisateurs
//			.update("CREATE TABLE candidat3(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100))");
			
//			gestionnaireUtilisateurs
//			.update("CREATE TABLE candidat4(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),path varchar(100))");
			
			
			
//			gestionnaireUtilisateurs
//			.update("CREATE TABLE candidat5(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),date_demande  date)");
			
//			gestionnaireUtilisateurs
//			.update("CREATE TABLE candidat6(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),date_demande  date, path varchar(100))");
			
			gestionnaireUtilisateurs
			.update("CREATE TABLE candidat7(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),path varchar(100),date_demande  date)");
			
			
			
			gestionnaireUtilisateurs.update("CREATE TABLE administrateur(id_admin int identity,login varchar(15),pass varchar(15)");
			
			
			
			
			
			gestionnaireUtilisateurs.update("INSERT INTO administrateur (login,pass)  VALUES ('admin','admin')");
			System.out.println("les valeurs de la table sont "+gestionnaireUtilisateurs.query("SELECT * FROM administrateur"));
			System.out.println("table 666 cr��� AAAAAhlam");

		} catch (SQLException ex2) {

		}

//		try {
			
			
//			
//			gestionnaireUtilisateurs
//					.update("ALTER TABLE candidat ALTER COLUMN email SET DATA TYPE VARCHAR(100)");
//
//			System.out.println("update fait");
//
//			gestionnaireUtilisateurs
//					.update("ALTER TABLE candidat ALTER COLUMN nb_annee_exp SET DATA TYPE DECIMAL (3,1)");
//
//			System.out.println("update fait2");
//
//			gestionnaireUtilisateurs
//					.update("ALTER TABLE candidat ALTER COLUMN date_demande SET DATA TYPE TIMESTAMP");
//
//			System.out.println("update fait3");
			//gestionnaireUtilisateurs.update("DROP TABLE candidat");
//			gestionnaireUtilisateurs.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100)," +
//			 		"nb_annee_exp DECIMAL,type_demande varchar(100),path varchar(100),date_demande Timestamp)");
//			
		PreparedStatement st ;
			try {
//				 st = gestionnaireUtilisateurs
//						.getConnexion().prepareStatement(
//								"insert into candidat3(nom,prenom,dan,email,civilite,nb_annee_exp,type_demande) values(?,?,?,?,?,?,?)");
			
				 st = gestionnaireUtilisateurs
							.getConnexion().prepareStatement(
									"insert into candidat7(nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,path,date_demande) values(?,?,?,?,?,?,?,?,?)");
				
			System.out.println("~~~~~~~~~~~~~~~~~~~~");
//			System.out.println(" gestionnaireUtilisateurs.getConnexion()  "+ gestionnaireUtilisateurs
//					.getConnexion());

			
			
			st.setString(1, in.getPrenom());
			st.setString(2, in.getNom());
//
		java.sql.Date sqlDate = new java.sql.Date(in.getDateNaissance().getTime());

			st.setDate(3, sqlDate);
			st.setString(4, in.getEmail());
			st.setString(5, in.getCivilite());
			st.setDouble(6, in.getNbAnneeExp());
			st.setString(7, in.getNatureDemande());
//
////			int fileLengt = (int) in.getCv().length();
////
////			System.out.println("leghttt faiiittt");
////			java.io.InputStream fin = null;
////			try {
////				fin = new java.io.FileInputStream(in.getCv());
////
////				System.out.println("inputStreamfaiiittttt");
////			} catch (FileNotFoundException e1) {
////
////				e1.printStackTrace();
////
////				System.out.println("fameuse exceptionn");
////			}
////
////			// set the value of the input parameter to the input stream
////			// st.setAsciiStream(8, fin, fileLengt);
			
			//System.out.println("path"+in.getCv().getAbsolutePath());
////
		
//
			Date sysdan = new Date();

			System.out.println("sysdaaaate  " + sysdan);
			
//			java.sql.Date sqlDat = new java.sql.Date(sysdan.getTime());

//			java.sql.Timestamp timeStampDate = new Timestamp(sysdan.getTime());
//		
			
//			java.sql.Date Date = (java.sql.Date) new Date(sysdan.getTime());
			java.sql.Date sqlDat = new java.sql.Date(sysdan.getTime());

			System.out.println("sysdaaaate converti en timestamp "
				);

//			String req = timeStampDate.toString();

//			st.setString(8, req);
			
			st.setString(8, in.getCv().getAbsolutePath());
			
			st.setDate(9, sqlDat);
//
			st.executeUpdate();

			System.out.println("Query Executed");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet resultat = null;
		try {
			resultat = gestionnaireUtilisateurs.Query("SELECT * FROM candidat7");

		System.out
				.println("id_candidat   \t\tpr�nom   \t\t\tnom   \t\tdannn   \t\tMail   \t\tCivilite   Type_demande  date_demande");
		
			while (resultat.next()) {
				System.out.println(resultat.getString("id_candidat") + "\t\t"
						+ resultat.getString("nom") + "    \t\t"
						+ resultat.getString("prenom") + "   \t\t"
						+ resultat.getDate("dan") + "     \t\t"
						+ resultat.getString("email") + "    \t\t"
						+ resultat.getString("civilite") + "   \t\t"
						+ resultat.getString("nb_annee_exp")+ "   \t\t"
								+ resultat.getString("type_demande")+ "   \t\t"
										+ resultat.getString("date_demande")+ "   \t\t"
												+ resultat.getString("path"));
			}
			
			gestionnaireUtilisateurs.getConnexion().close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
		
		return "success";
	}

	
	
	
//public String processTODB(AdminBeanIn in) {
//		
//	adminout = new AdminBeanOut();
//		
//	adminout.setLogin_Admin(in.getLogin_admin());
//	adminout.setPassword_Admin(in.getPassword_admin());
//		
//		return "success";
//	}
}
