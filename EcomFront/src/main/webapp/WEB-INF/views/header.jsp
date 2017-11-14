<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
			<a class="navbar-brand" href="#">Shoppers Cart</a>
		</div>
		
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				
			
				<li><a href="/EcomFront">Home</a></li>
				
				
				
					<li><a href="userHome">ProductList</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="admincategory">Category</a></li>
					<li><a href="adminproduct">Product</a></li>
					<li><a href="adminsupplier">Supplier</a></li>
					</ul>
					</li>
					</sec:authorize>
				</ul>
				
			
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${pageContext.request.userPrincipal.name==null}">
				<li><a href="${pageContext.request.contextPath}/registration"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name!=null}">
						<li><a>Welcome:${pageContext.request.userPrincipal.name}</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>
				Logout</a></li>
				<li><a href="${pageContext.request.contextPath}/cart" class="glyphicon">&#xe116;</a></li>
				</c:if>
			</ul>
			
			
		</div>
	</div>
	</nav>
</body>
</html>