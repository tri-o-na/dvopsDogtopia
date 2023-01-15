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
<link rel="stylesheet" href="style.css">

</head>
<body style="background-color: #FAF0CA;">
	<nav class="navbar navbar-expand-md">
		<div>
			<img class="logo" src="DVOPS-DOGTOPIA.jpg" width="18%">
			<div class="tabs">
				<a class="top_title" href="index.jsp"> HOME</a> <a class="top_title"
					href="about-us.jsp"> ABOUT US</a> 
					<a class="top_title_main" href="account.jsp"> ACCOUNT</a>
					<form action="<%=request.getContextPath()%>/UserServlet/logout" method="post">
						<input class="top_title_logout" type="submit" value="LOG OUT"/>
					</form>
			</div>

		</div>
	</nav>
	<div class="accountformPositioning">
		<div class="accountTitle">Your account details.</div>
		<form action="<%=request.getContextPath()%>/UserServlet/edit" method="post">

			<div class="accountForm">
				<c:out value="${sessionScope.username}"></c:out>
				<div class="inputTitle">Email</div>
				<input type="email" class="inputBox" name="eemail" value = "${sessionScope.email}">
				<div class="inputTitle">Password</div>
				<input type="text" class="inputBox" name="epassword" value = "${sessionScope.password}">

			</div>
			<div style="margin-top: 3vh;">
				<input class="formButton" type="submit" value="Update" name="updateUser"/> <br>
				<input class="formButton" type="submit" value="Delete" name="deleteUser"/>
			</div>
		</form>
	</div>
</body>
</html>