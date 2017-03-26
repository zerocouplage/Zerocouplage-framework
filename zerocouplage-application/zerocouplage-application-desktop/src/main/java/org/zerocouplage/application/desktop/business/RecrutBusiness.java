package org.zerocouplage.application.desktop.business;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import org.zerocouplage.application.desktop.bean.AdminBeanOut;
import org.zerocouplage.application.desktop.bean.BeanUser;
import org.zerocouplage.application.desktop.bean.BeanUserOut;

public class RecrutBusiness {
	
	private BeanUserOut result,userout;
	private AdminBeanOut adminout;

	public String deleteCandidat(BeanUser idUser) {
		String result = null;
		BD bd = null;
		try {
			bd = new BD();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			bd.update("DELETE FROM candidat WHERE id_candidat = '" + idUser.getIdUser()
					+ "'");
			if (bd.select("SELECT * FROM candidat").size() != 0) {
				result = "success";
			} else {
				result = "failed";
			}
			bd.shutdown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Vector getDataFromCandidat() {

		Vector result = new Vector();
		BD db = null;
		try {
			db = new BD();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {

			result = db
					.select("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat  ORDER BY date_demande DESC");
			db.shutdown();

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return result;
	}

	public String openFile(BeanUser user) {
		result = new BeanUserOut();
		result.setPathCv(user.getPath());
		return "success";
	}


	public String Formprocess(BeanUser in) {
		BD gestionnaireUtilisateurs = null;

		try {
			gestionnaireUtilisateurs = new BD();
		} catch (Exception e) {
			e.printStackTrace();
		}

		userout = new BeanUserOut();
		userout.setFirstName(in.getNom());
		userout.setLastName(in.getPrenom());
		userout.setCivilite(in.getCivilite());
		
		try {

			PreparedStatement st = gestionnaireUtilisateurs
					.getConnexion()

					.prepareStatement(
							"insert into candidat(nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,path,date_demande) values(?,?,?,?,?,?,?,?,?)");

			st.setString(1, in.getPrenom());
			st.setString(2, in.getNom());

			java.sql.Date sqlDate = new java.sql.Date(in.getDan().getTime());

			st.setDate(3, sqlDate);
			st.setString(4, in.getEmail());
			st.setString(5, in.getCivilite());
			st.setDouble(6, in.getNbAnneeExp());
			st.setString(7, in.getNatureDemande());
			st.setString(8, in.getCv().getPath());

			Date sysdan = new Date();

			java.sql.Timestamp timeStampDate = new Timestamp(sysdan.getTime());

			String req = timeStampDate.toString();

			st.setString(9, req);

			st.executeUpdate();

			gestionnaireUtilisateurs.getConnexion().close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "success";
	}

	
	public BeanUserOut getResult() {
		return result;
	}
	public AdminBeanOut getAdminout() {
		return adminout;
	}

	public BeanUserOut getUserout() {
		return userout;
	}


}
