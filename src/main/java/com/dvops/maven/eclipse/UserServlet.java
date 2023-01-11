package com.dvops.maven.eclipse;

import java.io.IOException;
import java.io.PrintWriter;

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
		//Web.xml file is finally working, but for the form action u MUST use this format: 
		// <%=request.getContextPath()%>/{ServletCase}
		//All the servlet cases are listed at the Servlet itself
		//Must change web.xml file every time u add a new servlet or a new servlet function/case
		//No longer need the horrible fix which was implemented. 
		
//		if (request.getParameter("lusername") != null || request.getParameter("lusername") != "" ) {
//			//Simple shit if else here, what it do is that it see whether this field is filled. If the field is filed
//			//That means that they are in the login page, then we will call the login function ONLY!
//			System.out.println("Login passed!");
//			login(request, response);
//		}
//		else {
//			//Otherwise do the register function.
//			System.out.println("Register passed!");
//			register(request, response);
//		}
		
		String action = request.getServletPath(); //Get the route name
		try {
			switch (action) {
			case "/UserServlet/login":
				login(request, response);
				break;
			case "/UserServlet/register":
				register(request, response);
				break;
			}
		} catch (ServletException ex) {
			throw new ServletException(ex);
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //Login user function
		System.out.print("LOGIN HERE!!!!");
		//Getting the login form info from login.jsp
		String username = request.getParameter("lusername");
		String password = request.getParameter("lpassword");
		
		//If userCollection cant find user, it will retuurn a null
		if (userCollection.login(username, password) != null) {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			response.sendRedirect("http://localhost:8080/dvopsDogtopia/index.jsp");
			System.out.println(userCollection.login(username, password).getEmail());
		}
		else {
			//Just adding a alert whenever the user fails the form 
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("location='http://localhost:8080/dvopsDogtopia/login.jsp';");
			out.println("</script>");
		};
		 
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException { //Register user function
		
		System.out.println("REGISTER HERE!!!!");
		System.out.println(userCollection.users.size());
		
		//Getting register form info from signUp.jsp
		String username = request.getParameter("rusername");
		String email = request.getParameter("remail");
		String password = request.getParameter("rpassword");

		//If either username, email or password is null or empty, user form wont go through
		if (username != null && username != "" && email != null && email != "" && password != null && password != "" ) {
			userCollection.signUp(new User(username, email, password));
			System.out.println(userCollection.users.size());
			response.sendRedirect("http://localhost:8080/dvopsDogtopia/login.jsp");
		}
		else {
			//Just adding a alert whenever the user fails the form 
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("location='http://localhost:8080/dvopsDogtopia/signUp.jsp';");
			out.println("</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Here!");
		
		doGet(request, response);

	}
	
	

}
