<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>

<jsp:include page="home.jsp"></jsp:include>
	<div align="center" style="border: 2px solid green;padding :10px;" >
		<h1>Update User</h1>
		<form:form action="update-user" method="post" modelAttribute="eUser" >
			<table border="0">
			    <tr>
					<td>User ID:</td>
					<td><form:input path="id" /></td>
				</tr>
			    
				<tr>
					<td>User Name:</td>
					<td><form:input path="username" /></td>
				</tr>

				<tr>
					<td>User Password:</td>
					<td><form:input path="password" /></td>
				</tr>

                 <tr>
					<td>User Role:</td>
					<td><form:input path="role" /></td>
				</tr>
				
				<tr>
					<td>Submit</td>
					<td><input type="submit" value="Update User" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>