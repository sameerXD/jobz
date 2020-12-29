package jobzServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CompanyModule.CompanyQuerry;
import domain.CompanyInfo;

/**
 * Servlet implementation class CompanyLogin
 */
@WebServlet("/CompanyLogin")
public class CompanyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		CompanyQuerry cq = new CompanyQuerry();
		try {
			CompanyInfo company = cq.CompanyLogin(Email);
			if(company.getPassword().equals(Password)) {
				request.setAttribute("company", company);
				RequestDispatcher rd = request.getRequestDispatcher("CompanyInterface.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("company", "Invalid Email or Password");
				RequestDispatcher rd = request.getRequestDispatcher("CompanyLogin.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
