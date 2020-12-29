package module;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import domain.CandidateInfo;

public class findById {
	private Connection con = CandidateDB.getConnection();
	
	public CandidateInfo findUser(int id) throws SQLException {
		
		Statement stm = con.createStatement();
		stm.execute("USE sameer");
		
		String sql = "SELECT * From candidate_registration where id = ?";
		PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, id);
		CandidateInfo candidate = null;
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			candidate = new CandidateInfo();
			candidate.setFirstName(rs.getString("firstName"));
			candidate.setLastName(rs.getString("lastName"));
			candidate.setGender(rs.getString("gender"));
			candidate.setEmail(rs.getString("Email"));
			candidate.setField(rs.getString("Field"));
			candidate.setPassword(rs.getString("Password"));
			candidate.setTelephone(rs.getInt("Telephone"));
			candidate.setId(rs.getInt("id"));
		}
		return candidate;
	}
}
