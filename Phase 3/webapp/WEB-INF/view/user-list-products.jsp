<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Sporty Shoes </title>
</head>
<body>
	
	<h1>List products</h1>
	<core:forEach var="product" items="${list}">
		 ${product.getName()}  - ${product.getPrice()}  <br><br>
		
	</core:forEach><br><br>
	<a href="logout">Logout</a> 
	<h3>Login done Succesfully !!!!</h3>  
</body>
</html>