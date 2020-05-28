<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.enrique.task.*"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">  
</head>
<body class="text-center">
	<div align="center">
	<form:form action="/login" method="post" modelAttribute="user" class="form-signin col-md-4">
		<img class="mb-4" src="https://media-exp1.licdn.com/dms/image/C561BAQHAdLVwsteyQA/company-background_10000/0?e=2159024400&v=beta&t=OKrsQVawuG4VVzO8Lmalz_7pyWDib7hFPezCzfEC1pM" alt="" width="150" height="150"><br>
		<label>User Name:</label>
		<form:input type="text" name="userName" path="userName" class="form-control"/> 
		<label>Password:</label>
		<form:input type="password" name="password" path="password" class="form-control"/> 
		
		<input type="submit" class="btn btn-primary" >
	</form:form>
	</div>
	<script src="js/bootstrap.min.js"></script> 
</body>
</html>