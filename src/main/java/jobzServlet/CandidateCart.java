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

import JobApply.JobApplyDB;
import Jobz.JobzDB;
import domain.ApplyInfo;
import domain.jobzInfo;

/**
 * Servlet implementation class CandidateCart
 */
@WebServlet("/CandidateCart")
public class CandidateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("cart"));
		System.out.println("cart id " +  id);
		JobApplyDB ja = new JobApplyDB();
		JobzDB jd = new JobzDB();
		try {
			List<ApplyInfo> jobs = ja.findByCandidateId(id);
			jobzInfo company =null;
			for(ApplyInfo job:jobs) {
				company =jd.findById(job.getCompany());
				System.out.println(job.getResult());
				System.out.println(company.getEmail());
			}
			request.setAttribute("jobs", jobs);
			request.setAttribute("company", jd);
			RequestDispatcher rd = request.getRequestDispatcher("CandidateCart.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
