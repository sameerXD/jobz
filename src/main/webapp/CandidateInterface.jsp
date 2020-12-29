<%@page import="domain.jobzInfo"%>
<%@page import="java.util.List"%>
<%@page import="domain.CandidateInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
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
<title>Welcome </title>
</head>
<body>
  <div class="CI" >
<h1>Welcome <% CandidateInfo user = (CandidateInfo)request.getAttribute("user");
out.print(user.getFirstName());%></h1>
<div id = "sam">
<form action="CandidateCart" method= "post">
<input type= "hidden" name = "cart" value= <%out.print(user.getId()); %>>
 <input type = "submit"  value = "View Cart">
</form>		

 <% int uid= user.getId();%>
<form action ="CandidateUpdate?uid=<%= uid %>" method = "post">
<input type="submit" value="update profile"/>
</form>

<form action ="CLogin.jsp" method = "post">
<input type="submit" value="Log Out" />
</form>
</div>


<form action ="CompanySearch" method = "post">
 <input type="text" name="CompanyName" size="80"><br> <br>
 <input type="hidden" name = "Field" value=<%out.print(user.getField()); %>>
 <input type="hidden" name = "id" value=<%out.print(user.getId()); %>>
<input type="submit" value="Search" />
</form>
<br> <br>
<%List<jobzInfo> jobs = (List<jobzInfo>)request.getAttribute("jobs"); %>
<%if (jobs!=null){%>
<table class= "table table-hover table-responsive" style="width:100%">
  <tr>
    <th>Name</th>
    <th>Field</th> 
    <th>Text</th>
    <th>Date</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Apply</th>
  </tr>
<%	for(jobzInfo job :jobs){%>
    <tr>
	<td><%out.print(job.getName()); %></td>
    <td><%out.print(job.getField()); %></td>
    <td><%out.print(job.getText()); %></td>
	<td><%out.print(job.getDate()); %></td>
	<td><%out.print(job.getEmail()); %></td>
	<td><%out.print(job.getTelephone()); %></td>
	 <td><form action="ApplyJob" method="post">
	  <input type= "hidden" name = "cart" value= <%out.print(user.getId()); %>>
    <input type = "hidden" name = "CandidateId" value = <%out.print(user.getId());%>>
    <input type = "hidden" name = "CompanyId" value = <%out.print(job.getId());%>>
    <input type = "submit"  value = "Apply"></form></td>
    </tr>
		<%}
} %>
</table>
<br>

<%List<jobzInfo> Alljobs = (List<jobzInfo>)request.getAttribute("Alljobs"); %>
<%if (Alljobs!=null){%>
<table class= "table table-hover table-responsive" style="width:100%">
  <tr>
    <th>Name</th>
    <th>Field</th> 
    <th>Text</th>
    <th>Date</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Apply</th>
  </tr>
<%	for(jobzInfo job :Alljobs){%>
    <tr>
	<td><%out.print(job.getName()); %></td>
    <td><%out.print(job.getField()); %></td>
    <td><%out.print(job.getText()); %></td>
	<td><%out.print(job.getDate()); %></td>
	<td><%out.print(job.getEmail()); %></td>
	<td><%out.print(job.getTelephone()); %></td>
	 <td><form action="ApplyJob" method="post">
	 <input type= "hidden" name = "cart" value= <%out.print(user.getId()); %>>
    <input type = "hidden" name = "CandidateId" value = <%out.print(user.getId());%>>
    <input type = "hidden" name = "CompanyId" value = <%out.print(job.getId());%>>
    <input type = "submit" name = "Delete" value = "Apply"></form></td>
    </tr>
		<%}
} %>
</table>

</div>
</body>
</html>