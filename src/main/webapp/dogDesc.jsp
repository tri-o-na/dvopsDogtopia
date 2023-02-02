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
</head>
<body>
	<nav class="navbar">
		<div>
			<a href="<%=request.getContextPath()%>/ReviewServlet/editReview?udogName=${param['name']}"><img
				class="logo" src="<%=request.getContextPath()%>/DVOPS-DOGTOPIA.jpg"
				width="18%"> </a>
			<div class="tabs">
				<a class="top_title"
					href="<%=request.getContextPath()%>/DogServlet/home.jsp"> HOME</a>
				<a class="top_title"
					href="<%=request.getContextPath()%>/about-us.jsp"> ABOUT US</a>
				<c:if test='${sessionScope.username == null}'>
					<a class="top_title"
						href="<%=request.getContextPath()%>/signUp.jsp">Sign Up</a>
				</c:if>
				<c:if test='${sessionScope.username != null}'>
					<a class="top_title"
						href="<%=request.getContextPath()%>/account.jsp"> ACCOUNT</a>
					<form class="inline-form"
						action="<%=request.getContextPath()%>/UserServlet/logout"
						method="post">
						<input class="top_title_logout" type="submit" value="LOG OUT" />
					</form>
				</c:if>
			</div>
		</div>
	</nav>
	<div class="desc">
		<div class="column1">
			<img src="<%=request.getContextPath()%>/${dog.imageFile}"
				width="100%">
		</div>
		<div class="descText">
			<h4 class="dog-title">
				<c:out value='${dog.dogName}' />
			</h4>
			<p class="dog-text">
				Height:
				<c:out value='${dog.heightRange}' />
				cm <br> Weight:
				<c:out value='${dog.weightRange}' />
				kg <br> Colours:
				<c:out value='${dog.colours}' />
				<br> Life Span:
				<c:out value='${dog.lifeSpan}' />
				Years <br> Price Range:
				<c:out value='${dog.priceRange}' />
				<br>
			</p>
			<br>
			<div class="stars1">
				<c:if test='${dog.rating == 1}'>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
				</c:if>
				<c:if test='${dog.rating == 2}'>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
				</c:if>
				<c:if test='${dog.rating == 3}'>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star none1"></i>
					<i class="fa fa-star none1"></i>
				</c:if>
				<c:if test='${dog.rating == 4}'>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star none1"></i>
				</c:if>
				<c:if test='${dog.rating == 5}'>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
					<i class="fa fa-star have"></i>
				</c:if>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>s
	<%-- <c:if test="${not empty session.username}"> --%>
	<h4 class="review-title">REVIEWS</h4>
	<a id="addReview" class="add-a-review-btn"
		href="<%=request.getContextPath()%>/addReview.jsp?rDogName=<c:out value='${dog.dogName}'/>">ADD
		A REVIEW</a>
	<c:forEach var="review" items="${listReviews}">
		<div class="row reviews">
			<div class="columnReviews1">
				<div class="review-1">
					<h5 class="review-username">
						<br>
						<c:out value='${review.username}' />
					</h5>
					<div class="stars2">
						<c:if test='${review.rating == 1}'>
							<i class="fa fa-star"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
						</c:if>
						<c:if test='${review.rating == 2}'>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
						</c:if>
						<c:if test='${review.rating == 3}'>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star none"></i>
							<i class="fa fa-star none"></i>
						</c:if>
						<c:if test='${review.rating == 4}'>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star none"></i>
						</c:if>
						<c:if test='${review.rating == 5}'>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
							<i class="fa fa-star"></i>
						</c:if>
						<c:if test='${review.username == sessionScope.username}'>
							<a class="fa fa-pencil"
								href="<%=request.getContextPath()%>/editReview.jsp?udogName=<c:out value='${dog.dogName}'/>"></a>
							<form class = "inline-form" method="post"
								action="<%=request.getContextPath()%>/ReviewServlet/deleteReview?ddogName=${param['name']}">
									<!-- <i class="fa fa-trash"></i> -->
									<input type="submit" name="deleteReview" class="buttonTrash" value = "DELETE">
							</form>
						</c:if>
					</div>
					<p class="review-text">
						<c:out value='${review.review}' />
					</p>

				</div>
			</div>
		</div>
	</c:forEach>
	<%-- </c:if> --%>

	<!-- <div class="row reviews">
		<div class="columnReviews1">
			<div class="review-1">
				<h5 class="review-username">Jane Tan</h5>
				<div class="stars2">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star none"></i> <i
						class="fa fa-star none"></i> <i class="fa fa-pencil"
						onclick="window.location.href='editReview.jsp'"></i> <i
						class="fa fa-trash"></i>
				</div>
				<p class="review-text">Has separation anxiety, is extremely
					active, very loyal, protects all, good at tricks</p>
			</div>
		</div>
		<div class="columnReviews1">
			<div class="review-1">
				<h5 class="review-username">Jane Tay Si Min</h5>
				<div class="stars2">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star none"></i> <i class="fa fa-pencil"
						onclick="window.location.href='editReview.jsp'"></i> <i
						class="fa fa-trash"></i>
				</div>
				<p class="review-text">Leaves fur all over the house, very fun
					to play with</p>
			</div>
		</div>
		<div class="columnReviews1">
			<div class="review-1">
				<p class="review-text">Very sporty and loves to go on hikes with
					me, learns new tricks very fast, is a great companion to have!</p>
				<h5 class="review-username">John Tan</h5>
				<div class="stars2">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-pencil"
						onclick="window.location.href='editReview.jsp'"></i> <i
						class="fa fa-trash"></i>
				</div>
			</div>
		</div>
		<div class="columnReviews1">
			<div class="review-1">
				<p class="review-text">acjsjvnfd jnsvlk ndnvl xvnjns djnnfjli
					Md;ksnvm ml lnnfvllk c mlkv</p>
				<h5 class="review-username">Jane</h5>
				<div class="stars2">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star none"></i> <i class="fa fa-pencil"
						onclick="window.location.href='editReview.jsp'"></i> <i
						class="fa fa-trash"></i>
				</div>
			</div>
		</div>
		<div class="columnReviews1">
			<div class="review-1">
				<p class="review-text">tello</p>
				<h5 class="review-username">Jane Tan</h5>
				<div class="stars2">
					<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star"></i> <i class="fa fa-star"></i> <i
						class="fa fa-star none"></i> <i class="fa fa-pencil"
						onclick="window.location.href='editReview.jsp'"></i> <i
						class="fa fa-trash"></i>
				</div>
			</div>
		</div>
	</div> -->


</body>
</html>