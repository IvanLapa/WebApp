package by.http.newsmanagement.service;

import java.util.List;

import by.http.newsmanagement.entity.News;

public interface NewsService {
	
	void create (News news) throws ServiceException;
	
	void update (News news, Integer id) throws ServiceException;
	
	News select (Integer id) throws ServiceException;

	void delete (int id) throws ServiceException;
	
	void deleteSelected (String[] id) throws ServiceException;
	
	List<News> selectAll () throws ServiceException;
}