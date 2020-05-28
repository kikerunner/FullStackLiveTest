<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.enrique.task.*"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
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
<div class="container">
<table class="table table-striped" style="margin: 0 auto;width: 80%" >
	<thead>
		<tr>
			<th scope="col">Id Task</th>
			
			<th scope="col">Name</th>
		
			<th scope="col">Description</th>
		
			<th scope="col">DeadLine</th>
		
			<th scope="col">Priority</th>
		
			<th scope="col">Status</th>	
		</tr>
	</thead>
	<tbody>
		<c:forEach var="task" items="${doneTaskList}">
			<tr>
				<td><c:out value="${task.getIdTask()}"/> </td>
				
				<td><c:out value="${task.getName()}"/> </td>
				
				<td><c:out value="${task.getDescription()}"/> </td>
				
				<td><c:out value="${task.getDeadLine()}"/> </td>
				
				<td><c:out value="${task.getPriority().getPriorityName()}"/> </td>
				
				<td><c:out value="${task.getStatus().getStatusName()}"/> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</div>
	<script src="js/bootstrap.min.js"></script> 
</body>
</html>