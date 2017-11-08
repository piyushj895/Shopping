<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<style>
hr {
	border: none;
	height: 1px;
	/* Set the hr color */
	color: #333; /* old IE */
	background-color: #333; /* Modern Browsers */
}

tab5
{
padding-left: 27em;
}
tab4 {
	padding-left: 67em;
}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>

<div class="container">
<h1>Your Cart</h1>
</div>

<div class="container">
  	<div class="row main">
  	<div class="container-fluid">
  	<div class="table-responsive">
<table class="table table-hover " cellspacing="2" align="center">
<thead bgcolor="#222">
<tr>
	<th><font color="#FFFFFF">Product Name</font></th>
	<th><font color="#FFFFFF">Quantity</font></th>
	<th><font color="#FFFFFF">Price</font></th>
	<th><font color="#FFFFFF">Picture</font></th>
	<th><font color="#FFFFFF">Total</font></th>
	<th><font color="#FFFFFF">Remove</font></th>
</tr>
 </thead>

<c:forEach var="cartlist" items="${cartlist}">
<tr>
<td>${cartlist.prod_name}</td>
<td>${cartlist.quantity}</td>
<td>${cartlist.price}</td>

<td>
<img src="<c:url value="/resources/images/${cartlist.prod_id}.jpg"/>" width="100px" height="100px"/>

</td>
<td>${cartlist.quantity*cartlist.price}
<td><a href="deleteCart${cartlist.cartItemId}" class="btn btn-info" role="button">Delete</a></td>

<c:set var="gtot" value="${cartlist.quantity*cartlist.price + gtot}"></c:set>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</div>
<h2>Total
<tab5><c:out value="${gtot}"></c:out></tab5>
</h2>
</h2>
<hr
						style="height: 1px; border: none; color: #333; background-color: #333;" />
					&nbsp;<a class="btn btn-primary navbar-inverse btn-lg"
						href="${pageContext.request.contextPath}/userHome">Continue
						Shopping</a>

					<c:if test="${not empty cartlist}">
						<form action="${pageContext.request.contextPath}/checkout"
							method="post">
							<input type="hidden" value="${gtot}" name="gtot" />
							<tab4>
							<input class="btn btn-primary navbar-inverse btn-lg"
								type="submit" value="Checkout"></tab4>
						</form>
					</c:if>
<%@ include file="footer.jsp" %>
</body>
</html>
