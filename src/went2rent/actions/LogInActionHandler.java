package went2rent.actions;

import java.io.IOException;
import java.util.Date;

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
		HttpSession session = request.getSession();
		if(user != null) {
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
			int loginAttempt;
            if (session.getAttribute("loginCount") == null) {
                session.setAttribute("loginCount", 0);
                loginAttempt = 0;
            }
            else {
                 loginAttempt = Integer.parseInt(session.getAttribute("loginCount").toString());
            }

            if (loginAttempt >= 2 ) {        
                long lastAccessedTime = session.getLastAccessedTime();
                Date date = new Date();
                long currentTime = date.getTime();
                long timeDiff = currentTime - lastAccessedTime;
             
                if (timeDiff >= 1200000) {   
                    session.invalidate();
                }
                else {
                     session.setAttribute("message","You have exceeded the 3 failed login attempt. Please try to log in after 20 minutes.");
                }  

            }
            else {
                 loginAttempt++;
                 int allowLogin = 3-loginAttempt;
                 session.setAttribute("message","loginAttempt= "+loginAttempt+". Invalid username or password. You have "+allowLogin+" attempts remaining. Please try again! <br>Not a registered cusomer? Please <a href=\"register.jsp\">register</a>!");
            }
            session.setAttribute("loginCount",loginAttempt);
            dispatcher = request.getRequestDispatcher("login.jsp");
        }
			dispatcher.forward(request, response);
	}
}
