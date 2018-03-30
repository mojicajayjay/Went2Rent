package went2rent.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import went2rent.beans.Users;
import went2rent.service.UserService;

public class LogInActionHandler implements ActionHandler {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
//		System.out.println(username);
		Users user = UserService.findUser(username, password);
//		System.out.println(user.getAdmin());
//		System.out.println(user.getUsername());
		RequestDispatcher dispatcher = request.getRequestDispatcher("cata");
		
		if(user != null) {
			HttpSession session = request.getSession();
			if(user.getAdmin()==1) {
				System.out.println("Setting true params");
				session.setAttribute("admin", "tru");
			}
			else {
				System.out.println("Setting empty params");
				session.removeAttribute("admin");
			}
			dispatcher = request.getRequestDispatcher("cata");
			session.setAttribute("sessionuser", user);
			
			String rm = request.getParameter("remember");
			if(rm != null) {
				Cookie usernameCookie = new Cookie("userID", String.valueOf(user.getId()));
				usernameCookie.setMaxAge(60*60*24*21);
				response.addCookie(usernameCookie);
			}
			
		}
		else {
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request, response);
	}

}
