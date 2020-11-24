package by.http.newsmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.http.newsmanagement.dao.DAOException;
import by.http.newsmanagement.dao.DAOProvider;
import by.http.newsmanagement.dao.NewsDAO;
import by.http.newsmanagement.entity.News;
import by.http.newsmanagement.service.NewsService;
import by.http.newsmanagement.service.ServiceException;
import by.http.newsmanagement.service.validation.NewsValidation;

public class NewsServiceImpl implements NewsService{

	@Override
	public void create(News news) throws ServiceException {

		if (NewsValidation.isFormEmptyData(news)) {
			throw new ServiceException("Some of the fields: 'title', 'brief', 'content' are empty");
		}

		if (NewsValidation.isFormFieldOverLength(news)) {
			throw new ServiceException("Some of the fields: 'title', 'brief', 'content' are overlength");
		}

		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();

		try {
			sqlNewsDao.create(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> selectAll() throws ServiceException {

		List<News> news = new ArrayList<>();

		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();

		try {
			news = sqlNewsDao.selectAll();
		} catch (DAOException e) {
			throw new ServiceException("Error performing method: sqlNewsDao.selectAll() ", e);
		}
		return news;
	}

	@Override
	public void update(News news, Integer id) throws ServiceException {
		
		
		/**if (NewsValidation.isFormEmptyData(news)) {
			throw new ServiceException("Some of the fields: 'title', 'brief', 'content' are empty");
		}

		if (NewsValidation.isFormFieldOverLength(news)) {
			throw new ServiceException("Some of the fields: 'title', 'brief', 'content' are overlength");
		}

		if (!NewsValidation.isIDNumber(id)) {
			throw new ServiceException(id + " is not digit");
		}

		if (!NewsValidation.isIDCorrect(id)) {
			throw new ServiceException(id + " is not in correct number range");
		}
		*/
		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();

		
		
		
		
		
		try {
			sqlNewsDao.updateByID(news, id);
			
		} catch (DAOException e) {
			
			throw new ServiceException("Error in method: sqlNewsDao.update(news, id) ", e);
			
		}
		
	}

	@Override
	public void delete (int id) throws ServiceException {

		if (!NewsValidation.isIDNumber(id)) {
			throw new ServiceException(id + " is not digit");
		}
		
		if (!NewsValidation.isIDCorrect(id)) {
			throw new ServiceException(id + " is not in correct number range");
		}
		
		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();

		try {
			sqlNewsDao.deleteByID(id);
		} catch (DAOException e) {
			throw new ServiceException("Error performing sqlNewsDao.deleteByID(id)", e);
		}
	}

	@Override
	public News select (Integer id) throws ServiceException {

		if (!NewsValidation.isIDNumber(id)) {
			throw new ServiceException(id + " is not digit");
		}

		if (!NewsValidation.isIDCorrect(id)) {
			throw new ServiceException(id + " is not in correct number range");
		}

		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();

		News news = new News();

		try {
			news = sqlNewsDao.selectByID(id);
		} catch (DAOException e) {
			throw new ServiceException("Error performing sqlNewsDao.selectByID(id) ", e);
		}
		return news;
	}

	@Override
	public void deleteSelected (String[] idString) throws ServiceException {

		DAOProvider daoProvider = DAOProvider.getInstance();
		NewsDAO sqlNewsDao = daoProvider.getNewsDAO();
		
		Integer[] idInt = new Integer[idString.length];
		
		for(int i = 0; i < idString.length; i++) {
			idInt[i] = Integer.parseInt(idString[i]);
		}
				
		try { sqlNewsDao.deleteByIDSelected(idInt);
		} catch (DAOException e) {
			throw new ServiceException("sqlNewsDao.deleteByIDSelected(idInt)", e);
		}
	}
}