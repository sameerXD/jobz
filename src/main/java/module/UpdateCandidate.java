package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import domain.CandidateInfo;

public class UpdateCandidate {
	
	 private Connection con = CandidateDB.getConnection();

	public void update(CandidateInfo candidate) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	   
	    	Statement stm = con.createStatement();
	        stm.execute("USE sameer");
		
		String sql = "UPDATE candidate_registration SET "
				+ "firstName=?,lastName=?,gender=?,Telephone=?,Field=?,Email=?,Password=? "+
				"WHERE id = ?";
		 
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1,candidate.getFirstName());
		statement.setString(2,candidate.getLastName() );
		statement.setString(3, candidate.getGender());
		statement.setInt(4, candidate.getTelephone());
		statement.setString(5, candidate.getField());
		statement.setString(6, candidate.getEmail());
		statement.setString(7, candidate.getPassword());
		statement.setInt(8, candidate.getId());
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("updated successfully!");
		}
    }

	
}
