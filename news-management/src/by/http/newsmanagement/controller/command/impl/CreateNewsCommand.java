package by.http.newsmanagement.controller.command.impl;


import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.entity.ParameterForm;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

//import org.apache.log4j.Logger;

public class CreateNewsCommand implements Command {

	public CreateNewsCommand() {
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String title;
		String brief;
		String content;
		LocalDate date;

		title = request.getParameter(ParameterForm.TITLE);
		brief = request.getParameter(ParameterForm.BRIEF);
		content = request.getParameter(ParameterForm.CONTENT);
		date = ParameterForm.DATE;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();

		News news = new News(title, brief, content, date);

		System.out.println(news);

		try {
			newsService.create(news);
			request.getSession().setAttribute("result_operation", "New news added successfully!");
		} catch (ServiceException e) {
			request.getSession().setAttribute("result_operation", "No news added, somethinhg was wrong");
			response.sendRedirect(ParameterUrlController.WELCOME_PAGE);//
		}
		response.sendRedirect(ParameterUrlController.WELCOME_PAGE);
	}
}
