package Jobz;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import CompanyModule.CompanyDB;
import domain.CompanyInfo;
import domain.jobzInfo;

public class JobzDB {
	private Connection con =  (Connection) CompanyDB.getConnection();
	
	public void AddJob(jobzInfo Job) throws SQLException {
		Statement stm = con.createStatement();
    	stm.execute("Use Sameer");
    	
    	String sql = "INSERT INTO jobz (Name,Field,Telephone,Email,Text) VALUES (?,?,?,?,?)";
    	
    	PreparedStatement statement =(PreparedStatement)con.prepareStatement(sql);
    	statement.setString(1, Job.getName());
    	statement.setString(2, Job.getField());
    	statement.setString(3, Job.getTelephone());
    	statement.setString(4, Job.getEmail());
    	statement.setString(5, Job.getText());
    	
        int rs = statement.executeUpdate();
    	
    	if(rs==1) {
    		System.out.println("new job added!!");
    		
    	}
    	else {
    		System.out.println("Error");
    	}
	}
	
	public List<jobzInfo> findAllJobs(String Email) throws SQLException{
		Statement stm = con.createStatement();
    	stm.execute("Use Sameer");
		String sql = "SELECT * FROM jobz WHERE Email =?";
		
		List<jobzInfo> jobs = null;
		System.out.println(Email);
		PreparedStatement pdst =(PreparedStatement) con.prepareStatement(sql);
		pdst.setString(1, Email);
		ResultSet rs = pdst.executeQuery();
		
		while(rs.next()){
			if(jobs == null) {
				jobs = new ArrayList<>();
			}
			System.out.println(rs.getString("Name")+rs.getString("Email") );
			System.out.println("jobz database"+rs.getInt("id") );
			jobzInfo job = new jobzInfo();
			job.setName(rs.getString("Name"));
			job.setEmail(rs.getString("Email"));
			job.setField(rs.getString("Field"));
			job.setTelephone(rs.getString("Telephone"));
			job.setText(rs.getString("text"));
			job.setTelephone(rs.getString("Telephone"));
			job.setDate(rs.getDate("Date"));
			job.setId(rs.getInt("id"));
			
			jobs.add(job);
		}
		return jobs;
	}
	
  public void DeleteById(int id) throws SQLException {
	  Statement stm = con.createStatement();
  	   stm.execute("Use Sameer");
		String sql = "DELETE FROM jobz WHERE id = ?";
		PreparedStatement pd =(PreparedStatement) con.prepareStatement(sql);
		pd.setInt(1,id);
		pd.executeUpdate();
		
  }
  
  
  public List<jobzInfo>  FindByName(String Name, String Field) throws SQLException {
  	
  	
  	Statement stm = con.createStatement();
  	stm.execute("Use Sameer");
  	
  	 
  	 
  	 String sql ="SELECT * FROM jobz WHERE Name = ? AND Field = ?";
  	 PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
  	 ps.setString(1, Name);
  	ps.setString(2, Field);
  	 ResultSet rs = ps.executeQuery();
  	List<jobzInfo> jobs = null;
  	 while(rs.next()) {
  		 if(jobs==null) {
  			 jobs = new ArrayList<>();
  		 }
  		 jobzInfo job = new jobzInfo();
  		job = new jobzInfo();
  		job.setName(rs.getString("Name"));
  		job.setEmail(rs.getString("Email"));
  		job.setText(rs.getString("Text"));
  		job.setField(Field);
  		job.setTelephone(rs.getString("Telephone"));
  		job.setId(rs.getInt("id"));
  		job.setDate(rs.getDate("Date"));
  		 jobs.add(job);
  	 }
  	 
  	
  	return jobs ;
  	
  }
  
  public List<jobzInfo> findByField(String Field) throws SQLException {
	  Statement stm = con.createStatement();
	  	stm.execute("Use Sameer");
	  	
	  	
	  
	  List<jobzInfo> jobs = null;
	  
	  String sql ="SELECT * FROM jobz WHERE Field = ?";
	  	 PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
	  	 ps.setString(1, Field);
	  	ResultSet rs = ps.executeQuery();
	  	
	  	while(rs.next()) {
	  		 if(jobs==null) {
	  			 jobs = new ArrayList<>();
	  		 }
	  		 jobzInfo job = new jobzInfo();
	  		job = new jobzInfo();
	  		job.setName(rs.getString("Name"));
	  		job.setEmail(rs.getString("Email"));
	  		job.setText(rs.getString("Text"));
	  		job.setField(Field);
	  		job.setTelephone(rs.getString("Telephone"));
	  		job.setId(rs.getInt("id"));
	  		job.setDate(rs.getDate("Date"));
	  		 jobs.add(job);
	  	 }
	  	
	  	
	  return jobs;
  }
  
  public jobzInfo findById(int id) throws SQLException {
	  jobzInfo job = new jobzInfo();
	  Statement stm = con.createStatement();
	  	stm.execute("Use Sameer");
	  String sql = "SELECT * FROM jobz WHERE id = ?";
	  
	  PreparedStatement pd = (PreparedStatement)con.prepareStatement(sql);
	  pd.setInt(1, id);
	  ResultSet rs = pd.executeQuery();
	  
	  while(rs.next()) {
		  job = new jobzInfo();
	  		job.setName(rs.getString("Name"));
	  		job.setEmail(rs.getString("Email"));
	  		job.setText(rs.getString("Text"));
	  		job.setField(rs.getString("Field"));
	  		job.setTelephone(rs.getString("Telephone"));
	  		job.setId(rs.getInt("id"));
	  		job.setDate(rs.getDate("Date"));
	  }
	  
	  return job;
  }
	
}
