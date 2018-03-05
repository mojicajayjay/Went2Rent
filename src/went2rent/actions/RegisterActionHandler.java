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
		
		
		if(password1==password2) {
			password = password1;
			u.setUsername(username);
			u.setPassword(password);
			u.setEmail(email);
			u.setFirstname(firstname);
			u.setLastname(lastname);
			
			if(!UserService.addUser(u)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				request.setAttribute("error", "db-connection-error");
				dispatcher.forward(request, response);
			} else 
				request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
		
	}
}
