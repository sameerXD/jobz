package jobzServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class DeleteJobz
 */
@WebServlet("/DeleteJobz")
public class DeleteJobz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJobz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("id"));
		String Email = request.getParameter("Email");
		System.out.println(id);
		JobzDB jd = new JobzDB();
		try {
			jd.DeleteById(id);
			System.out.println("Deleted");
			List<jobzInfo> jobs = jd.findAllJobs(Email);
			request.setAttribute("jobsList", jobs);
			RequestDispatcher rd = request.getRequestDispatcher("AllJobs.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
