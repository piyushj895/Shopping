
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<%@ include file="/WEB-INF/views/header.jsp" %>  
<h2>Welcome To Online Shopping</h2>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
 
    <div class="item active">
    
      <img src="<c:url value="/resources/books.png"/>" alt="Books" width="800" height="300" style="margin:auto">
    </div>
    <div class="item">
      <img src="<c:url value="/resources/movie.jpg"/>" alt="Movies" width="800" height="300" style="margin:auto">
    </div>

    <div class="item">
      <img src="<c:url value="/resources/shoes.JPG"/>" alt="Shoes" width="800" height="100" style="margin:auto">
    </div>
    </div>
 
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
  
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
