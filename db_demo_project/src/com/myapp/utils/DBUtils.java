package com.myapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "root@123";
	
	static Connection conn = null;
	static PreparedStatement pst = null;
	static Statement st = null;
	
	public static Connection getConnection(String dbName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL+dbName+"?useSSL=false", user, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) {
		//PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}
	
	
	public static Statement getSimpleStatement() {
		//Statement st = null;
		try {
			st = conn.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return st;
	}
	
	public static void closeConnections() {
		try {
			if(st != null)
				st.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
