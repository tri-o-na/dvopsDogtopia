package com.dvops.maven.eclipse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCollection userCollection = new UserCollection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		String action = request.getServletPath();
		//I dont know how to make it so that the user wont be able to see the servlet name in the url, 
		//this is a very bad idea as possible other pages which need the same action will have a conflict
		
		//Another issue I encounter is that all prints arent working. :/ 
		//Hope can get it fixed soon, so it will be easier to code.
		switch (action) {
		case "/login.jsp":
			register(request, response);
			break;
		case "/index.jsp":
			login(request, response);
			break;
		} 
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		userCollection.signUp(new User(username, email, password));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Here!");
		//System.out.println(request.getContextPath());
		
		doGet(request, response);

	}
	
	

}
