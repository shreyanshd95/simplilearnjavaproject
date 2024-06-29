<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>

<jsp:include page="home.jsp"></jsp:include>
	<div align="center" style="border: 2px solid green;padding :10px;" >
		<h1>Add Product</h1>
		<form:form action="add-product" method="post" modelAttribute="eProduct" >
			<table border="0">
				<tr>
					<td>Product Name:</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td>Product Price:</td>
					<td><form:input path="price" /></td>
				</tr>

				<tr>
					<td>Submit</td>
					<td><input type="submit" value="Add Product" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>