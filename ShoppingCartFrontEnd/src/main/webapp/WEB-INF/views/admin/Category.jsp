<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Manage Categories</h2>
<div id="CreateCategory">
	<form action="manage_category_add" method="get">
	<input type="text" name="id">
	<input type="text" name="name">
	<input type="text" name="description">
	<input type="submit" value="Create Category">
	</form>
</div>

<h2>Delete/Update the Categories</h2>
<div id="UpdateCategory">
<form action="manage_category_update" method="get">
	<input type="text" name="id" value="${selectedCategory.id}">
	<input type="text" name="name" value="${selectedCategory.name}">
	<input type="text" name="description" value="${selectedCategory.description}">
	<input type="submit" value="Update Category">
</form>
</div>


<div id="ShowCategories">
	<table>
	<thead>
	<tr>
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Category Description</td>
	<td>Action</td>
	</tr>
	</thead>
	<c:forEach var="category" items="${categoryList}"></c:forEach>
	<tr>
	<td>${category.id}</td>
	<td>${category.name}</td>
	<td>${category.description}</td>
	
	<td><a href="manage_category_delete/${category.id}"> Delete</a>
		<a href="manage_category_edit/${category.id}"> Edit</a>
	</td> 
	
	</tr>
	
	</table>

</div>

</body>
</html>