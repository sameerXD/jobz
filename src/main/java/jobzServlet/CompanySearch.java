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
import module.findById;

/**
 * Servlet implementation class CompanySearch
 */
@WebServlet("/CompanySearch")
public class CompanySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = request.getParameter("CompanyName");
		String Field = request.getParameter("Field");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(Name);
		JobzDB jd = new JobzDB();
		try {
			List<jobzInfo> jobs = jd.FindByName(Name, Field);
			findById fb = new findById();
			CandidateInfo candidate = fb.findUser(id);
			request.setAttribute("user", candidate);
			request.setAttribute("jobs", jobs);
			RequestDispatcher rd = request.getRequestDispatcher("CandidateInterface.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
