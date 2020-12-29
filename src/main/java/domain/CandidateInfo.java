package domain;

public class CandidateInfo {
	private String firstName;
	private String lastName ;
	private String gender;
	private String field ;
	private int telephone ;
	private String email;
	private String password;
    private int id;
	public CandidateInfo() {
		
	}
	
    public CandidateInfo(String firstName, String lastName, String gender, String field , int telephone, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.field = field;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	
	}

    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id = id;
    }
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
