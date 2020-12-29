<%@page import="domain.CandidateInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Update profile</title>
</head>
<body>
<div class="head upd" style="text-align:center;" id="topheader">
<h1>Update your profile: <% 
CandidateInfo candidate = (CandidateInfo)request.getAttribute("candidate");
out.print(candidate.getFirstName());%></h1>
<br>
<h1><%Object update = request.getAttribute("update");
    if(update!=null){
	out.print(update);
	}
%></h1>
<form action="CallUpdate" method="post">
 	
     <label for="fname">First name:</label>
      <input type="text" name="firstName" value = <%out.print(candidate.getFirstName() );%> size="20" required><br> <br>
     <label for="lname">Last name:</label>
      <input type="text" name="lastName" value = <%out.print(candidate.getLastName() );%> size="20" required><br> <br>
      
       <input type="radio" id="male" name="gender" value="male" required>
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="female" required>
  <label for="female">Female</label>
  <input type="radio" id="other" name="gender" value="other" required>
  <label for="other">Other</label>
  <br> <br>
  
  <label for = "phone number">Tel. Number</label>
  <input type="text" name="Telephone" value = <%out.print(candidate.getTelephone() ); %> size="20" required><br>
  <br>
  
  <label > Job in field:</label> <br> <br>
   <input type="radio" name="Field" value="Technical" required> 
  <label >Technical</label><br>
  <input type="radio"  name="Field" value="NonTechnical" required>
  <label > Non-Technical </label><br>
  <input type="radio"  name="Field" value="Dance" required>
  <label > Dance</label>
  <br>
  <br>
  
  <label for="Email">Email Address:</label>
      <input type="text" name="Email" value = <%out.print(candidate.getEmail() );%> size="20" required><br> <br>
      
      <label for="Password">Password:</label>
      <input type="password" name="Password" value = <%out.print(candidate.getPassword());%> size="20" required><br> <br>
    <input type = "hidden" name="id" value= <%out.print(candidate.getId()); %>>
    <input type="submit" value="update" />
</form><br>
<button type="button" name="back" onclick="history.back()">Back</button><br>
</div>
</body>
</html>