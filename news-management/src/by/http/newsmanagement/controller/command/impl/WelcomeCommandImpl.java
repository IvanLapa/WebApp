package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;

public class WelcomeCommandImpl implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		RequestDispatcher requestDispatcherError = request.getRequestDispatcher(ParameterUrlController.MAIN_PAGE);
		requestDispatcherError.forward(request, response);
	}
}
