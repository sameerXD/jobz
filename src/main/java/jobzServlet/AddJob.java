package jobzServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompanyModule.CompanyQuerry;
import Jobz.JobzDB;
import domain.CompanyInfo;
import domain.jobzInfo;

/**
 * Servlet implementation class AddJob
 */
@WebServlet("/AddJob")
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = request.getParameter("Name");
		String Telephone = request.getParameter("Telephone");
		String Email = request.getParameter("Email");
		String Text = request.getParameter("Text");
		String Field = request.getParameter("Field");
		
		System.out.println(Name+ Telephone + Email + Text+ Field);
		
		jobzInfo Job = new jobzInfo(Name, Field, Telephone, Email ,Text);
		
		JobzDB jd = new JobzDB();
		try {
			jd.AddJob(Job);
			CompanyQuerry cq = new CompanyQuerry();
    		CompanyInfo company =cq.CompanyLogin(Email);
    		request.setAttribute("add", "Job Added");
    		request.setAttribute("company", company);
    		RequestDispatcher rd = request.getRequestDispatcher("CompanyInterface.jsp");
    		rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
