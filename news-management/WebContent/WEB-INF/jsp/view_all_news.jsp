<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page errorPage="error.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LATEST NEWS</title>
<link href="news.css" rel="stylesheet">
</head>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="reference.russian" var="button_ru" />
<fmt:message bundle="${loc}" key="reference.english" var="button_en" />

<fmt:message bundle="${loc}" key="table.logo" var="table_logo" />

<fmt:message bundle="${loc}" key="button.create-news" var="button_create_news" />
<fmt:message bundle="${loc}" key="button.list-all-news" var="button_list_all_news" />

<fmt:message bundle="${loc}" key="form.logo" var="form_logo" />
<fmt:message bundle="${loc}" key="form.title" var="form_title" />
<fmt:message bundle="${loc}" key="form.brief" var="form_brief" />
<fmt:message bundle="${loc}" key="form.content" var="form_content" />
<fmt:message bundle="${loc}" key="form.date" var="form_date" />

<fmt:message bundle="${loc}" key="button.delete-selected" var="button_delete_selected" />
<fmt:message bundle="${loc}" key="button.back" var="button_back" />

<fmt:message bundle="${loc}" key="reference.view" var="reference_view" />
<fmt:message bundle="${loc}" key="reference.edit" var="reference_edit" />
<fmt:message bundle="${loc}" key="reference.delete" var="reference_delete" />

<body>
	<p align="right">
		<a href="controller?command=localization&local=en&current_command=view_all_news">${button_en}</a>
		<a href="controller?command=localization&local=ru&current_command=view_all_news">${button_ru}</a>
	</p>

	<h1 align="left"><font color="red">${table_logo}</font></h1>
 
  	<form action="controller" method="GET">
		<input type="hidden" name="command" value="fill_news" /> 
		<input type="submit" name="submit" value = "${button_create_news}" class="myButton">
	</form>
	<form action="controller" method="GET">
		<input type="hidden" name="command" value="view_all_news" /> 
		<input type="submit" name="submit" value="${button_list_all_news}" class="myButton"/>
	</form>
	<br>
	<form action="controller" method="POST">
		<input type="hidden" name="command" value="delete_selected_news" /> 
		<fieldset>
			<legend>${form_logo}</legend>
				<c:forEach items="${news}" var="news">
				<table class="class1" border="1">
					<tr style="width: 414px; ">
						<td>
							<table class="classhorisontalalightop">
								<tr>
									<td><b>${form_title}:</b></td>
									<td> <c:out value="${news.title}" /> </td>
								</tr>
								<tr>
									<td><b>${form_brief}:</b></td>
									<td> <c:out value="${news.brief}" /> </td>
								</tr>
								<tr>
									<td><b>${form_date}:</b></td>
									<td class="classhorisontalalightop"><c:out value=" ${news.date}" /></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<p align="right">
    							<a href="controller?command=view_news&id=${news.id}">${reference_view}</a>
								<a href="controller?command=update_news&id=${news.id}">${reference_edit}</a>
								<a href="controller?command=delete_news&id=${news.id}">${reference_delete}</a>
								<input type="checkbox" name="delete_selected_news" value="${news.id}" >
    						</p>
						</td>
  					</tr>			
				</table>
				<br>
				</c:forEach>
          		<input type="submit" name="submit" value = "${button_delete_selected}" class="myButton" align="right">
		</fieldset>
		<br>
		<input type="button" onclick="history.back();" value="${button_back}" class="myButton"/>
	</form>
</body>
</html>