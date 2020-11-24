package by.http.newsmanagement.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import by.http.newsmanagement.dao.pool.ConnectionPool;
import  by.http.newsmanagement.entity.News;

public class Main {
	public static void main(String[] args) throws SQLException {

		ConnectionPool pool = new ConnectionPool();
		
		Connection con = pool.takeConnection();
		
		String sql = "INSERT INTO news(id, title, brief, content, date) VALUES(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		News news = new News(5, "title5", "brief5", "content5", LocalDate.now());
		
		ps.setInt(1, news.getId());
		ps.setString(2, news.getTitle());
		ps.setString(3, news.getBrief());
		ps.setString(4, news.getContent());
		ps.setDate(5,  java.sql.Date.valueOf(news.getDate()));
		
		ps.executeUpdate();
		
		ps.close();		
		con.close();
		
		pool.dispose();
	    System.out.println("change to completed");
	}
}
