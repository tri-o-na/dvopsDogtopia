package com.dvops.maven.eclipse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//I dont know how to make it so that the user wont be able to see the servlet name in the url, 
		//this is a very bad idea as possible other pages which need the same action will have a conflict
		
		//Clarence: 9 Jan 2023
		//Another issue I encounter is that all prints arent working. :/ 
		//Hope can get it fixed soon, so it will be easier to code.
		
		//Clarence: 10 Jab 2023
		//Prints are working NOW! THe issue at hand is the Action not passing through this Servlet
		//Probably need the web.xml file to work, if not we CANNOT make the shit method better. 
		//Will add update profile soon. 
		
		if (request.getParameter("lusername") != null || request.getParameter("lusername") != "" ) {
			//Simple shit if else here, what it do is that it see whether this field is filled. If the field is filed
			//That means that they are in the login page, then we will call the login function ONLY!
			System.out.println("Login passed!");
			login(request, response);
		}
		else {
			//Otherwise do the register function.
			System.out.println("Register passed!");
			register(request, response);
		}
//		String action = request.getServletPath();
//		switch (action) {
//		case "/login.jsp":
//			register(request, response);
//			break;
//		case "UserServlet/login":
//			login(request, response);
//			break;
//		} 
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("LOGIN HERE!!!!");
		String username = request.getParameter("lusername");
		String password = request.getParameter("lpassword");
		System.out.print(userCollection.login("user1", "password1"));
		
		if (userCollection.login(username, password) != null) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			System.out.println(userCollection.login(username, password).getEmail());
		};
		  
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("rusername");
		String email = request.getParameter("remail");
		String password = request.getParameter("rpassword");

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
