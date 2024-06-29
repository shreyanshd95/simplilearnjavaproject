<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>


	<div align="center" style="border: 2px solid green;padding :10px;" >
	<h1>Welcome to sportyshoes.com</h1>
		<h1>Login User</h1>
		<form:form action="ulogin" method="post" modelAttribute="eUser" >
			<table border="0">
				<tr>
					<td>UserName:</td>
					<td><form:input path="username" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td>Submit</td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	
</body>
</html>