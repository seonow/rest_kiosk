<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kudangtang.rest.*" %>
<%@page import="java.net.URLEncoder" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REST</title>
<style>
	*{box-sizing: border-box;}
	body {margin: 0; padding: 0;}
	a{text-decoration: none; color:#000;}	
	
</style>
</head>
<body>

<!-- ===============[banner]================== -->
	
	<header>
		<div>
			<br>
			<jsp:include page="./banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\" REST \", \"UTF-8\") %>" name="subTitle"/>
			</jsp:include>
			<br>
		</div>
		<hr>
	</header>
<!-- ===============[banner]================== -->



	
</body>
</html>