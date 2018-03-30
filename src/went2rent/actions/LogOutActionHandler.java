package went2rent.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutActionHandler implements ActionHandler {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("userID")) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		
		
		request.getSession().setAttribute("sessionuser", null);
		request.getSession(false);
		
		request.getRequestDispatcher("cata").forward(request, response);
		
	}

}
