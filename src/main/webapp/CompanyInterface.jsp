<%@page import="domain.CompanyInfo"%>
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

<title>Welcome <%CompanyInfo company = (CompanyInfo)request.getAttribute("company"); out.print(company.getName());%></title>
</head>
<body>
<div class="head" id="topheader">
            <section class="header-section">
                <div class="center-div3">
                <h1 class="font-weight-bold "> MAKE A BETTER WORLD  !</h1>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-8 col-10 offset-lg-2 offset-md-2 col-1">
<h1>Hello <% out.print(company.getName());%> !</h1>
<form action ="CompanyLogin.jsp" method = "post">
<input type="submit" value="Log Out" />
</form>
<form action = "AddJob" method = "post">
<input type = "hidden" name = "Name" value =<%out.print(company.getName()); %> />
<input type = "hidden" name = "Telephone" value =<%out.print(company.getTelephone()); %> />
<input type = "hidden"  name = "Email" value =<%out.print(company.getEmail()); %> />
 <label for="Job Discription">Job Discription:</label>
      <input type="text" name="Text" size="100"><br> <br>
<label > Job in field:</label> <br> <br>
   <input type="checkbox" id="vehicle1" name="Field" value="Technical"> 
  <label for="vehicle1">Technical</label><br>
  <input type="checkbox" id="vehicle2" name="Field" value="NonTechnical">
  <label for="vehicle2"> Non-Technical </label><br>
  <input type="checkbox" id="vehicle3" name="Field" value="Dance">
  <label for="vehicle3"> Dance</label>
  <br>
  <h2><%Object add = request.getAttribute("add");if(add!=null){out.print(add);}; %></h2>
<input type = "submit" value = "Add job"/>
</form>
<br>
<br>


<form action = "Jobz" method = "post" >
<input type = "hidden" name = "Email" value = <%out.print(company.getEmail()); %>>
<input type = "submit" value = "All Jobs"/>
</form>
  </div>>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>