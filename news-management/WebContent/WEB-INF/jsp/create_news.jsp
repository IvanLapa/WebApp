<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CREATE NEWS</title>
<link href="news.css" rel="stylesheet">
</head>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="reference.russian" var="button_ru" />
<fmt:message bundle="${loc}" key="reference.english" var="button_en" />
<fmt:message bundle="${loc}" key="table.logo" var="table_logo" />
<fmt:message bundle="${loc}" key="button.create-news" var="button_create_news" />
<fmt:message bundle="${loc}" key="button.list-all-news" var="button_list_all_news" />

<fmt:message bundle="${loc}" key="form.title" var="form_title" />
<fmt:message bundle="${loc}" key="form.brief" var="form_brief" />
<fmt:message bundle="${loc}" key="form.content" var="form_content" />

<fmt:message bundle="${loc}" key="button.back" var="button_back" />
<fmt:message bundle="${loc}" key="button.create" var="button_create" />

<fmt:message bundle="${loc}" key="reference.view" var="reference_view" />
<fmt:message bundle="${loc}" key="reference.edit" var="reference_edit" />
<fmt:message bundle="${loc}" key="reference.delete" var="reference_delete" />

<fmt:message bundle="${loc}" key="operation.create-news.logo" var="operation_create_news_logo" />

<body>
	<p align="right">
		<a href="controller?command=localization&local=en&current_command=localization_create_news_command">${button_en}</a> 
		<a href="controller?command=localization&local=ru&current_command=localization_create_news_command">${button_ru}</a>
	</p>
	
	<h1 align="left"><font color="red">${table_logo}</font></h1>
		
	<form action="controller" method="GET">
		<input type="hidden" name="command" value="fill_news" /> 
		<input type="submit" name="submit" value = "${button_create_news}" class="myButton">
	</form>
	<form action="controller" method="GET">
		<input type="hidden" name="command" value="view_all_news" /> 
		<input type="submit" name="submit" value = "${button_list_all_news}" class="myButton">
	</form>
	<br>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="create_news" /> 
		<fieldset>
			<legend>${operation_create_news_logo}</legend>
			<p>
				<label for="name">${form_title}</label>
				<br>
				<input type="text"  name="title">
			</p>
			<p>
				<label for="name">${form_brief}</label>
				<br>
				<input type="text" name="brief">
			</p>
			<p>
				<label for="name">${form_content}</label>
				<br>
				<textarea name="content"></textarea>
			</p>
			<input type="submit" name="submit" value = "${button_create}" class="myButton">
			<br>	
		</fieldset>
		<br>
		<input type="button" onclick="history.back();" value="${button_back}" class="myButton"/>
	</form>
</body>
</html>