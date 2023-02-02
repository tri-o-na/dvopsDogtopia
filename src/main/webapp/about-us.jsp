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
				<a class="top_title" href="index.jsp"> HOME</a> <a
					class="top_title_main" href="about-us.jsp"> ABOUT US</a>
				<c:if test='${sessionScope.username == null}'>
					<a class="top_title" href="signUp.jsp"> Sign Up</a>
				</c:if>
				<c:if test='${sessionScope.username != null}'>
					<a class="top_title" href="account.jsp"> ACCOUNT</a>
					<form class="inline-form" action="<%=request.getContextPath()%>/UserServlet/logout"
						method="post">
						<input class="top_title_logout" type="submit" value="LOG OUT" />
					</form>
				</c:if>
			</div>
		</div>
	</nav>
	<div style="margin-left: 8vw; margin-top: 15vh;">
		<img class="testing" src="dog_image_1.png" width="31%">
		<div
			style="float: right; margin-top: 1vh; margin-right: 51vw; font-size: 2.25rem; font-weight: 500; font-family: Omnes; color: #F95738">About
			us</div>
		<div
			style="float: right; margin-top: -70vh; margin-right: 10%; margin-left: -10vw; font-size: 1.4rem; font-weight: 300;">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor <br> incididunt ut labore et dolore magna aliqua.
			Ut enim ad minim veniam, quis nostrud <br> exercitation ullamco
			laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure <br>
			dolor in reprehenderit in voluptate velit esse cillum dolore eu
			fugiat nulla pariatur. <br> Excepteur sint occaecat cupidatat
			non proident, sunt in culpa qui officia deserunt <br> mollit
			anim id est laborum.
		</div>
		<img class="testing" src="dog_image_2.png" width="40%"
			style="margin-left: 33vw; margin-top: -55vh">
	</div>
</body>
</html>