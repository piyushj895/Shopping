<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/UpdateCategory" modelAttribute="categorymodel">

<table>
	<tr>
		<td colspan="2">Category Module</td>
	</tr>
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
	<tr>
		<td colspan="2">
			<center><input type="submit" value="UpdateCategory"/></center>
		</td>
	</tr>
</table>

</form:form>
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

</body>
</html>