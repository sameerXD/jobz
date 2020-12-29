package domain;
import java.util.Date;

public class jobzInfo {
    private String Name;
    private String Field;
    private String Telephone;
    private String Email;
    private String Text;
    
    private int id ;
    private Date Date;
    
    public jobzInfo() {
    	
    }
    
    public jobzInfo(String Name, String Field, String Telephone, String Email ,String Text) {
    	this.Name = Name;
    	this.Field = Field;
    	this.Telephone = Telephone;
    	this.Email = Email;
    	this.Text = Text;
    	
    }
    
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
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
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
    
    
    
}
