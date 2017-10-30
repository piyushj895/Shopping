<%@ page language="java" import="niit.com.model.Product" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

<tr>
		<td rowspan="5">
		
			<img src="<c:url value="/resources/images/${product.prod_id}.jpg"/>"width="500" height="500"/>
		
		</td>
	</tr>
	<tr>
		<td>Product ID :${product.prod_id}</td>
	</tr>
	<tr>
		<td>Product Name:${product.prod_name}</td>
	</tr>
	<tr>
		<td>Product Desc:${product.prod_desc}</td>
	</tr>
	<tr>
		<td>Price:${product.price}</td>
	</tr>
	</table>
</body>
</html>