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

<%@ include file="/WEB-INF/views/header.jsp" %>
<form:form action="adminshowTheSupplier" modelAttribute="suppliermodel">
<center>
<table border="1">
<tr>
<td>Supplier ID</td>
<td><form:input path="sup_id"/></td>
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
<div class="table-responsive">          
  <table class="table table-condensed" border="1">
<tr bgcolor="cyan" >
<td>ID</td>
<td>Supplier Name</td>
<td>Supplier Email</td>
<td>Supplier Contact</td>
<td>Suppplier Address</td>
<td>Status</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr>
<td>${supplier.sup_id}</td>
<td>${supplier.sup_name}</td>
<td>${supplier.sup_email}</td>
<td>${supplier.sup_contact}</td>
<td>${supplier.sup_address}</td>
<td>
<a href="<c:url value="admindeleteSupplier${supplier.sup_id}"/> "#" class="btn btn-info" role="button"">Delete</a>/
<a href="<c:url value="adminupdateSupplier${supplier.sup_id}"/> "#" class="btn btn-info" role="button"">Update</a>
</td>
</c:forEach>

</table>
</div>
</center>
<%@ include file="footer.jsp" %>
</body>
</html>