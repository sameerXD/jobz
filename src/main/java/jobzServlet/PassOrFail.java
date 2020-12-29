package jobzServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JobApply.JobApplyDB;

/**
 * Servlet implementation class PassOrFail
 */
@WebServlet("/PassOrFail")
public class PassOrFail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassOrFail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int CandidateId = Integer.parseInt(request.getParameter("CandidateId"));
		int JobId = Integer.parseInt(request.getParameter("JobId"));
		String result = request.getParameter("result");
		System.out.println("candidate id " + CandidateId + "JobId " + JobId +"result "+ result);
		  response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");

	        PrintWriter out = response.getWriter();  
		if(result.equals("pass")) {
			//update
			JobApplyDB ja = new JobApplyDB();
			try {
				ja.updateByIds(CandidateId, JobId);
				out.println("<h1>Updated</h1>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//delete
			JobApplyDB ja = new JobApplyDB();
	        
			try {
				ja.deleteByIds(CandidateId, JobId);
				out.println("<h1>Deleted</h1>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
