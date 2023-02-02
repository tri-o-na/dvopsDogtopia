<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dogtopia</title>
<link rel="icon" type="image/x-icon" class="logo"
	href="DVOPS-DOGTOPIA-PAW.jpg">
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

</head> <!-- Testing auto deployment -->
<body>
	<nav class="navbar">
		<div>
			<a href="<%=request.getContextPath()%>/index.jsp"><img class="logo" src="<%=request.getContextPath()%>/DVOPS-DOGTOPIA.jpg"
				width="18%"> </a>
			<div class="tabs">
				<a class="top_title_main" href="index.jsp"> HOME</a> 
				<a class="top_title" href="<%=request.getContextPath()%>/about-us.jsp"> ABOUT US</a> 
				<c:if test='${sessionScope.username == null}'>
					<a class="top_title" href="<%=request.getContextPath()%>/signUp.jsp">Sign Up</a>
				</c:if>
				<c:if test='${sessionScope.username != null}'>
					<a id="navAccount" class="top_title" href="<%=request.getContextPath()%>/account.jsp"> ACCOUNT</a>
					<form class="inline-form" action="<%=request.getContextPath()%>/UserServlet/logout" method="post">
						<input class="top_title_logout" type="submit" value="LOG OUT"/>
					</form>
				</c:if>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div>
		<img class="home-page-dog-img" src="<%=request.getContextPath()%>/Home-page-dog1.1.jpg">
	</div>
	<c:forEach var="dog" items = "${listDogs}">
		<div class="columnDog1">
			<div class="dog-1">
				<a href="<%=request.getContextPath()%>/DogServlet/desc?name=<c:out value='${dog.dogName}'/>"> <img id="${dog.dogName}" src="<%=request.getContextPath()%>/${dog.imageFile}" width="100%">
				</a>
				<h5 class="white-text">
					<c:out value='${dog.dogName}'/> <br> <br>
				</h5>
				<h6 class="yellow-text"><c:out value='${dog.heightRange}'/>kg</h6>
				<h6 class="yellow-text1">Colours: <c:out value='${dog.colours}'/></h6>
				<div class= "stars">
					<c:if test='${dog.rating == 1}'>
						<i class="fa fa-star"></i>
		                <i class="fa fa-star none"></i>
		                <i class="fa fa-star none"></i>                
		                <i class="fa fa-star none"></i>
		                <i class="fa fa-star none"></i>
					</c:if>
					<c:if test='${dog.rating == 2}'>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
		                <i class="fa fa-star none"></i>
		                <i class="fa fa-star none"></i>                   
		                <i class="fa fa-star none"></i>
					</c:if>
					<c:if test='${dog.rating == 3}'>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
		               	<i class="fa fa-star none"></i>
		                <i class="fa fa-star none"></i>	                
					</c:if>
					<c:if test='${dog.rating == 4}'>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
		                <i class="fa fa-star"></i>
		                <i class="fa fa-star"></i>
		               	<i class="fa fa-star none"></i>
					</c:if>
					<c:if test='${dog.rating == 5}'>
						<i class="fa fa-star"></i>
						<i class="fa fa-star"></i>
		                <i class="fa fa-star"></i>
		                <i class="fa fa-star"></i>
		                <i class="fa fa-star"></i>
					</c:if>
				</div>
			</div>
		</div>
	</c:forEach>

</body>
</html>