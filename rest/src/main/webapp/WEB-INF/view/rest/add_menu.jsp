<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/add_menu.css">
<style>
	
</style>
</head>
<body>
	<h2>메뉴추가</h2>
	<form:form method="post" modelAttribute="menuCommand">
		<label for="categorie">카테고리</label>
		<form:input path="categorie"/><br>
	
		<label for="name">메뉴명</label>
		<form:input path="name"/><br>
		
		<label for="price">금액</label>
		<form:input path="price"/><br>
		
      	<input type="submit" value="메뉴추가">
	</form:form>
</body>
</html>