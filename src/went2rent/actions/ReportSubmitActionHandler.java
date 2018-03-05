package went2rent.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import went2rent.service.ReportService;

public class ReportSubmitActionHandler implements ActionHandler {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String report = request.getParameter("report");
		
	}

	
}
