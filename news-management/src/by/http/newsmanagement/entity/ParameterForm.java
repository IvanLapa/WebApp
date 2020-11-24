package by.http.newsmanagement.entity;

import java.time.LocalDate;

public class ParameterForm {
	
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String BRIEF = "brief";
	public static final String CONTENT = "content";
	public static final LocalDate DATE = LocalDate.now();
	
	public static final String COMMAND = "command";
	public static final String LOCALE = "locale";
	public static final String PAGE = "page";
	
	private ParameterForm() {
	}
}
