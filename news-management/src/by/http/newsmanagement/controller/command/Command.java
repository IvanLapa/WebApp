package by.http.newsmanagement.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.service.ServiceException;

public interface Command {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException;	
}
