package by.http.newsmanagement.dao;

import by.http.newsmanagement.dao.impl.SQLNewsDAOImpl;

public class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private final NewsDAO newsDAO = new SQLNewsDAOImpl();
	
	private DAOProvider() {};
	
	public static DAOProvider getInstance() {
		return instance;
	}
	
	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
}
