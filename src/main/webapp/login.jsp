<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<div class= "tabs">
			<a class="top_title" href="index.jsp"> HOME</a> 
			<a class="top_title" href="about-us.jsp"> ABOUT US</a> 
			<a class="top_title" href="care.jsp"> CARE</a> 
			<a class="top_title_main" href="signUp.jsp"> ACCOUNT</a>
			</div>

		</div>
	</nav>
	<div style="margin-top:25vh; margin-left: 33%; color: #0D3B66">
		<div class="accountTitle" style="font-size: 2.325rem; font-weight: 500; font-family: Omnes;">Please sign in.</div>
	 	<div style="font-size: 1.65rem; font-weight: 450; font-family: Freude; margin-top: 2.5vh; margin-bottom: 2vh;">
		 	<form>
				<div class="nameSignUp">
					Email
				</div>
				<input type="text" style="width: 25vw; height: 5vh; border: 0.1vw solid black; border-radius: .5vw; background-color: rgba(244,211,94,0.22); padding-left: .3vw; padding-right: .3vw; font-size: 1.2rem">	
				<div style="margin-top:1vh">
					Password 
				</div>
				<input type="text" style="width: 25vw; height: 5vh; border: 0.1vw solid black; border-radius: .5vw; background-color: rgba(244,211,94,0.22); padding-left: .3vw; padding-right: .3vw; font-size: 1.2rem">	
		 	</form>
		</div>
		<a href="signUp.jsp" style="color: #0D3B66; font-size: 1rem; font-weight: 300; font-family: Omnes; margin-left: 15.5vw; margin-top: 2vh; margin-right: 50%; text-decoration: none">No Account? Sign Up Here</a>
		<button type="button" onclick="window.location.href='account.jsp'" style="font-weight: 600; width: 26vw; height: 5vh; border: 0.1vw solid black; background-color: #0D3B66; color:#F4D35E; padding-left: .3vw; padding-right: .3vw; font-size: 1.3rem; margin-top: 3vh;">Sign In</button>
	</div>
</body>
</html>