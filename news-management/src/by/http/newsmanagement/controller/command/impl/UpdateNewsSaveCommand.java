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

public class UpdateNewsSaveCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {

		response.setContentType("text/html");
		
		Integer id = 0;
		LocalDate date;
		String title;
		String brief;
		String content;

		try {
			id = Integer.parseInt(request.getParameter(ParameterForm.ID));
		} catch (NumberFormatException e) {
		}

		date = ParameterForm.DATE;
		title = request.getParameter(ParameterForm.TITLE);
		brief = request.getParameter(ParameterForm.BRIEF);
		content = request.getParameter(ParameterForm.CONTENT);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();

		News news = new News(id, title,  brief, content, date);
		System.out.println(news);
		try {
			newsService.update(news, id);
		} catch (ServiceException e) {
			request.getSession().setAttribute("result_operation", "No news updated, somethinhg was wrong");//
			response.sendRedirect(ParameterUrlController.WELCOME_PAGE);//
		}

		request.getSession().setAttribute("result_operation", "Update news successfully");

		response.sendRedirect(ParameterUrlController.WELCOME_PAGE);
	}
}
