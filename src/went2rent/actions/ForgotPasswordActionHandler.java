package went2rent.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import went2rent.beans.Users;
import went2rent.service.UserService;

public class ForgotPasswordActionHandler implements ActionHandler{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		Users user = UserService.getUserByName(username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newpw.jsp");
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionname", user);
		}
		
		dispatcher.forward(request, response);
	}

}
