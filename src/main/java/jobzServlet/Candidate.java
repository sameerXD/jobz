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

import domain.CandidateInfo;
import module.CandidateRegistration;

/**
 * Servlet implementation class Candidate
 */
@WebServlet("/Candidate")
public class Candidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Candidate() {
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
		String gender = request.getParameter("gender");
		String Tel = request.getParameter("Telephone");
		String Field = request.getParameter("Field");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		int Telephone = Integer.parseInt(Tel);
		
		
		System.out.println(firstName);
		System.out.println( lastName);
		System.out.println(gender);
		System.out.println( Telephone);
		System.out.println( Field);
		
		CandidateInfo candidate = new CandidateInfo(firstName, lastName, gender,  Field , Telephone, email,password);
		try {
			CandidateRegistration CR = new CandidateRegistration(candidate);
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", firstName);
		RequestDispatcher rd = request.getRequestDispatcher("CandidateLogin.jsp");
		rd.forward(request, response);
		
//		writer.println("<h1>Hello " + firstName+" you have been registerd!!!</h1>");
	//	writer.close();
	}

}
