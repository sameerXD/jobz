<%@page import="domain.jobzInfo"%>
<%@page import="Jobz.JobzDB"%>
<%@page import="domain.ApplyInfo"%>
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
<title>Cart</title>
</head>
<body>
<div class="CI">
<%List<ApplyInfo> jobs =(List<ApplyInfo>) request.getAttribute("jobs"); %>
<%JobzDB company =(JobzDB) request.getAttribute("company"); %>
<h1>Applied Job</h1>
<table class = "table-hover" style="width:100%">
  <tr>
    <th>Name</th>
    <th>Field</th> 
    <th>Text</th>
    <th>Date</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Result</th>
  </tr>
  
  
<%for(ApplyInfo x: jobs){jobzInfo job = company.findById(x.getCompany());%>
	
	  <tr>
	<td><%out.print(job.getName()); %></td>
    <td><%out.print(job.getField()); %></td>
    <td><%out.print(job.getText()); %></td>
	<td><%out.print(job.getDate()); %></td>
	<td><%out.print(job.getEmail()); %></td>
	<td><%out.print(job.getTelephone()); %></td>
	<td><%out.print(x.getResult()); %></td>
	 
    </tr>
	
	
<% } %>
</table>
</div>
</body>
</html>