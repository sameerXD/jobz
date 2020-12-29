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
 * Servlet implementation class ApplyJob
 */
@WebServlet("/ApplyJob")
public class ApplyJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Apply = "Apply";
		int cart= Integer.parseInt(request.getParameter("cart"));
		int CandidateId= Integer.parseInt(request.getParameter("CandidateId"));
		int CompanyId= Integer.parseInt(request.getParameter("CompanyId"));
		System.out.println("candidate id "+CandidateId);
		System.out.println("company id "+CompanyId);
		JobApplyDB jad = new  JobApplyDB();
		try {
			int rs = jad.InsertById(CompanyId, CandidateId);
		
			if(rs==1) {
				request.setAttribute("cart", cart);
				RequestDispatcher rd = request.getRequestDispatcher("CandidateCart");
				rd.forward(request, response);
			}
			
		    

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
