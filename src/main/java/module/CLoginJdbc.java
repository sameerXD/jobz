package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import domain.CandidateInfo;


public class CLoginJdbc {
	private Connection con = CandidateDB.getConnection();
    public CandidateInfo CLogin(String UN) throws ClassNotFoundException, SQLException {
    	System.out.println("-----------------password-----------------w");
    	String User = UN;
    		
		Statement stm = con.createStatement();
		stm.execute("USE sameer");
		
		String sql = "SELECT * From candidate_registration where Email = ?";
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1,User);
		ResultSet rs2 = ps.executeQuery();
		
		 if(rs2.next()) { // moving to the first row
			 
			  CandidateInfo candidate = new CandidateInfo();
			  candidate.setFirstName(rs2.getString("firstName"));
			  candidate.setLastName(rs2.getString("lastName"));
			  candidate.setEmail(rs2.getString("Email"));
			  candidate.setField(rs2.getString("Field"));
			  candidate.setGender(rs2.getString("gender"));
			  candidate.setPassword(rs2.getString("Password"));
			  candidate.setTelephone(rs2.getInt("Telephone"));
			  candidate.setId(rs2.getInt("id"));
			  return candidate;
		   } 
		
		
     return null;
    }
}
