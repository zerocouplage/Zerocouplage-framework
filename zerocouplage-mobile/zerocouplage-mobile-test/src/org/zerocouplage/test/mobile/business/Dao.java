package org.zerocouplage.test.mobile.business;

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
import org.zerocouplage.test.mobile.bean.Candidat;


public class Dao {

	private static Connection conn = null;
	public  HashMap<String , String> map=new HashMap<String , String>();


	public Dao() throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");

		try {
			
			conn = DriverManager.getConnection("jdbc:hsqldb:file:/mnt/sdcard/Android/data/zerocouplage-mobile-test-1.2.0/youmarita",
					"sa", "");

//			update("CREATE TABLE candidat(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal,"
//					+ "type_demande varchar(100),path varchar(100),date_demande timestamp)");
//		update("INSERT INTO candidat VALUES(30,'test','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(32,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//	update("INSERT INTO candidat VALUES(33,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(34,'test3','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(35,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(36,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(37,'test','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(38,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//	update("INSERT INTO candidat VALUES(39,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(40,'test3','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(41,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//		update("INSERT INTO candidat VALUES(42,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
			
//			System.out.println("the value " +select("SELECT * FROM candidat"));
		} catch (Exception e) {
			System.out.println("Echec de connexion!! "+e.getMessage()+" "+e.getCause());
	
		}
	}

	public void shutdown() throws SQLException {

		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
		conn.close();

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
	public ResultSet query(String expression) throws SQLException {

		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		return rs;

	}
	

	
	public ResultSet Query(String requete) throws SQLException
	
	{
		Statement statement;
		
		statement = conn.createStatement();
		
		ResultSet resultat = statement.executeQuery(requete);
		return resultat;
		
	}
	
	public synchronized String query1(String expression) throws SQLException {
		String result=null;
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		//dump(rs);
		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
		int colmax = meta.getColumnCount();
		Object o = null;

		for (; rs.next();) {
			for (int i = 0; i < colmax; ++i) {
				o = rs.getObject(i + 1);
				result=o.toString();
			}
		}
		st.close();
		return result;

	}



//	// CREATE, DROP, INSERT and UPDATE
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
	public synchronized List<Candidat>  selectCandidat(String expression) throws SQLException {
		List<Candidat> listCandidat = new ArrayList<Candidat>();
		
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		listCandidat = getListCandidat(rs);
		st.close();
		return listCandidat;

	}
	public static List<Candidat> getListCandidat(ResultSet rs) throws SQLException {
		List<Candidat> listCandidat = new ArrayList<Candidat>();
		
//		
//		ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
//		int colmax = meta.getColumnCount();
//		Object o = null;
		Candidat candidat = null;
		
		for (; rs.next();) {
			candidat=new Candidat();
			candidat.setNom(rs.getString("nom"));
			candidat.setPrenom(rs.getString("prenom"));
			candidat.setCivilite(rs.getString("civilite"));
			candidat.setDan(rs.getString("dan"));
			candidat.setEmail(rs.getString("email"));
			candidat.setNb_annee_exp(rs.getString("nb_annee_exp"));
			candidat.setType_demande(rs.getString("type_demande"));
			candidat.setDate_demande(rs.getString("date_demande"));
			candidat.setPath(rs.getString("path"));
			candidat.setId_candidat(rs.getString("id_candidat"));
			listCandidat.add(candidat);
		}
					
		return listCandidat;
	}

	
//
//
	public Connection getConnexion() {
		return conn;
	}

	public void setConnexion(Connection connexion) {
		this.conn = connexion;
	}

//	 public static void main(String[] args) {
//
//	 Dao db = null;
//	
//	 try {
//	 db = new Dao();
//	 } catch (Exception ex1) {
//	 ex1.printStackTrace();	
//	 return;
//	 }
//	 try {
////		db.update("CREATE TABLE candidat(id_candidat int identity,nom varchar(30),prenom varchar(30),dan date,email varchar(100),civilite varchar(20),nb_annee_exp decimal,"
////					+ "type_demande varchar(100),path varchar(100),date_demande timestamp)");
////		db.update("INSERT INTO candidat VALUES(0,'test','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
////		db.update("INSERT INTO candidat VALUES(1,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
////		db.update("INSERT INTO candidat VALUES(2,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
////		db.update("INSERT INTO candidat VALUES(3,'test3','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
////		db.update("INSERT INTO candidat VALUES(4,'test1','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
////		db.update("INSERT INTO candidat VALUES(5,'test2','test','1991-12-12','sssa@gmail.com','madame',2,'Stage','D:\test.pdf','2013-05-10 20:45:47.612000')");
//
//		System.out.println("le contenu de la table"+db.select("SELECT * FROM candidat"));
//
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		
//
//	
////		 try {
////				db.update("CREATE TABLE administrateur(id_admin int identity,login varchar(15),pass varchar(15)");
////
////			db.update("INSERT INTO administrateur (login,pass)  VALUES ('admin','admin')");
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////}
//	
//	 }
 
}

