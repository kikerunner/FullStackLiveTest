<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
  
<title>User Menu</title>

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

<div class="row">
	<div class="col" align="center">
	<div class="card" style="width: 18rem;">
	  	<img class="card-img-top" width="286" height="180" src="https://youtalkonline.com/wp-content/uploads/conjugacion-verbo-to-do-en-ingles-300x266.jpg" alt="Card image cap">
	  	<div class="card-body">
	  		  <h5 class="card-title">List of Workers</h5>
	   		<p class="card-text">List of your colleagues</p>
	    <a href="/LoadWorkersList" class="btn btn-dark">Add</a>
	  	</div>
	</div>
	</div>
	<div class="col" align="center">
	<div class="card" style="width: 18rem;">
	  	<img class="card-img-top" width="286" height="180" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSJw_LZEx_q4EoNRWmi_jCFNAhz6uUL9r5L7IitePXHQfmvZMxP&usqp=CAU">
	  	<div class="card-body">
	  		  <h5 class="card-title">List of Flights</h5>
	   		<p class="card-text">All flights Available</p>
	    <a href="/LoadFlightsList" class="btn btn-dark">Add</a>
	  	</div>
	</div>
	</div>
	<div class="col" align="center">
	<div class="card" style="width: 18rem;">
	  	<img class="card-img-top" width="286" height="180" src="https://www.photos-public-domain.com/wp-content/uploads/2012/08/done.jpg">
	  	<div class="card-body">
	  		  <h5 class="card-title">List of Cabin Crew Flight 4 Workers</h5>
	   		<p class="card-text">Groups of Four Workers</p>
	    <a href="/cabinCrewFlight4Workers" class="btn btn-dark">Add</a>
	  	</div>
	</div>
	</div>
</div>
</div>
<script src="js/bootstrap.min.js"></script>  
</body>
</html>