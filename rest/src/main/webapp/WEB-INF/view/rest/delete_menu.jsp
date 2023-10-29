<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../resources/css/delete_menu.css">
</head>
<body>
	<div id="back">
		<a href="/rest/menulist">BACK</a>
	</div>
	<h2>메뉴삭제</h2>
	<section id="main">
		<table>
			<tr>
				<th>카테고리</th>
				<th>메뉴명</th>
				<th>가격</th>
			</tr>
		<c:forEach items="${menuList}" var="Allmenu">
			<tr>
				<td>${Allmenu.categorie}</td>
				<td>${Allmenu.name}</td>
				<td>${Allmenu.price}</td>
			</tr>
		</c:forEach>
		</table>
	</section>
	<form:form  method="post" modelAttribute="menuCommand">
		<div class="menusc">
			<label id="name" for="name">메뉴명</label>
			<form:input class="delete" path="name"/><br>
	      	<input class="bt" type="submit" value="메뉴삭제">
      	</div>
	</form:form>
</body>
</html>