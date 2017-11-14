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
<%@ include file="header.jsp" %>
<form:form action="${pageContext.request.contextPath}/adminUpdateCategory" modelAttribute="categorymodel">
<center>
<table border="1">
	<tr>
		<td>Category ID</td>
		
		<td><form:input path="cat_id"/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		
		<td><form:input path="cat_name"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		
		<td><form:input path="cat_desc"/></td>
	</tr>
	</table>
			<center><input type="submit" value="Add"/></center>
	
</center>
</form:form>
<br>
<center>
<div class="table-responsive">          
  <table class="table table-condensed" border="1">
    <thead>
      <tr bgcolor="cyan">
        <th>Category ID</th>
        <th>Category Name</th>
        <th>Category Description</th>
        <th>Status</th>
      </tr>
  <c:forEach items="${categoryList}" var="category">
<tr>
<td>${category.cat_id}</td>
<td>${category.cat_name}</td>
<td>${category.cat_desc}</td>
<td>

<a href="<c:url value="admindeleteCategory/${category.cat_id}"/> "#" class="btn btn-info" role="button"">DELETE</a>/
<a href="<c:url value="adminupdateCategory${category.cat_id}"/>"#" class="btn btn-info" role="button"">UPDATE</a>

</td>
</tr>
</c:forEach>
</thead>
</table>
</div>
</center>
<%@ include file="footer.jsp" %>
</body>
</html>