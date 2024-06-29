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
	<jsp:include page="home.jsp"></jsp:include>
	<h1>List products</h1>
	<core:forEach var="product" items="${list}">
		${product.getId()} - ${product.getName()}  - ${product.getPrice()}  -  ${product.getDateAdded()} <br><br>
		
	</core:forEach><br><br>
	
	
	
</body>
</html>