<!DOCTYPE html>
<html lang="en">
<head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
    
    <c:forEach var="category" items="${categoryList}">
        
      <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
      <ul class="dropdown-menu">
        
      <c:forEach var="product" items="${productList}">
      <c:if test="${product.category_id == category.id}">
      	<li><a href="#">${product.name}</a></li>
      </c:if> 
    <%--     <li><a href="#">${product.name}</a></li>    --%>     
      </c:forEach>
        
        <!-- 
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Referigerator</a></li> 
        -->
        
        </ul>
      </li>
      
      </c:forEach>
      
      <!--comment hardcoded value  -->
      <!-- 
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Appliances<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Referigerator</a></li>
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Books <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Referigerator</a></li>
        </ul>
      </li>
    </ul> -->
  </div>
</nav>

</body>
</html>
