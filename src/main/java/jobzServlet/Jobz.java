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
import domain.jobzInfo;

/**
 * Servlet implementation class Jobz
 */
@WebServlet("/Jobz")
public class Jobz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jobz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("Email");
		JobzDB jd = new JobzDB();
		try {
			List<jobzInfo> jobs = jd.findAllJobs(Email);
			System.out.println(jobs);
			request.setAttribute("jobsList", jobs);
			RequestDispatcher rd= request.getRequestDispatcher("AllJobs.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
