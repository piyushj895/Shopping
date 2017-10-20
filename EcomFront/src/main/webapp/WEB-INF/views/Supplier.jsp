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

<title>Insert title here</title>
</head>
<body>
<form:form action="showTheSupplier" modelAttribute="suppliermodel">
<center>
<table border="1">
<tr>
<td>Supplier ID</td>
<td><form:input path="id"/></td>
</tr>
<tr>
<td>Supplier Name</td>
<td><form:input path="sup_name"/></td>
</tr>
<tr>
<td>Supplier Email</td>
<td><form:input path="sup_email"/></td>
</tr>
<tr>
<td>Supplier Contact</td>
<td><form:input path="sup_contact"/></td>
</tr>
<tr>
<td>Supplier Address</td>
<td><form:input path="sup_address"/></td>
</tr>
</table>
<input type="submit" value="Add">
</center>
</form:form>
<br>
<br>
<center>
<table>
<tr bgcolor="gray" >
<td>ID</td>
<td>Supplier Name</td>
<td>Supplier Email</td>
<td>Supplier Contact</td>
<td>Suppplier Address</td>
<td>Status</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr bgcolor="cyan">
<td>${supplier.id}</td>
<td>${supplier.sup_name}</td>
<td>${supplier.sup_email}</td>
<td>${supplier.sup_contact}</td>
<td>${supplier.sup_address}</td>
<td>
<a href="<c:url value="deleteSupplier/${supplier.id}"/> "#" class="btn btn-info" role="button"">Delete</a>/
<a href="<c:url value="updateSupplier/${supplier.id}"/> "#" class="btn btn-info" role="button"">Update</a>
</td>
</c:forEach>

</table>
</center>
</body>
</html>