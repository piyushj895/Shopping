<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/registration.css"/>" rel="stylesheet">
		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link rel="stylesheet" href="style.css">
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="container">

<c:if test="${nomatch.equals('nomatch') }">
<div class="alert alert-danger">
<strong>Password and confirm password does not match</strong>
</div>
</c:if>
			<div class="row main">
				<div class="main-login main-center">
				<h2>Sign up once</h2>
		
<form:form action="showTheRegistration" modelAttribute="registrationmodel">

<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Email</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
</div>
</div>
</div>

<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your First Name</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="first_name" id="first_name"  placeholder="Enter your First Name"/>
</div>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Last Name</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="last_name" id="last_name"  placeholder="Enter your Last Name"/>
</div>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Contact Info</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-phone fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="contact_info" id="contact_info"  placeholder="Enter your Contact Number"/>
</div>
</div>
</div>

<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Country</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-flag fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="location" id="location"  placeholder="Enter your Country Name"/>
</div>
</div>
</div>

<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Gender</label>
<div class="cols-sm-10">
<div class="input-group">

  <input type="radio" name="gender" value="male">Male <i class="fa fa-male" aria-hidden="true"></i>  
  <input type="radio" name="gender" value="female"> Female <i class="fa fa-female" aria-hidden="true"></i>
  <input type="radio" name="gender" value="other">  Other <i class="fa fa-genderless" aria-hidden="true"></i>
</div>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Your Address</label>
<div class="rows-sm-8">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-map-marker fa"></i></span>
<input type="text" class="form-control" name="address" id="address"  placeholder="Enter your Address"/>
</div>
</div>
</div>
<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Password</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-lock fa" aria-hidden="true"></i></span>
<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
</div>
</div>
</div>

<div class="form-group">
<label for="name" class="cols-sm-2 control-label">Confirm Password</label>
<div class="cols-sm-10">
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-lock fa" aria-hidden="true"></i></span>
<input type="password" class="form-control" name="cpassword" id="password"  placeholder="Confirm your Password"/>

</div>
</div>
</div>
<br>
<div class="form-group ">

<input  type="submit" id="submit" class="btn btn-primary btn-lg btn-block login-button" value="Register">
<input  type="reset" id="reset" class="btn btn-primary btn-lg btn-block login-button" value="Reset">
</div>
</div>
</div>
</form:form>
</div>
</div>
</div>
</body>
</html>