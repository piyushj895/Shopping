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
<%@ include file="/WEB-INF/views/header.jsp" %>
<c:if test="${not empty message}">
<div class="alert alert-danger">
${message}
</div>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
<table align="center">
	<tr>
	<td>Email:</td>
	<td><input type="text" name="username"></td>
	</tr>
	<tr>
	<td>Password:</td>
	<td><input type="password" name="password"/></td>
	</tr>
	<tr>
	<td colspan="2">
	<input name="submit" type="submit" value="Login"/></td>
	</tr>
		
</table>
</form>

</body>
</html>