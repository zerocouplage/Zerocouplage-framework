package org.zerocouplage.application.mobile.business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zerocouplage.application.mobile.bean.AdminBeanOut;
import org.zerocouplage.application.mobile.bean.BeanUser;
import org.zerocouplage.application.mobile.bean.BeanUserOut;

public class RecrutBusiness {

	private BeanUserOut outCv;
	private BeanUserOut userout;
	private AdminBeanOut adminout;

	public BeanUserOut getOutCv() {
		return outCv;
	}


	BD gestionnaireUtilisateurs = null;

	public AdminBeanOut getAdminout() {
		return adminout;
	}

	public BeanUserOut getUserout() {
		return userout;
	}

	public String deleteCandidat(BeanUser id) {
		String result = null;
		BD db = null;
		try {
			db = new BD();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			db.update("DELETE FROM candidat7 WHERE id_candidat = '"
					+ id.getIdUser() + "'");

			if (db.select("SELECT * FROM candidat7").size() != 0) {
				result = "success";
			} else {
				result = "failed";
			}
			db.shutdown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<BeanUser> getDataFromCandidat() {

		List<BeanUser> listCandidat = new ArrayList<BeanUser>();

		BD db = null;
		try {
			db = new BD();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {
			listCandidat = db
					.selectCandidat("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat7  ORDER BY date_demande DESC");
			System.out.println("the list condidat is "+listCandidat);
			db.shutdown();
			

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return listCandidat;
	}

	public String openFile(BeanUser path) {
		outCv = new BeanUserOut();
		outCv.setPathCv(path.getPath());
		return "success";

	}
	
	public String Formprocess(BeanUser in) {

		userout = new BeanUserOut();

		userout.setFirstName(in.getNom());
		userout.setLastName(in.getPrenom());
		userout.setCivilite(in.getCivilite());
		userout.setPathCv(in.getCv().getAbsolutePath());
		try {
			gestionnaireUtilisateurs = new BD();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
//
//			gestionnaireUtilisateurs
//					.update("CREATE TABLE candidat7(id_candidat int identity,nom varchar(15),prenom varchar(15),dan date,email varchar(100),civilite varchar(100),nb_annee_exp DECIMAL,type_demande varchar(100),path varchar(100),date_demande  date)");
//
//			gestionnaireUtilisateurs
//					.update("CREATE TABLE administrateur(id_admin int identity,login varchar(15),pass varchar(15)");
//
//			gestionnaireUtilisateurs
//					.update("INSERT INTO administrateur (login,pass)  VALUES ('admin','admin')");
//			System.out.println("les valeurs de la table sont "
//					+ gestionnaireUtilisateurs
//							.query("SELECT * FROM administrateur"));
//			// System.out.println("table 666 cr��� AAAAAhlam");
//

		PreparedStatement st;
		try {
			

			st = gestionnaireUtilisateurs
					.getConnexion()
					.prepareStatement(
							"insert into candidat7(nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,path,date_demande) values(?,?,?,?,?,?,?,?,?)");


			st.setString(1, in.getPrenom());
			st.setString(2, in.getNom());
			//
			java.sql.Date sqlDate = new java.sql.Date(in.getDan()
					.getTime());

			st.setDate(3, sqlDate);
			st.setString(4, in.getEmail());
			st.setString(5, in.getCivilite());
			st.setDouble(6, in.getNbAnneeExp());
			st.setString(7, in.getNatureDemande());

			Date sysdan = new Date();

			java.sql.Date sqlDat = new java.sql.Date(sysdan.getTime());

			st.setString(8, in.getCv().getAbsolutePath());

			st.setDate(9, sqlDat);

			st.executeUpdate();

			System.out.println("Query Executed");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		ResultSet resultat = null;
		try {
			resultat = gestionnaireUtilisateurs
					.Query("SELECT * FROM candidat7");

			System.out
					.println("id_candidat   \t\tpr�nom   \t\t\tnom   \t\tdannn   \t\tMail   \t\tCivilite   Type_demande  date_demande");

			while (resultat.next()) {
				System.out.println(resultat.getString("id_candidat") + "\t\t"
						+ resultat.getString("nom") + "    \t\t"
						+ resultat.getString("prenom") + "   \t\t"
						+ resultat.getDate("dan") + "     \t\t"
						+ resultat.getString("email") + "    \t\t"
						+ resultat.getString("civilite") + "   \t\t"
						+ resultat.getString("nb_annee_exp") + "   \t\t"
						+ resultat.getString("type_demande") + "   \t\t"
						+ resultat.getString("date_demande") + "   \t\t"
						+ resultat.getString("path"));
			}

			gestionnaireUtilisateurs.getConnexion().close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "success";
	}


}