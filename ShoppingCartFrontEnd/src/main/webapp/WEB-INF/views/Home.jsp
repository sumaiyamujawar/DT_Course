<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap code -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  
  <link rel="stylesheet" href="resources/css/bootstrap.css">
  <link rel="stylesheet" href="resources/js/bootstrap.js">
  
  <!-- <script type="text/javascript" src="resources/js/bootstrap.js"></script> -->
  
</head>
<body>

	<center>
	<h2>Welcome to Shopping Cart Web Site
	</center>
	</h2>
	
	<a href="LoginPage">  Login </a>
	<a href="RegistrationPage"> Register </a>
	${message}
	<hr color="green">
	
	<!-- Add menu.jsp -->

    <jsp:include page="Menu.jsp"></jsp:include>
    <hr>
    <!-- INCLUDE PRODUCTS -->
    <jsp:include page="AllProducts.jsp"></jsp:include>
    
    <!--if admin show adminhome.jsp  -->
    <c:if test="${isAdmin=='true'}">
		<jsp:include page="admin/AdminHome.jsp"></jsp:include>
	</c:if>
	
	 <c:if test="${isAdminClickedCategories=='true'}">
		<jsp:include page="admin/Category.jsp"></jsp:include>
	</c:if>
	
	
	 <c:if test="${isAdminClickedSuppliers=='true'}">
		<jsp:include page="admin/Supplier.jsp"></jsp:include><br>
	</c:if>
	
	 <c:if test="${isAdminClickedProducts=='true'}">
		<jsp:include page="admin/Product.jsp"></jsp:include>
	</c:if>
	
	
	

	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedRegister=='true'}">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>
</body>
</html>