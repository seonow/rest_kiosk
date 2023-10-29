<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/update_menu.css">
</head>
<body>
	<h2>메뉴추가</h2>
	<form:form method="post" modelAttribute="menuCommand">
		<label for="name">메뉴명</label>
		<form:input path="name"/><br>
		
		<label for="price">금액</label>
		<form:input path="price"/><br>
		
      	<input type="submit" value="메뉴수정">
	</form:form>

</body>
</html>