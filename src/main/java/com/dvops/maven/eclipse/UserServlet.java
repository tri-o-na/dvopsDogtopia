package com.dvops.maven.eclipse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserCollection userCollection = new UserCollection();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Web.xml file is finally working, but for the form action u MUST use this format: 
		// <%=request.getContextPath()%>/{ServletCase}
		//All the servlet cases are listed at the Servlet itself
		//Must change web.xml file every time u add a new servlet or a new servlet function/case
		
		String action = request.getServletPath(); //Get the route name
		try {
			switch (action) {
			case "/UserServlet/login":
				login(request, response);
				break;
			case "/UserServlet/register":
				register(request, response);
				break;
			case "/UserServlet/edit":
				edit(request, response);
				break;
			case "/UserServlet/logout":
				logout(request, response);
				break;
			}
		} catch (ServletException ex) {
			throw new ServletException(ex);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost called");
		
		doGet(request, response);

	}
	
	
	//Register user function
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Register called");
		
		//Getting register form info from signUp.jsp
		String username = request.getParameter("rusername");
		String email = request.getParameter("remail");
		String password = request.getParameter("rpassword");

		//If either username, email or password is null or empty, user form wont go through
		if (username != null && username != "" && email != null && email != "" && password != null && password != "" ) {
			
			//Call user sign up function in UserCollection.java
			userCollection.signUp(new User(username, email, password));
			
			//Redirecting user to login.jsp
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
	
	
	//Login user function
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		System.out.println("Login called");
		
		//Getting the login form info from login.jsp
		String username = (String)request.getParameter("lusername");
		String password = request.getParameter("lpassword");
		
		//If userCollection cant find user, it will return a null
		if (userCollection.login(username, password) != null) {
			
			//Setting sessionStorage, to be used for editing and knowing that the user is logged in.
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("email", userCollection.login(username, password).getEmail());
			request.getSession().setAttribute("password", password);
			
			//Redirecting user to index.jsp
			response.sendRedirect("http://localhost:8080/dvopsDogtopia/index.jsp");		
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
	
	
	//Logout user function
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Removing all sessionStorage to allow another user to sign in
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		request.getSession().removeAttribute("email");
		
		//Alerting the user that they have been logged out
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('You have been logged out, see you again!');");
		out.println("location='http://localhost:8080/dvopsDogtopia/index.jsp';");
		out.println("</script>");
	}
	
	//Edit function
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update/Delete form called");
		
		//Setting Strings usable on both functions 
		String username = (String) request.getSession().getAttribute("username");
		String oldpass = (String) request.getSession().getAttribute("password");
		
		//Need to use this method as both functions are under the same form.
		
		//If the update button has been clicked
		if (request.getParameter("updateUser") != null) {
			System.out.println("Update called");
			
			//Checking whether email is valid
			if (request.getParameter("eemail") != "" && request.getParameter("eemail").contains("@") && request.getParameter("eemail") != null) {
				
				//Checking whether password is valid
				if (request.getParameter("epassword") != "" && request.getParameter("epassword") != null) {
					
					//Getting extra fields needed to edit user.
					String email = request.getParameter("eemail");
					String password = request.getParameter("epassword");
			
					//Call edit user function in UserCollection.java
					userCollection.editUser(username, email, password, oldpass);
					
					//Updating sessionStorage with new/old values
					request.getSession().setAttribute("email", email);
					request.getSession().setAttribute("password", password);
					
					//Redirect the user to index.jsp
					response.sendRedirect("http://localhost:8080/dvopsDogtopia/index.jsp");
				}
				else {
					//Alerting the user that their password cannot be empty
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Password cannot be empty!');");
					out.println("location='http://localhost:8080/dvopsDogtopia/account.jsp';");
					out.println("</script>");
				};
			}
			else {
				//Alerting the user that their email field is either invalid due to having no @ or empty
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid email or email cannot be empty');");
				out.println("location='http://localhost:8080/dvopsDogtopia/account.jsp';");
				out.println("</script>");
			};

		};
		
		//If the delete button has been clicked
		if(request.getParameter("deleteUser") != null){
			System.out.println("Delete called");
			
			//Call delete user function in UserCollection.java
			userCollection.deleteUser(username, oldpass);
			
			//Removing all of the sessionStorage as user have effectively logged out
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("email");
			
			//Redirect the user to index.jsp 
			response.sendRedirect("http://localhost:8080/dvopsDogtopia/index.jsp");
		};

	}	
	
	

}
