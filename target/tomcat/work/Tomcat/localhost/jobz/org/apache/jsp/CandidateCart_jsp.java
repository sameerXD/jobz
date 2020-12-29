/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-12-28 19:32:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.jobzInfo;
import Jobz.JobzDB;
import domain.ApplyInfo;
import java.util.List;

public final class CandidateCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/styles.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("table, th, td {\r\n");
      out.write("  border: 1px solid black;\r\n");
      out.write("  border-collapse: collapse;\r\n");
      out.write("}\r\n");
      out.write("th, td {\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Cart</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"CI\">\r\n");
List<ApplyInfo> jobs =(List<ApplyInfo>) request.getAttribute("jobs"); 
      out.write('\r');
      out.write('\n');
JobzDB company =(JobzDB) request.getAttribute("company"); 
      out.write("\r\n");
      out.write("<h1>Applied Job</h1>\r\n");
      out.write("<table class = \"table-hover\" style=\"width:100%\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th>Name</th>\r\n");
      out.write("    <th>Field</th> \r\n");
      out.write("    <th>Text</th>\r\n");
      out.write("    <th>Date</th>\r\n");
      out.write("    <th>Email</th>\r\n");
      out.write("    <th>Telephone</th>\r\n");
      out.write("    <th>Result</th>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
for(ApplyInfo x: jobs){jobzInfo job = company.findById(x.getCompany());
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t<td>");
out.print(job.getName()); 
      out.write("</td>\r\n");
      out.write("    <td>");
out.print(job.getField()); 
      out.write("</td>\r\n");
      out.write("    <td>");
out.print(job.getText()); 
      out.write("</td>\r\n");
      out.write("\t<td>");
out.print(job.getDate()); 
      out.write("</td>\r\n");
      out.write("\t<td>");
out.print(job.getEmail()); 
      out.write("</td>\r\n");
      out.write("\t<td>");
out.print(job.getTelephone()); 
      out.write("</td>\r\n");
      out.write("\t<td>");
out.print(x.getResult()); 
      out.write("</td>\r\n");
      out.write("\t \r\n");
      out.write("    </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
 } 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
