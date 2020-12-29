package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CandidateDB {
 	
  	private static final String url = "jdbc:mysql://localhost:3306/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  	private static final String user = "root";
  	private static final String key = "";
  	
  	private static Connection connection = null;
  	
  	public static Connection getConnection() {
  	
  		if(connection == null) {
  	   try{Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,user,key);
  		}catch(Exception ex) {
  			System.out.println(ex.getMessage());
  		}
  	   }
  		
		return connection;
		
  }

}