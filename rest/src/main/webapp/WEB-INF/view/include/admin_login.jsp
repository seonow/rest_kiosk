<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../resources/css/admin_login.css">
<c:choose>
	<c:when test="${not empty user}">
		<div class="wrap">
			<ul id="login">
				<li><a href="/rest/menulist">메뉴조회</a></li>
				<li><a href="/rest/salelist">주문조회</a></li>
				<li><a href="/rest/salesinquiry">매출조회</a></li>
				<li><a href="/rest/logout">로그아웃</a></li>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
		<div class="wrap">
			<ul id="login">
				<li><a href="/login">로그인</a></li>
				<li><a href="/start">BACK</a></li>
			</ul>
		</div>
	</c:otherwise>
</c:choose>