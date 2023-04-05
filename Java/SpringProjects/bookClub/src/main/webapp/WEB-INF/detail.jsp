<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${book.user.name }"/> read <c:out value="${book.title }"/> by <c:out value="${book.author }"/></title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>

	<div class="container">
		<h1><c:out value="${book.title}"/></h1>
		<h3><c:out value="${book.user.name }"/> read <c:out value="${book.title }"/> by <c:out value="${book.author }"/></h3>
		<div class="d-flex flex-row-reverse">
		<a href="/books">back to main</a>
		</div>
		
		<div class="container">
			<h4>Here are <c:out value="${book.user.name}"/>'s thoughts:</h4>
			<hr />
			
			<p><c:out value="${book.thoughts}"/></p>
			<hr />
		<a href="/books/edit/${book.id}">Edit</a>
		<form action="/books/edit/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
		</div>
		
	</div>

</body>
</html>