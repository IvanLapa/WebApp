package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;

//import org.apache.log4j.Logger;

public class MainPageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(ParameterUrlController.MAIN_PAGE);
		
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
		}
	}
}