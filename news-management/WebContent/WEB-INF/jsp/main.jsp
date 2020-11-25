<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>WELCOME</title>
	<link href="news.css" rel="stylesheet">
</head>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="reference.russian" var="button_ru" />
<fmt:message bundle="${loc}" key="reference.english" var="button_en" />
<fmt:message bundle="${loc}" key="table.logo" var="table_logo" />
<fmt:message bundle="${loc}" key="button.create-news" var="button_create_news" />
<fmt:message bundle="${loc}" key="button.list-all-news" var="button_list_all_news" />

<fmt:message bundle="${loc}" key="form.welcome" var="form_welcome" />
<fmt:message bundle="${loc}" key="result.operation.create" var="result_operation_create" />
<fmt:message bundle="${loc}" key="result.operation.update" var="result_operation_update" />
<fmt:message bundle="${loc}" key="result.operation-del" var="result_operation_del" />
<fmt:message bundle="${loc}" key="result.operation-del-group" var="result_operation_del_group" />

<fmt:message bundle="${loc}" key="result.operation-news-not-select" var="result_operation_news_not_select" />
<fmt:message bundle="${loc}" key="result.operation-news-no-current" var="result_operation_news_no_current" />



<body>
	<p align="right">
		<a href="controller?command=localization&local=en&current_command=localization_main_command">${button_en}</a>
		<a href="controller?command=localization&local=ru&current_command=localization_main_command">${button_ru}</a>
	</p>
	
	<h1 align="center"><font color="red"><c:out value="${table_logo}" /></font></h1>
	
	<p align="center">
		<c:out value="${form_welcome}" /> <br><br>
		<c:set var = "message" scope="session" value = "${sessionScope.result_operation}"/>
		<c:choose>
		<c:when test="${message eq 'New news added sucessfully'}">
		${result_operation_create}
		</c:when>
		<c:when test="${message eq 'Delete sucessfully'}">
		${result_operation_del}
		</c:when>
		<c:when test="${message eq 'Group delete sucessfully'}">
		${result_operation_del_group}
		</c:when>
		<c:when test="${message eq 'Update news sucessfully'}">
		${result_operation_update}
		</c:when>
		<c:when test="${message eq 'News was not select'}">
		${result_operation_news_not_select}
		</c:when>
		<c:when test="${message eq 'No current news'}">
		${result_operation_news_no_current}
		</c:when>
		<c:otherwise>
		${message}
		</c:otherwise>
		</c:choose>
		<c:remove var="result_operation" scope="session" />
	</p>
			
	<center>
		<form action="controller" method="GET">
			<input type="hidden" name="command" value="fill_news" /> 
			<input type="submit" name="submit" value = "${button_create_news}" class="myButton">
		</form>
		<br>	
		<form action="controller" method="GET">
			<input type="hidden" name="command" value="view_all_news" /> 
			<input type="submit" name="submit" value = "${button_list_all_news}" class="myButton">
		</form>
	</center>
</body>
</html>