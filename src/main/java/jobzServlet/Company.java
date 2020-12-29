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
 * Servlet implementation class Company
 */
@WebServlet("/Company")
public class Company extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name = request.getParameter("Name");
		String Telephone = request.getParameter("Telephone");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		System.out.println(Name+Telephone+Email+Password);
		CompanyInfo company = new CompanyInfo(Name,Telephone,Email,Password);
		
		CompanyQuerry cq = new CompanyQuerry();
		
		try {
			cq.RegisterCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("company",Name);
		RequestDispatcher rd = request.getRequestDispatcher("CompanyLogin.jsp");
		rd.forward(request, response);
	}
	

}
