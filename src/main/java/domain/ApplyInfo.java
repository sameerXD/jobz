package domain;

public class ApplyInfo {
   private int Company;
   private int Candidate;
   private String Result;
   public ApplyInfo() {
	   
   }
   
   public ApplyInfo(int Company , int Candidate,String Result) {
	   this.Company = Company;
	   this.Candidate = Candidate;
	   this.Result = Result;
   }

public String getResult() {
	return Result;
}

public void setResult(String result) {
	Result = result;
}

public int getCompany() {
	return Company;
}

public void setCompany(int company) {
	Company = company;
}

public int getCandidate() {
	return Candidate;
}

public void setCandidate(int candidate) {
	Candidate = candidate;
}
   
}
