package org.zerocouplage.application.web.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.zerocouplage.application.web.bean.BeanUser;

/*
 * la base de données se trouve dans le package DataBase du projet
 * les deux fichiers de ce package doivent être mis dans le repertoire C:/db
 */

public class BD {
	private static Connection conn = null;
	 
	public HashMap<String, String> map = new HashMap<String, String>();

	public BD() throws Exception {
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			conn = DriverManager.getConnection("jdbc:hsqldb:file:C:/db/recrutement",
					"sa", "");

		} catch (Exception e) {
			System.out.println("Echec de connexion!!");
	
		}
	}

	public void shutdown() throws SQLException {

		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
		conn.close();

	}

	public ResultSet query(String expression) throws SQLException {

		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		return rs;

	}

	public synchronized String query1(String expression) throws SQLException {
		String result = null;
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
		int colmax = meta.getColumnCount();
		Object o = null;

		for (; rs.next();) {
			for (int i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1);
				result = o.toString();
			}
		}
		st.close();
		return result;

	}

	public synchronized Vector select(String expression) throws SQLException {
		Vector row = new Vector();
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		row = dump(rs);
		st.close();
		return row;

	}
//	public synchronized List<Candidat>  selectCandidat(String expression) throws SQLException {
//		List<Candidat> listCandidat = new ArrayList<Candidat>();
//		
//		Statement st = null;
//		ResultSet rs = null;
//		st = conn.createStatement();
//		rs = st.executeQuery(expression);
//		listCandidat = getListCandidat(rs);
//		st.close();
//		return listCandidat;
//
//	}
	public synchronized List<BeanUser>  selectUser(String expression) throws SQLException {
		List<BeanUser> listUser = new ArrayList<BeanUser>();
		
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		listUser = getListUser(rs);
		st.close();
		return listUser;

	}

	// CREATE, DROP, INSERT and UPDATE
	public synchronized void update(String expression) throws SQLException {

		Statement st;

		st = conn.createStatement();

		int i = st.executeUpdate(expression);

		if (i == -1) {
			System.out.println("db error : " + expression);
		}

		st.close();
	}

	public static Vector dump(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
		int colmax = meta.getColumnCount();
		Object o = null;

		Vector data = new Vector();
		for (; rs.next();) {
			Vector row = new Vector();
			for (int i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1);
				row.addElement(o.toString());
			}
			data.addElement(row);
		}

		return data;
	}

//	public static List<Candidat> getListCandidat(ResultSet rs) throws SQLException {
//		List<Candidat> listCandidat = new ArrayList<Candidat>();
//		
//		Candidat candidat = null;
//		
//		for (; rs.next();) {
//			candidat=new Candidat();
//			candidat.setNom(rs.getString("nom"));
//			candidat.setPrenom(rs.getString("prenom"));
//			candidat.setCivilite(rs.getString("civilite"));
//			candidat.setDan(rs.getString("dan"));
//			candidat.setEmail(rs.getString("email"));
//			candidat.setNb_annee_exp(rs.getString("nb_annee_exp"));
//			candidat.setType_demande(rs.getString("type_demande"));
//			candidat.setDate_demande(rs.getString("date_demande"));
//			candidat.setPath(rs.getString("path"));
//			candidat.setId_candidat(rs.getString("id_candidat"));
//			listCandidat.add(candidat);
//		}
//					
//		return listCandidat;
//	}
	public static List<BeanUser> getListUser(ResultSet rs) throws SQLException {
		List<BeanUser> listUser = new ArrayList<BeanUser>();
		
		BeanUser user = null;
		
		for (; rs.next();) {
			user=new BeanUser();
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setCivilite(rs.getString("civilite"));
			user.setDan(rs.getDate("dan"));
			user.setEmail(rs.getString("email"));
			user.setNbAnneeExp(rs.getDouble("nb_annee_exp"));
			user.setNatureDemande(rs.getString("type_demande"));
			user.setDateDemande(rs.getDate("date_demande"));
			user.setPath(rs.getString("path"));
			user.setIdUser(rs.getInt("id_candidat"));

			listUser.add(user);
		}
					
		return listUser;
	}

	public Connection getConnexion() {
		return conn;
	}

	public void setConnexion(Connection connexion) {
		this.conn = connexion;
	}
	 
}
