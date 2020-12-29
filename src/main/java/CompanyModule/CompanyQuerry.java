package CompanyModule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.CompanyInfo;

public class CompanyQuerry {
    private Connection con =  (Connection) CompanyDB.getConnection();
    
   
    public void RegisterCompany(CompanyInfo company) throws SQLException {
    	Statement stm = con.createStatement();
    	stm.execute("Use Sameer");
    	
    	String sql = "INSERT INTO company_registration (Name,Telephone,Email,Password) VALUES (?,?,?,?)";
    	
    	PreparedStatement statement =(PreparedStatement)con.prepareStatement(sql);
    	statement.setString(1, company.getName());
    	statement.setString(2, company.getTelephone());
    	statement.setString(3, company.getEmail());
    	statement.setString(4, company.getPassword());
    	
    	int rs = statement.executeUpdate();
    	
    	if(rs==1) {
    		System.out.println("new Company registerd");
    	}
    	else {
    		System.out.println("Error");
    	}
    }
    
    public CompanyInfo  CompanyLogin(String Email) throws SQLException {
    	Statement stm = con.createStatement();
    	stm.execute("Use Sameer");
    	
    	 CompanyInfo company = null;
    	 
    	 String sql ="SELECT * FROM company_registration WHERE Email = ?";
    	 PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
    	 ps.setString(1, Email);
    	 ResultSet rs = ps.executeQuery();
    	 
    	 if(rs.next()) {
    		 company = new CompanyInfo();
    		 company.setName(rs.getString("Name"));
    		 company.setEmail(Email);
    		 company.setPassword(rs.getString("Password"));
    		 company.setTelephone(rs.getString("Telephone"));
    		 company.setId(rs.getInt("id"));
    	 }
    	 
    	
    	return company ;
    	
    }

}
