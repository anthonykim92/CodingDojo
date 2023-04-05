<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="UTF-8">
	<title>Result</title>
</head>
<body>
	<div class="container">
	<h1>Here's Your Omikuji</h1>
	
	
	<div class="text-black bg-primary" style="width:40%;" >
	
	<h3 style="width: 60%;">
		<c:out value="${result}"/>
	</h3>
	
	</div>
	
	<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>