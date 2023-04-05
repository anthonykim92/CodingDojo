<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
   
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Login and Registration!</title>
</head>
<body>
<h1>Register Here: </h1>
<form:form action="/register" method="post" modelAttribute="newUser">
    <p>
        <form:label path="userName">User Name:</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
    <p>
        <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:errors path="password"/>
        <form:input type="password" path="password"/>
    </p>
    <p>
        <form:label path="confirm">Confirm Password: </form:label>
        <form:errors path="confirm"/>     
        <form:input type= "password" path="confirm"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>  
</body>
<h1>Login Here: </h1>
<form:form action="/login" method="post" modelAttribute="newLogin">
	<p>
		<form:label path="email">Email: </form:label>
		<form:errors path="email"/>
		<form:input path="email"/>
	</p>
 	<p>
        <form:label path="password">Password:</form:label>
        <form:errors path="password"/>
        <form:input type="password" path="password"/>
        
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</html>