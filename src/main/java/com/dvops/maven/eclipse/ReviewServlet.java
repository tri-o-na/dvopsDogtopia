package com.dvops.maven.eclipse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewCollection reviewCollection = new ReviewCollection();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Review Servlet doGet");
		String action = request.getServletPath(); // Get the route name
		switch (action) { 

		case "/ReviewServlet/addReview":
			addReview(request, response);
			break;

		case "/ReviewServlet/editReview":
			editReview(request, response);
			break;
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 
		doGet(request, response);
	}

	private void addReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("add review called");
		
		String username = (String) request.getSession().getAttribute("username");
		String dogName = request.getParameter("rDogName");
		System.out.println(username);
		System.out.println(dogName);
		
		String review = request.getParameter("rreview");
		int rating = Integer.parseInt(request.getParameter("rrating"));
		System.out.println("add review called2");
		// If either username, email or password is null or empty, user form wont go through
		if (review != null && review != "" && rating > 5 && rating < 0 && username != null && username != "") {

			// Call user sign up function in UserCollection.java
			reviewCollection.addReview(new Review(username, dogName, review, rating));

			// Redirecting user to login.jsp
			/* response.sendRedirect("http://localhost:8080/dvopsDogtopia/add.jsp"); */
		}

		else {
			// Just adding a alert whenever the user fails the form
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("location='http://localhost:8080/dvopsDogtopia/DogServlet/dogDesc.jsp';");
			out.println("</script>");
		}

	}
	
	private void editReview(HttpServletRequest request, HttpServletResponse response) throws IOException {}

	

}
