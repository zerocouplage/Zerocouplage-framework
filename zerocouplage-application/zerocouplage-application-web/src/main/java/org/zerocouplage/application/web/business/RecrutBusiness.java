package org.zerocouplage.application.web.business;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zerocouplage.application.web.bean.AdminBeanIn;
import org.zerocouplage.application.web.bean.AdminBeanOut;
import org.zerocouplage.application.web.bean.BeanUser;
import org.zerocouplage.application.web.bean.BeanUserOut;

public class RecrutBusiness {

	private BeanUserOut userout;
	private File fileResult;
	private AdminBeanOut outt;

	public String process1(AdminBeanIn in) {

		outt = new AdminBeanOut();

		outt.setLogin_Admin(in.getLogin_admin());

		outt.setPassword_Admin(in.getPassword_admin());

		return "success";
	}

	public String Formprocess(BeanUser in) {

		userout = new BeanUserOut();

		userout.setFirstName(in.getNom());
		userout.setLastName(in.getPrenom());
		userout.setCivilite(in.getCivilite());

		BD bd = null;

		try {
			try {
				bd = new BD();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			PreparedStatement st;

			st = bd.getConnexion()

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
			Date sysdate = new Date();

			java.sql.Timestamp timeStampDate = new Timestamp(sysdate.getTime());

			String req = timeStampDate.toString();
			st.setTimestamp(9, timeStampDate);

			st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}

	public String deleteCandidat(BeanUser user) {
		String result = null;
		BD bd = null;
		try {
			bd = new BD();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			bd.update("DELETE FROM candidat WHERE id_candidat = '" + user.getIdUser()
					+ "'");
			if (bd.select("SELECT * FROM candidat").size() != 0) {
				result = "success";
			} else {
				result = "error";
			}
			bd.shutdown();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

//	public static List<Candidat> getData() {
//
//		List<Candidat> listCandidat = new ArrayList<Candidat>();
//		BD bd = null;
//		try {
//			bd = new BD();
//		} catch (Exception ex1) {
//			ex1.printStackTrace();
//		}
//		try {
//			listCandidat = bd
//					.selectCandidat("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat  ORDER BY date_demande DESC");
//			bd.shutdown();
//
//		} catch (SQLException ex3) {
//			ex3.printStackTrace();
//		}
//		return listCandidat;
//	}
	public static List<BeanUser> getUsers() {

		List<BeanUser> listUser = new ArrayList<BeanUser>();
		BD bd = null;
		try {
			bd = new BD();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		try {
			listUser = bd
					.selectUser("SELECT nom,prenom,dan,email,civilite,nb_annee_exp,type_demande,date_demande,path,id_candidat FROM  candidat  ORDER BY date_demande DESC");
			bd.shutdown();

		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
		return listUser;
	}

	public String openFile(BeanUser user) {
		fileResult = new File(user.getPath());
		System.out.println("openFile   "+user.getPath());
		return "success";
	}

	public File getFileResult() {
		return fileResult;
	}

	public BeanUserOut getUserout() {
		return userout;
	}

	public AdminBeanOut getOutt() {
		return outt;
	}

}
