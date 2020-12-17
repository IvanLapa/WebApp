package by.http.newsmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.controller.command.CommandProvider;
import by.http.newsmanagement.entity.ParameterForm;
import by.http.newsmanagement.service.ServiceException;

public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String commandName;
		Command command;
		
		request.setCharacterEncoding("UTF-8");

		commandName = request.getParameter(ParameterForm.COMMAND);
		command = provider.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (ServletException | IOException | ServiceException e) {
			
			response.sendRedirect(ParameterUrlController.ERROR);
		}
	}
}
