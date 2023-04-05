<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a Book</title>
</head>
<body>
<h1>Edit Book</h1>
<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
  
    <p>
        <form:label path="author">Author:</form:label>
        <form:errors path="author"/>
        <form:input path="author"/>
    </p>
      <p>
        <form:label path="thoughts">Description</form:label>
        <form:errors path="thoughts"/>
        <form:textarea path="thoughts"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>