package com.lti.dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
	
	public static  Connection connect(){
		try {
			
			Properties dbProps = new Properties();
			//dbProps.load(new FileReader("dev-db.properties"));
			dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
			
			Class.forName(dbProps.getProperty("drivername"));
			return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"), dbProps.getProperty("pass"));
			
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace(); 
			return null;
		}
	}

	
	/*public static  Connection connect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user ="hr";
			String pass = "1234";
			
			return DriverManager.getConnection(url, user, pass);
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); 
			return null;
		}
	}*/
}
