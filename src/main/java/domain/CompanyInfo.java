package domain;

public class CompanyInfo {
    private String Name;
    private String Telephone;
    private String Email;
    private String Password;
    private int id;
    public CompanyInfo() {
    }
    
    public CompanyInfo(String Name, String Telephone, String Email,String Password) {
    	this.Name = Name;
    	this.Telephone = Telephone;
    	this.Email = Email;
    	this.Password = Password;
    }
    
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
    
    
    
}
