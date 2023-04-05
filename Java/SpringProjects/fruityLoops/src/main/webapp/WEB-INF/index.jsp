<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruit Loop</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<h1>Fruit Store</h1>

	
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			
			<c:forEach var="fruit" items="${fruits}">
				<tr>
					<td class="name">${fruit.name}</td>
					<td>${fruit.price}</td>
				</tr>
			</c:forEach>
			

		</table>
	
	</div>

</body>
</html>