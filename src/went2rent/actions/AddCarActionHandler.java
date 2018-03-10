package went2rent.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import went2rent.beans.Car;
import went2rent.service.CarService;

public class AddCarActionHandler implements ActionHandler{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String car_name = request.getParameter("car_name");
		String car_platenumber = request.getParameter("car_platenumber");
		String car_color = request.getParameter("car_color");
		String path = request.getParameter("car_picture");
		
		Car c = new Car();
		
		if(path == null) {
			path = "default.jpg";
		}
		
		c.setCar_name(car_name);
		c.setCar_color(car_color);
		c.setCar_platenumber(car_platenumber);
		c.setPath(path);
		
		if(!CarService.addCar(c)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "db-connection-error");
			dispatcher.forward(request, response);
		}
		else {
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
	}
}
