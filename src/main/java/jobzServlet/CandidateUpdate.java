package jobzServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CandidateInfo;
import module.findById;

/**
 * Servlet implementation class CandidateUpdate
 */
@WebServlet("/CandidateUpdate")
public class CandidateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("id to update "+uid);
		findById fbi = new findById();
		try {
			CandidateInfo candidate = fbi.findUser(uid);
			System.out.println("candidate name by id----"+ candidate.getFirstName());
			request.setAttribute("candidate", candidate);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateCandidate.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String firstName= request.getParameter("firstName");
		System.out.println(firstName);
	}

}
