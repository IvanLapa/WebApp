package by.http.newsmanagement.controller.command.impl;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.http.newsmanagement.controller.command.Command;

//import org.apache.log4j.Logger;

public class LocalizationCommand implements Command, Serializable {
	private static final long serialVersionUID = -8722600163795882694L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		request.getSession(true).setAttribute("local", request.getParameter("local"));
		
		String currentCommand = request.getParameter("current_command");	
		
		response.sendRedirect("controller?command="+ currentCommand);
	}
}
