<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Register</title>
</head>
<body>
  <div class="head" id="topheader">
            <section class="header-section">
                <div class="center-div3">
                <h1 class="font-weight-bold "> REGISTER TO JOBZZ  !</h1>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-8 col-10 offset-lg-2 offset-md-2 col-1">

                <form action="Candidate" method="post">
                    <div class="form-group">
                        <label for="text">First name</label>
                        <input type="text" name="firstName" class="form-control" placeholder="Enter" id="text" required>
                      </div>
                      <div class="form-group">
                        <label for="text">Last name</label>
                        <input type="text" name="lastName" class="form-control" placeholder="Enter" id="text" required> 
                      </div>
                      <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <!-- <button class="btn btn-outline-secondary dropdown-toggle" name="gender" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gender</button>
                          <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Male</a>
                            <a class="dropdown-item" href="#">Female</a>
                            <a class="dropdown-item" href="#">Other</a>

                          </div> -->

       <input type="radio" id="male" name="gender" value="male" required>
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="female">
  <label for="female">Female</label>
  <input type="radio" id="other" name="gender" value="other">
  <label for="other">Other</label>
                        </div>

                      </div>
                      <div class="form-group">
                        <label for="number">phone No.</label>
                        <input type="number" class="form-control" name="Telephone" placeholder="Enter" id="number" required>
                      </div>
                      <div class="input-group mb-3">
                        <div class="input-group-prepend">
                          <!-- <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Field</button>
                          <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Technical</a>
                            <a class="dropdown-item" href="#">Non-Technical</a>
                            <a class="dropdown-item" href="#">Other</a>

                          </div> -->
                          <input type="checkbox" id="vehicle1" name="Field" value="Technical">
  <label for="vehicle1">Technical</label><br>
  <input type="checkbox" id="vehicle2" name="Field" value="NonTechnical">
  <label for="vehicle2"> Non-Technical </label><br>
  <input type="checkbox" id="vehicle3" name="Field" value="Dance">
  <label for="vehicle3"> Dance</label>
                        </div>
                       
                      </div>
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email address</label>
                      <input type="email" name="Email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Password</label>
                      <input type="password"  name="Password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="form-check">
                      <input type="checkbox" class="form-check-input" id="exampleCheck1">
                      <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <button type="submit" class="sam btn btn-primary">Register</button>
                  </form>
        </div>>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
 	

</body>
</html>