package org.zerocouplage.application.desktop.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

public class BD {
	private static Connection conn = null;
	public  HashMap<String , String> map=new HashMap<String , String>();


	public BD() throws Exception {
		try {
			Class.forName("org.hsqldb.jdbcDriver");

			conn = DriverManager.getConnection("jdbc:hsqldb:file:recrutement",
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
		String result=null;
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
				result=o.toString();
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
	public Connection getConnexion() {
		return conn;
	}

	public void setConnexion(Connection connexion) {
		this.conn = connexion;
	}
	 
}
