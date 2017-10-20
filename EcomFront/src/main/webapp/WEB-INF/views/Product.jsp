<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Display Product</title>
</head>
<body>
<form:form action="showTheProduct" modelAttribute="productmodel">
<center>
<table border="1">

<tr>
<td>Product ID</td>
<td><form:input path="prod_id"/></td>
</tr>
<tr>
<td>Product Name</td>
<td><form:input path="prod_name"/></td>
</tr>
<tr>
<td>Product Description</td>
<td><form:input path="prod_desc"/></td>
</tr>
</table>
<input type="submit" value="Add"/>

</center>
</form:form>
<br>
<br>
<center>
<div class="table-responsive">          
  <table class="table table-striped">
    <thead>
      <tr bgcolor="black">
        <th><h4 style="color:white;">Product ID</h4></th>
        <th><h4 style="color:white;">Product Name</h4></th>
        <th><h4 style="color:white;">Product Description</h4></th>
        <th><h4 style="color:white;">Status</h4></th>
      </tr>
      </thead>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.prod_id}</td>
<td>${product.prod_name}</td>
<td>${product.prod_desc}</td>
<td>
<a href="<c:url value="deleteProduct/${product.prod_id}"/> "#" class="btn btn-info" role="button"">Delete</a>/
<a href="<c:url value="updateProduct/${product.prod_id}"/> "#" class="btn btn-info" role="button"">Update</a>
</td>
</c:forEach>
</table>
</div>
</center>
</body>
</html>