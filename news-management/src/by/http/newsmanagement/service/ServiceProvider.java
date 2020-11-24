package by.http.newsmanagement.service;

import by.http.newsmanagement.service.impl.NewsServiceImpl;

public class ServiceProvider {
	
	private static final ServiceProvider instance = new ServiceProvider();

	private final NewsService newsServiceImpl = new NewsServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public NewsService getNewsService() {
		return newsServiceImpl;
	}
}
