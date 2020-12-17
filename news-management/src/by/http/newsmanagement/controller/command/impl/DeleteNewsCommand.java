package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.ParameterForm;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

public class DeleteNewsCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		Integer id = 0;
		try {
			id = Integer.parseInt(request.getParameter(ParameterForm.ID));
		} catch (NumberFormatException e) {
		}

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();

		try {
			newsService.delete (id);
			request.getSession().setAttribute("result_operation", "Delete successfully");
		} catch (ServiceException e) {
			request.getSession().setAttribute("result_operation", "No news deleted, somethinhg was wrong");//
			response.sendRedirect(ParameterUrlController.WELCOME_PAGE);//
		} response.sendRedirect(ParameterUrlController.WELCOME_PAGE);
	}
}
