<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>
</head>
<body>
	<jsp:include page="home.jsp"></jsp:include>
	<h1>List all users</h1>
	<core:forEach var="user" items="${list}">
		${user.getId()} - ${user.getUsername()}  - ${user.getPassword()}  -  ${user.getRole()}  -  ${user.getDateAdded()} <br><br>
	</core:forEach>
</body>
</html>