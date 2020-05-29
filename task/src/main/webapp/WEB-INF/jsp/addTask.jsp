<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.enrique.task.*"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new Task</title>
<link rel="stylesheet" href="css/bootstrap.min.css">  
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
	<font face="courier"> <br><h4>Hello, ${userInSession.getUserName()} ${userInSession.getSurname()}</h4></font>
	<a href="/login" class="btn btn-secondary">Close Session</a>
		</div>
		
		<div class="col">
			<img class="mb-4" src="https://media-exp1.licdn.com/dms/image/C561BAQHAdLVwsteyQA/company-background_10000/0?e=2159024400&v=beta&t=OKrsQVawuG4VVzO8Lmalz_7pyWDib7hFPezCzfEC1pM" alt="" height="125">
		</div>
	</div>
</div> 
<div align="center">
	<form:form action="/addTask" method="post" modelAttribute="task"  class="form-signin col-md-4">
		<label>Name:</label>
		<form:input type="text" name="name" path="name" class="form-control" width="250px"/>
		<label>Description:</label>
		<form:textarea type="textarea" name="description" path="description" class="form-control"/> 
		<label>Dead Line:</label>
		<form:input type="date" name="DeadLine" path="DeadLine" class="form-control" width="250px"/>
		<label>Priority:</label>
		<form:select class="form-control" path="idPriority" >
				<form:option value="0">Select Priority</form:option>
				<form:options items="${PriorityList}" itemValue="idPriority" itemLabel="PriorityName" />
		</form:select>
		<label>Status:</label>
		<form:select class="form-control" path="idStatus" >
				<form:option value="0">Select Status</form:option>
				<form:options items="${StatusList}" itemValue="idStatus" itemLabel="StatusName" />
		</form:select>
		<form:input value="${userInSession.getIdUser()}" type="hidden" name="idUser" path="idUser" class="form-control" width="250px"/>
		<input type="submit" class="btn btn-primary" >
	</form:form>
</div>
	<script src="js/bootstrap.min.js"></script> 
</body>
</html>