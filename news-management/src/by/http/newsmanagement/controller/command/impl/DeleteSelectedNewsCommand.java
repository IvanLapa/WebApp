package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.ParameterUrlController;
import by.http.newsmanagement.controller.command.Command;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.ServiceProvider;

//import org.apache.log4j.Logger;

public class DeleteSelectedNewsCommand implements Command{
//private static Logger logger = Logger.getLogger(DeleteNewsSelectedCommandImpl.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.setContentType("text/html");
		
		String DELETE_SELECTED_NEWS = "delete_selected_news";
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService newsService = serviceProvider.getNewsService();
		
		try {
			String[] newsToDeleteIds = request.getParameterValues(DELETE_SELECTED_NEWS);
			if (newsToDeleteIds != null) {
				newsService.deleteSelected (newsToDeleteIds);
				request.getSession().setAttribute("result_operation", "Group delete successfully");
				response.sendRedirect(ParameterUrlController.WELCOME_PAGE);	
			} else {
				request.getSession().setAttribute("result_operation", "News was not select");
				response.sendRedirect(ParameterUrlController.WELCOME_PAGE);	
			}
		} catch (ServiceException e) {
			request.getSession().setAttribute("result_operation", "Newsgroup not deleted, somethinhg was wrong");//
			response.sendRedirect(ParameterUrlController.WELCOME_PAGE);//
		}				
	}
}