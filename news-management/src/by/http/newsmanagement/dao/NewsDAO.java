package by.http.newsmanagement.dao;

import java.util.List;

import by.http.newsmanagement.entity.News;

public interface NewsDAO {
	
	void create(News news) throws DAOException; 

	void deleteByID(int id) throws DAOException;

	void updateByID(News news, int id) throws DAOException;
	
	News selectByID(int id) throws DAOException;

	List<News> selectAll() throws DAOException;

	void deleteByIDSelected(Integer[] id) throws DAOException;
}
