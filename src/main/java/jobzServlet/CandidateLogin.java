package jobzServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jobz.JobzDB;
import domain.CandidateInfo;
import domain.jobzInfo;
import module.CLoginJdbc;

/**
 * Servlet implementation class CandidateLogin
 */
@WebServlet("/CandidateLogin")
public class CandidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		System.out.println(user +" "+ password);
		
		try {
			CLoginJdbc CL = new CLoginJdbc();
			CandidateInfo candidate = CL.CLogin(user);
			JobzDB jdb = new JobzDB();
			
			List<jobzInfo> jobs = jdb.findByField(candidate.getField());
			if (password.equals(candidate.getPassword())) {
				request.setAttribute("Alljobs", jobs);
				request.setAttribute("user", candidate);
				
				request.getSession().setAttribute("admin", candidate);  
				
				RequestDispatcher rd = request.getRequestDispatcher("CandidateInterface.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("invalid", "Invalid user try again!");
				request.getSession().setAttribute("admin", "");
				RequestDispatcher rd = request.getRequestDispatcher("CLogin.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
