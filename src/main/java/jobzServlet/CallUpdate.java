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
import module.UpdateCandidate;

/**
 * Servlet implementation class CallUpdate
 */
@WebServlet("/CallUpdate")
public class CallUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String Email = request.getParameter("Email");
		String Field = request.getParameter("Field");
		int Telephone = Integer.parseInt(request.getParameter("Telephone"));
		String Password = request.getParameter("Password");
		String gender = request.getParameter("gender");
		int id = Integer.parseInt(request.getParameter("id"));
		
		CandidateInfo candidate = new CandidateInfo(firstName,lastName,gender,Field,Telephone,Email,Password);
		candidate.setId(id);
		UpdateCandidate UC= new UpdateCandidate(); 
		try {
			UC.update(candidate);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("candidate", candidate);
		request.setAttribute("update", "updated");
		RequestDispatcher rd = request.getRequestDispatcher("UpdateCandidate.jsp");
		rd.forward(request, response);
	}

}
