package went2rent.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import went2rent.beans.Users;
import went2rent.service.UserService;

public class RegisterActionHandler implements ActionHandler{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("uname");
		String password1 = request.getParameter("pword_1");
		String password2 = request.getParameter("pword_2");
		String email = request.getParameter("email");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String password;
		Users u = new Users();
		System.out.println(password1);
		System.out.println(password2);
		if(UserService.userExists(username)) {
			System.out.println("user exists!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		
		if(password1.equals(password2)) {
			password = password1;
			u.setUsername(username);
			u.setPassword(password);
			u.setEmail(email);
			u.setFirstname(firstname);
			u.setLastname(lastname);
			
			try {
				if(!UserService.addUser(u)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					request.setAttribute("error", "db-connection-error");
					dispatcher.forward(request, response);
				} else 
					request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("passwords don't match!");
			response.sendRedirect("register.jsp");
		}
		
		
	}
}
