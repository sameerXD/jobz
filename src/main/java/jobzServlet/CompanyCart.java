package jobzServlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class CompanyCart
 */
@WebServlet("/CompanyCart")
public class CompanyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("cart"));
		System.out.println("Company cart id " +  id);
		JobApplyDB ja = new JobApplyDB();
		
		try {
			List<ApplyInfo> jobs = ja.findByCompanyId(id);
			if(jobs==null) {
				PrintWriter out = response.getWriter();  
				out.print("<h1>No one Applied!</h1>");
			}else {
			request.setAttribute("jobs", jobs);
			for(ApplyInfo x: jobs){
				System.out.println(x.getResult());
			}
			RequestDispatcher rd = request.getRequestDispatcher("CompanyCart.jsp");
			rd.forward(request, response);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
