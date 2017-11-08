<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="container">                                                                                      
  <div class="table-responsive">          
  <table class="table">
    <thead>
    <tr>
	<th>Product Name</th>
	<th>Price</th>
	<th>Category</th>
	<th>Stock</th>
	<th>Photo</th>
</tr>
<c:forEach items="${productList}" var="product">
	<tr>
		<th>${product.prod_name}</th>
		<th>${product.price}</th>
		<th>${product.cat_id}</th>
		<th>${product.stock}</th>
		<th>
		<a href="prod_desc/${product.prod_id}">
		<img src="<c:url value="/resources/images/${product.prod_id}.jpg"/>" width="100px" height="100px"/>
		</a>
		</th>
		
	</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>