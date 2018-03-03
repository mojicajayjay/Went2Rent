package edu.securde.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("uname");
		String password = request.getParameter("pword_1");
		String submitType = request.getParameter("login_btn");
		CustomerDAO cd = new CustomerDAOImpl();
		Customer c = cd.getCustomer(userName, password);
		
		if(submitType.equals("login") && c != null && c.getUsername() != null) {
			request.setAttribute("message",c.getUsername());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		}else if(submitType.equals("register")) {
			c.setUsername(userName);
			c.setFirstName(request.getParameter("fname"));
			c.setLastName(request.getParameter("lname"));
			c.setPassword(password);
			c.setEmail(request.getParameter("email"));
			cd.insertCustomer(c);
			request.setAttribute("successMessage", "Registration Done!");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}else {
			request.setAttribute("message","Data not found ,  click on register");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

}
