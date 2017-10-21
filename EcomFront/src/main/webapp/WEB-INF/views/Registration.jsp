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
<form:form action="showTheRegistration" modelAttribute="registrationmodel">
<center>
<table border="1">
<tr>
<td>Registration Email</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>First Name</td>
<td><form:input path="first_name"/></td>
</tr>
<tr>
<td>Last Name</td>
<td><form:input path="last_name"/></td>
</tr>
<tr>
<td>Contact Number</td>
<td><form:input path="contact_info"/></td>
</tr>
<tr>
<td>Country</td>
<td><form:input path="location"/></td>
</tr>
<tr>
<td>Gender</td>
<td><form:select path="gender">
 <form:option value="Male"/>
<form:option value="Female"/>
</form:select></td></tr>
<tr>
<td>Address</td>
<td> <textarea rows="8" cols="21" name="address"></textarea></td>
</tr>
<tr>
<td>Password</td>
<td><form:password path="password" /></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><form:password path="password" /></td>
</tr>
</table>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</center>
</form:form>


</body>
</html>