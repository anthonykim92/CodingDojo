<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Club</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
   
</head>
<body>

<div class="container">

	<h1>Book Club</h1>
	3 rules for book club. 1. We don't talk about Book Club. 

	<h2>Register</h2>

	<div class="container">
		<form:form action="/register" modelAttribute="newUser" class="form" method="post">
		
			<div class="form-row">
			 	<form:errors path="name"/>
				<form:label for="name" path="name">Name:</form:label>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="password" path="password" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="confirm"/>
				<form:label for="" path="confirm">Confirm:</form:label>
				<form:input type="password" path="confirm" class="form-control"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Submit" class="btn-primary"/>
			</div>
			
		</form:form>
	</div>
	
	<h2>Log In</h2>

	<div class="container">
		<form:form action="/login" modelAttribute="newLogin" class="form" method="post">
			<div class="form-row">
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email" class="form-control"/>
			</div>
			
			<div>
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="password" path="password" class="form-control"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Submit" class="btn-primary"/>
			</div>
		
		</form:form>
	</div>

</div>

</body>
</html>