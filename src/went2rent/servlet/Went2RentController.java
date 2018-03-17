package went2rent.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import went2rent.actions.ActionHandler;
import went2rent.actions.*;

class URL {
	public final static String LOGIN = "/login";
	public final static String ABOUT = "/about";
	public final static String REPORT = "/report";
	public final static String ADDCAR = "/addcar";
	public final static String REGISTER = "/register";
	public final static String LOGOUT = "/logout";
	public final static String RESET = "/reset";
	public final static String AUTH = "/auth";
}

/**
 * Servlet implementation class Went2RentController
 */
@WebServlet(urlPatterns = { URL.LOGIN,
							URL.ABOUT,
							URL.REPORT,
							URL.ADDCAR,
							URL.REGISTER,
							URL.LOGOUT,
							URL.RESET,
							URL.AUTH} )

public class Went2RentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap <String, ActionHandler> actions;
       
    public Went2RentController() {
        super();
        actions = new HashMap <String, ActionHandler> ();
        
        actions.put(URL.LOGIN, new LogInActionHandler());
        actions.put(URL.REGISTER, new RegisterActionHandler());
        actions.put(URL.LOGOUT, new LogOutActionHandler());
        actions.put(URL.RESET, new ResetPasswordActionHandler());
        actions.put(URL.AUTH, new ForgotPasswordActionHandler());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actions.get(request.getServletPath()).execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		actions.get(request.getServletPath()).execute(request, response);
	}

}
