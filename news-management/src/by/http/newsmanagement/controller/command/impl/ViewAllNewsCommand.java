package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

//import org.apache.log4j.Logger;

public class ViewAllNewsCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		List<News> news = new ArrayList<>();
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();

		try {
			news = newsService.selectAll();
			if (news.isEmpty()) {
				request.getSession().setAttribute("result_operation", "No current news");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(ParameterUrlController.WELCOME_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("news", news);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(ParameterUrlController.VIEW_ALL_NEWS);
				requestDispatcher.forward(request, response);
			}
		} catch (ServiceException e) {
		}
	}
}
