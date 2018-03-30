package went2rent.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import went2rent.beans.Users;
import went2rent.service.UserService;

public class ResetPasswordActionHandler implements ActionHandler{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("pword_1");
		RequestDispatcher dispatcher = request.getRequestDispatcher("cata");
		
		HttpSession session = request.getSession();	
		String username = request.getParameter("username");;
//		session.setAttribute("sessionname", user);
		Users oldUser = null;
		oldUser = UserService.getUserByName(username);
		
		if(oldUser != null) {
			Users newUser = oldUser;
			newUser.setPassword(password);
			UserService.updateUser(oldUser.getId(), newUser);
		}
		
		dispatcher.forward(request, response);
	}

}
