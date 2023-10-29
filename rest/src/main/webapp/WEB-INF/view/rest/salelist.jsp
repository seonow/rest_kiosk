<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 조회</title>
<link rel="stylesheet" href="../../resources/css/salelist.css">
</head>
<body>
	<div id="back">
		<a href="javascript:window.history.go(-1);">BACK</a>
	</div>
	<h2>주문 목록 조회</h2>
	<table id="tablewrap">
		<thead>
			<tr>
				<th>주문번호</th>
				<th>메뉴명</th>
				<th>수량</th>
				<th>총액</th>
				<th>주문날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${saleList}" var="items">
				<tr>
					<td>${items.onum}</td>
					<td>${items.menuId}</td>
					<td>${items.quantity}</td>
					<td>${items.salePrice}</td>
					<td>${items.orderDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="${pageContext.request.contextPath}/rest/salelist">
		<input type="text" name="onum" placeholder="주문번호를 입력하세요."> <input
			type="submit" value="조회">
	</form>

	<jsp:include page="../incl/salesearch.jsp"></jsp:include>
</body>
</html>