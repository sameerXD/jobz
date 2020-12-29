<%@page import="domain.CandidateInfo"%>
<%@page import="domain.jobzInfo"%>
<%@page import="Jobz.JobzDB"%>
<%@page import="module.findById"%>
<%@page import="domain.ApplyInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<%List<ApplyInfo> jobs =(List<ApplyInfo>) request.getAttribute("jobs"); %>
<%findById candi  = new findById(); JobzDB jd = new JobzDB();%>

<table style="width:100%">
  <tr>
    <th>Candidate Name</th>
    <th>Field</th> 
    <th>Applied For</th>
    <th>Date</th>
    <th>Candidate Email</th>
    <th>Candidate Telephone</th>
    <th>Result</th>
  </tr>
  
  
<%for(ApplyInfo x: jobs){
	jobzInfo job = jd.findById(x.getCompany());
CandidateInfo candidate = candi.findUser(x.getCandidate());%>
	
	  <tr>
	<td><%out.print(candidate.getFirstName()); %></td>
    <td><%out.print(candidate.getField()); %></td>
    <td><%out.print(job.getText()); %></td>
	<td><%out.print(job.getDate()); %></td>
	<td><%out.print(candidate.getEmail()); %></td>
	<td><%out.print(candidate.getTelephone()); %></td>
	<td><form action = "PassOrFail" method = "post" >	
<input type = "hidden" name = "CandidateId" value = <%out.print(candidate.getId()); %>>
<input type = "hidden" name = "JobId" value = <%out.print(job.getId()); %>>
<input type = "submit" name = "result" value = "pass"/>
<form action = "PassOrFail" method = "post" >
	
<input type = "hidden" name = "CandidateId" value = <%out.print(candidate.getId()); %>>
<input type = "hidden" name = "JobId" value = <%out.print(job.getId()); %>>
<input type = "submit" name = "result" value = "fail"/></td>

	 
    </tr>
	
	
<% } %>
</body>
</html>