package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.entity.ParameterForm;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

//import org.apache.log4j.Logger;

public class ViewNewsCommand implements Command {

	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		Integer id = 0;
		try {
			id = Integer.parseInt(request.getParameter(ParameterForm.ID));
		} catch (NumberFormatException e) {
		}

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();

		News news = new News();

		try {
			news = newsService.select (id);
		} catch (ServiceException e) {
			request.getSession().setAttribute("result_operation", "No news, somethinhg was wrong");//
			response.sendRedirect(ParameterUrlController.WELCOME_PAGE);//
		}

		session.setAttribute("current_news", news);
		
		response.sendRedirect("controller?command=localization_view_news_command");
	}
}
