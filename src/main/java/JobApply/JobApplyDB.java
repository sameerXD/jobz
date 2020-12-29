package JobApply;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import CompanyModule.CompanyDB;
import domain.ApplyInfo;
import domain.jobzInfo;

public class JobApplyDB {
	private Connection con =  (Connection) CompanyDB.getConnection();
	
	public int InsertById(int CompanyId,int CandidateId) throws SQLException {
		Statement stm = con.createStatement();
        stm.execute("USE sameer");
        
        String sql = "INSERT INTO jobapply (Company,Candidate, Result) VALUES (?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setInt(1, CompanyId);
        statement.setInt(2, CandidateId);
        statement.setString(3, "Pending");
        int rs = statement.executeUpdate();
        if(rs==1) {System.out.println("Applied successfully");}else {System.out.println("Error");}
        return rs;
	}
	
	public List<ApplyInfo> findByCandidateId(int id) throws SQLException{
		Statement stm = con.createStatement();
        stm.execute("USE sameer");
        List<ApplyInfo> jobs = null;
  	  
  	  String sql ="SELECT DISTINCT  * FROM jobApply WHERE Candidate = ?";
  	  	 PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
  	  	 ps.setInt(1, id);
  	  	ResultSet rs = ps.executeQuery();
  	  	
  	  	while(rs.next()) {
  	  		 if(jobs==null) {
  	  			 jobs = new ArrayList<>();
  	  		 }
  	  			 ApplyInfo job = new ApplyInfo();
  	  			 job.setCandidate(id);
  	  			 job.setCompany(rs.getInt("Company"));
  	  			 job.setResult(rs.getString("Result"));
  	  			 jobs.add(job);
  	  		 
  	  		 
  	  	 }
  	  	
  	  	
  	  return jobs;
	}
	
	public List<ApplyInfo> findByCompanyId(int id) throws SQLException{
		Statement stm = con.createStatement();
        stm.execute("USE sameer");
        List<ApplyInfo> Candidates = null;
  	  
  	  String sql ="SELECT DISTINCT  * FROM jobApply WHERE Company = ?";
  	  	 PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
  	  	 ps.setInt(1, id);
  	  	ResultSet rs = ps.executeQuery();
  	  	
  	  	while(rs.next()) {
  	  		 if(Candidates==null) {
  	  			Candidates = new ArrayList<>();
  	  		 }
  	  			 ApplyInfo job = new ApplyInfo();
  	  			 job.setCandidate(rs.getInt("Candidate"));
  	  			 job.setCompany(rs.getInt("Company"));
  	  			 job.setResult(rs.getString("Result"));
  	  			Candidates.add(job);
  	  		 
  	  		 
  	  	 }
  	  	
  	  	
  	  return Candidates;
	}
	public void updateByIds(int candidateId, int compnayId) throws SQLException {
		Statement stm = con.createStatement();
        stm.execute("USE sameer");
        
        String sql = "UPDATE jobapply SET "
				+ "Result =? "+
				"WHERE Company = ? AND Candidate = ?";
        
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1,"PASS");
		statement.setInt(2,compnayId);
		statement.setInt(3, candidateId);
		
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("updated successfully!");
		}
    }
	
	public void deleteByIds(int candidateId, int compnayId) throws SQLException {
		  Statement stm = con.createStatement();
	  	   stm.execute("Use Sameer");
			String sql = "DELETE FROM jobapply WHERE Company = ? AND Candidate = ?";
			PreparedStatement pd =(PreparedStatement) con.prepareStatement(sql);
			pd.setInt(1,compnayId);
			pd.setInt(2,candidateId);
			int rowsDeleted=pd.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Deleted successfully!");
			}
	}
	}

