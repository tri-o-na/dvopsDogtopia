<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dogtopia Edit Review</title>
<link rel="icon" type="image/x-icon" class="logo"
	href="DVOPS-DOGTOPIA-PAW.jpg">
<link rel="stylesheet" href="style.css">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
<body>
	<nav class="navbar">
		<div>
			<a href="<%=request.getContextPath()%>/index.jsp"><img class="logo" src="<%=request.getContextPath()%>/DVOPS-DOGTOPIA.jpg"
				width="18%"> </a>
			<div class="tabs">
				<a class="top_title" href="<%=request.getContextPath()%>/index.jsp"> HOME</a> 
				<a class="top_title" href="<%=request.getContextPath()%>/about-us.jsp"> ABOUT US</a> 
				<c:if test='${sessionScope.username == null}'>
					<a class="top_title" href="<%=request.getContextPath()%>/signUp.jsp"> Sign Up</a>
				</c:if>
				<c:if test='${sessionScope.username != null}'>
					<a class="top_title" href="<%=request.getContextPath()%>/account.jsp"> ACCOUNT</a>
					<form action="<%=request.getContextPath()%>/UserServlet/logout" method="post">
						<input class="top_title_logout" type="submit" value="LOG OUT"/>
					</form>
				</c:if>
			</div>
		</div>
	</nav>
	<div class="reviewformPositioning">
		<div class="addReviewTitle">Edit your review here.</div>
	 	<div class="addReviewForm">
		 	<form>
				<div class="inputTitle1">
					Review
				</div>
				<input type="text" class="inputBox">	
				<div class="inputTitle">
					Rating 
				</div>
				<input type="number" class="inputBox">		 	
		 	</form>
		</div>
		<button class="formButton">Save</button>
	</div>
</body>
</html>