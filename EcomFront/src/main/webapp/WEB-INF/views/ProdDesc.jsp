

<%@ page language="java" import="niit.com.model.Product" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<table border="1">

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
		<td>Price:Rs.${product.price}</td>
	</tr>
	</table>
	<form action="${pageContext.request.contextPath}/addToCart" method="post">
						<input type="hidden" value="${product.prod_id}" name="pId" />
						<input type="hidden" value="${product.price}" name="pPrice" />
						<input type="hidden" value="${product.prod_name}" name="name" />
						<br>
						<label class="control-label col-sm-2">Quantity</label>
						<input type="number" class="form-control" name="quant" required />
						
						<br>
						
							<input class="btn btn-primary navbar-inverse" type="submit" value="Add to cart">
							</form>
						
							<br>
							<button onclick="goBack()">Go Back</button>
						<script>
				function goBack()
				{
    			window.history.back();
				}
</script>
							 
</body>
</html>