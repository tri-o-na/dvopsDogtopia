package com.dvops.maven.eclipse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
	DogCollection dogCollection = new DogCollection();
	ReviewCollection reviewCollection = new ReviewCollection();

	public DogServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DogServlet doGet");
		String action = request.getServletPath(); // Get the route name
		switch (action) {
		case "/DogServlet/desc":
			getDogDesc(request, response);
//			listReviews(request, response);
			break;
		case "/DogServlet/home":
			listDogs(request, response);
			break;

		case "/ReviewServlet/addReview":
			addReview(request, response);
			break;

		case "/ReviewServlet/editReview":
			editReview(request, response);
			break;

		case "/ReviewServlet/deleteReview":
			deleteReview(request, response);
			break;
		}

	}

	private void getDogDesc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		Dog currentDog = new Dog("", "", "", "", "", "", 0, "");
		Dog d = dogCollection.getOneDog(name);
		currentDog = new Dog(d.getDogName(), d.getHeightRange(), d.getWeightRange(), d.getColours(), d.getLifeSpan(),
				d.getPriceRange(), d.getRating(), d.getImageFile());
		request.setAttribute("dog", currentDog);
		List<Review> reviews = new ArrayList<>();
		/* System.out.println("ReviewServlet array"); */
		System.out.println("hell   o");
		System.out.println(reviewCollection.getOneDogReview(request.getParameter("name")));
		for (Review r : reviewCollection.getOneDogReview(request.getParameter("name"))) {
			String username = r.getUsername();
			String dogName = r.getDogName();
			String review = r.getReview();
			int rating = r.getRating();

			reviews.add(new Review(username, dogName, review, rating));
			System.out.println(r.getDogName());
			System.out.println(r.getUsername());
			System.out.println(r.getReview());
			System.out.println(r.getRating());
			System.out.println("	");
		}
		System.out.println(reviewCollection.getOneDogReview(request.getParameter("name")));
		request.setAttribute("listReviews", reviews);
		request.getRequestDispatcher("/dogDesc.jsp").forward(request, response);
	}

	private void listDogs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Dog> dogs = new ArrayList<>();
		System.out.println("DogServlet array");
		for (Dog d : dogCollection.dogs) {
			String dogName = d.getDogName();
			String heightRange = d.getHeightRange();
			String weightRange = d.getWeightRange();
			String colours = d.getColours();
			String lifeSpan = d.getLifeSpan();
			String priceRange = d.getPriceRange();
			int rating = d.getRating();
			String imageFile = d.getImageFile();

			dogs.add(new Dog(dogName, heightRange, weightRange, colours, lifeSpan, priceRange, rating, imageFile));
			System.out.println(dogName);
		}
		System.out.println(reviewCollection.reviews);
		System.out.println(dogCollection.dogs);
		request.setAttribute("listDogs", dogs);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/*
	 * private void listReviews(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { List<Review> reviews = new
	 * ArrayList<>(); System.out.println("ReviewServlet array");
	 * System.out.println(reviewCollection.getOneDogReview(request.getParameter(
	 * "name"))); for (Review r :
	 * reviewCollection.getOneDogReview(request.getParameter("name"))) { String
	 * username = r.getUsername(); String dogName = r.getDogName(); String review =
	 * r.getReview(); int rating = r.getRating();
	 * 
	 * reviews.add(new Review(username, dogName, review, rating));
	 * System.out.println(r.getDogName()); System.out.println(r.getUsername());
	 * System.out.println(r.getReview()); System.out.println(r.getRating());
	 * System.out.println("	"); } System.out.println("hello");
	 * System.out.println(reviewCollection.getOneDogReview(request.getParameter(
	 * "name"))); request.removeAttribute("listReviews");
	 * System.out.println(reviewCollection.getOneDogReview(request.getParameter(
	 * "name"))); request.setAttribute("listReviews", reviews);
	 * System.out.println(request.getAttribute("listReviews"));
	 * request.getRequestDispatcher("/dogDesc.jsp").forward(request, response); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DogServlet doPost");
		doGet(request, response);
	}

	private void addReview(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("add review called");

		String username = (String) request.getSession().getAttribute("username");
		String dogName = request.getParameter("rDogName");
		System.out.println(username);
		System.out.println(dogName);

		if (request.getParameter("rrating") != "") {
			int rating = Integer.parseInt(request.getParameter("rrating"));
			String review = request.getParameter("rreview");
			System.out.println(review);
			System.out.println(rating);
			System.out.println("add review called2");
			// If either username, email or password is null or empty, user form wont go
			// through
			if (review != null && review != "" && username != null && username != "") {

				// Call user sign up function in UserCollection.java
				boolean reviewww = reviewCollection.addReview(new Review(username, dogName, review, rating));
				System.out.println(reviewww);
				System.out.println(reviewCollection.reviews);
//				String dogUrl = "location='http://localhost:8080/dvopsDogtopia/DogServlet/desc?name="+ dogName + "'";
				String dogUrl = "location='http://localhost:8080/dvopsDogtopia/DogServlet/home'";
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('review added');");
				out.println(dogUrl);
				out.println("</script>");
				// Redirecting user to login.jsp
				/* response.sendRedirect("http://localhost:8080/dvopsDogtopia/add.jsp"); */
			}

			else {
				// Just adding a alert whenever the user fails the form
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('form failed');");
				out.println("location='http://localhost:8080/dvopsDogtopia/dogDesc.jsp';");
				out.println("</script>");
			}
		}

	}

	private void editReview(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("Update review called");

		String username = (String) request.getSession().getAttribute("username");
		String dogName = request.getParameter("udogName");
		System.out.println(username);
		System.out.println(dogName);
		System.out.println(' ');

		// Need to use this method as both functions are under the same form.

		System.out.println("Update called");

		
		if (request.getParameter("ureview") != "" && request.getParameter("ureview") != null) {

			
			if (request.getParameter("urating") != "" && request.getParameter("urating") != null) {

				// Getting extra fields needed to edit user.
				String review = request.getParameter("ureview");
				int rating = Integer.parseInt(request.getParameter("urating"));

				// Call edit user function in UserCollection.java
				reviewCollection.editReview(username, dogName, review, rating);
				System.out.println(review);
				System.out.println(rating);

				// Updating sessionStorage with new values
				request.getSession().setAttribute("review", review);
				request.getSession().setAttribute("rating", rating);

				// Redirect the user to dogDesc.jsp
				response.sendRedirect("http://localhost:8080/dvopsDogtopia/home.jsp");
			} else {
				// Alerting the user that their review and rating cannot be empty
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('review and rating cannot be empty!');");
				out.println("location='http://localhost:8080/dvopsDogtopia/home.jsp';");
				out.println("</script>");
			}
		}

	}

	private void deleteReview(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Delete review called");

		// Setting Strings usable on both functions 
		String username = (String) request.getSession().getAttribute("username");
		String dogName = request.getParameter("ddogName");
		System.out.println(username);
		System.out.println("doggggggg");
		System.out.println(dogName);

		if (request.getParameter("deleteReview") != null) {
			System.out.println("Delete Review called");

			// Call delete user function in UserCollection.java
			reviewCollection.deleteReview(username, dogName);
			String dogUrl = "location='http://localhost:8080/dvopsDogtopia/DogServlet/home'";
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('review deleted');");
			out.println(dogUrl);
			out.println("</script>");

			// Redirect the user to index.jsp
			/*
			 * response.sendRedirect("http://localhost:8080/dvopsDogtopia/DogServlet/home");
			 */
		}
		;

	}

}
