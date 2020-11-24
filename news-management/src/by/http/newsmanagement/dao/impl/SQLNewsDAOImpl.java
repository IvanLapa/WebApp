package by.http.newsmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.http.newsmanagement.dao.DAOException;

//import org.apache.log4j.Logger;

import by.http.newsmanagement.dao.NewsDAO;
import by.http.newsmanagement.dao.pool.ConnectionPool;
import by.http.newsmanagement.entity.News;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class SQLNewsDAOImpl implements NewsDAO {
	private final ConnectionPool pool = ConnectionPool.getInstance();

	private static final String SQL_CREATE_NEWS = "INSERT INTO news (title, brief, content, date) VALUES (?, ?, ?, ?)";
	private static final String SQL_DELETE_NEWS = "DELETE FROM news WHERE id = ?";
	private static final String SQL_UPDATE_NEWS = "UPDATE `news_management`.`news` SET `title` = ?, `brief` = ?, `content` = ?, `date` = ? WHERE (`id` = ?)";
			
			//"UPDATE news SET  title = ?, brief = ?, content = ?, date = ? WHERE id = ?";
	
	private static final String SQL_SELECT_NEWS = "SELECT * FROM news WHERE id = ?";
	private static final String SQL_SELECT_ALL_NEWS = "SELECT * FROM news";

	@Override
	public void create (News news) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();

			ps = con.prepareStatement(SQL_CREATE_NEWS);
			
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setDate(4, Date.valueOf(news.getDate()));
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			pool.closeConnection(con, ps);
		}
	}

	@Override
	public void deleteByID (int id) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = pool.takeConnection();

			ps = con.prepareStatement(SQL_DELETE_NEWS);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			pool.closeConnection(con, ps);
		}
	}

	@Override
	public void updateByID(News news, int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = pool.takeConnection();
			ps = con.prepareStatement(SQL_UPDATE_NEWS);

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBrief());
			ps.setString(3, news.getContent());
			ps.setDate(4, Date.valueOf(news.getDate()));
			ps.setInt(5, id);
			
			ps.executeUpdate();
			System.out.println("HERE");
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			pool.closeConnection(con, ps);
		}
	}

	@Override
	public List<News> selectAll() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		int id = 0;
		String title = null;
		String brief = null;
		String content = null;
		LocalDate date = null;

		List<News> selectAll = new ArrayList<>();

		try {
			con = pool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL_NEWS);

			while (rs.next()) {
				News news = new News();

				id = rs.getInt(1);
				title = rs.getString(2);
				brief = rs.getString(3);
				content = rs.getString(4);
				date = rs.getDate("date").toLocalDate();

				news.setId(id);
				news.setTitle(title);
				news.setBrief(brief);
				news.setContent(content);
				news.setDate(date);

				selectAll.add(news);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			pool.closeConnection(con, st, rs);
		}
		return selectAll;
	}

	@Override
	public News selectByID (int id) throws DAOException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		News newspaper = new News();

		String title = null;
		String brief = null;
		String content = null;
		LocalDate date = null;

		try {
			con = pool.takeConnection();

			ps = con.prepareStatement(SQL_SELECT_NEWS);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
				title = rs.getString(2);
				brief = rs.getString(3);
				content = rs.getString(4);
				date = rs.getDate("date").toLocalDate();

				newspaper.setId(id);
				newspaper.setTitle(title);			
				newspaper.setBrief(brief);
				newspaper.setContent(content);
				newspaper.setDate(date);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			pool.closeConnection(con, ps, rs);
		}
		return newspaper;
	}

	@Override
	public void deleteByIDSelected (Integer[] id) throws DAOException {
		for (int i = 0; i < id.length; i++) {
			deleteByID(id[i]);
		}
	}
}
