<%@page import="java.util.ArrayList"%>
<%@page import="domain.jobzInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>All Jobs</title>
</head>
<body>
<div class="CI">
<%Object obj = request.getAttribute("jobsList");

ArrayList<jobzInfo>  jobs = (ArrayList<jobzInfo>) obj; %>
<table  class = "table-hover" style="width:100%;">
  <tr>
    <th>Name</th>
    <th>Field</th> 
    <th>Text</th>
    <th>Delete Job</th>
    <th>Applied</th>
  </tr>
<%for(jobzInfo job:jobs){%>
<tr>
    <td><%out.print(job.getName()); %></td>
    <td><%out.print(job.getField()); %></td>
    <td><%out.print(job.getText()); %></td>
    
    
    <td><form action="DeleteJobz" method="post">
    <input type = "hidden" name = "Email" value = <%out.print(job.getEmail());%>>
    <input type = "hidden" name = "id" value = <%out.print(job.getId());%>>
    <input type = "submit" name = "Delete" value = "Delete"></form></td>
    
    <td><form action = "CompanyCart" method = "post" >
<input type = "hidden" name = "cart" value = <%out.print(job.getId()); %>>
<input type = "submit" value = "Cart"/>
</form></td>
    
  </tr>

<% }%>
<button type="button" name="back" onclick="history.back()">Back</button>

</form>
</table>
</div>
</body>
</html>