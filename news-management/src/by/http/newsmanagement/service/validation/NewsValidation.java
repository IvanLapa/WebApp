package by.http.newsmanagement.service.validation;

import by.http.newsmanagement.entity.News;

//import org.apache.log4j.Logger;

public class NewsValidation {

	public static boolean isFormEmptyData(News news) {

		if ("".equals(news.getTitle()) || "".equals(news.getBrief())
				|| "".equals(news.getContent())) {
			return true;
		}
		return false;
	}

	public static boolean isFormFieldOverLength(News news) {

		final int FORM_TITLE_LENGTH = 45;
		final int FORM_BRIEF_LENGTH = 200;
		final int FORM_CONTENT_LENGTH = 1000;

		if (news.getTitle().length() > FORM_TITLE_LENGTH || 
				news.getBrief().length() > FORM_BRIEF_LENGTH || 
				news.getContent().length() > FORM_CONTENT_LENGTH) {
			return true;
		} 
		return false;
	}

	public static boolean isIDCorrect(int id) {

		final int ID_MIN = 1;
		final int ID_MAX = 999999;

		if (id >= ID_MIN && id <= ID_MAX) {
			return true;
		}
		return false;
	}

	public static boolean isIDNumber(Integer id) {

		if (id instanceof Number) {
			return true;
		}
		return false;
	}
}