package model;

import java.sql.Connection;

import java.sql.DriverManager;

import javax.servlet.http.HttpSession;

public class Database {
	private static String dburl="jdbc:mysql://sql204.epizy.com:3306/epiz_33989373_food";
	private static String dbuser="sql204.epizy.com";
	private static String dbpass="rskpTNTZK4";
	public static Connection connexion=null;
	
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver OK");
			connexion=DriverManager.getConnection(dburl,dbuser,dbpass);
		
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("PROBLEME MYSQL DRIVER");
        }
	}
}
