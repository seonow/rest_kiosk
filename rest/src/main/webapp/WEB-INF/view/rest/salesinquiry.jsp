<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기간별 매출조회 결과</title>
<link rel="stylesheet" href="../../resources/css/salesinquiry.css">
</head>
<body>
	<header>
		<a href="/admin">Back</a>
	</header>
	<h1>기간별 매출조회 결과</h1><hr>
	<section>
	<form action="/rest/salesinquiry" method="get">
	    <label for="startDate">시작일</label>
	    <input type="date" id="startDate" name="startDate" value="${param.startDate}">
	    <label for="endDate">종료일</label>
	    <input type="date" id="endDate" name="endDate" value="${param.endDate}">
	    <input type="submit" value="조회">
	</form>
	<table>
		<thead>
			<tr>
				<th>주문번호</th>
				<th>메뉴명</th>
				<th>수량</th>
				<th>판매가격</th>
				<th>주문일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sale" items="${sales}">
				<tr>
					<td>${sale.onum}</td>
					<td>${sale.menuId}</td>
					<td>${sale.quantity}개</td>
					<td>${sale.salePrice}원</td>
					<td>${sale.orderDate}</td>
				</tr>
				<c:set var="totalSales" value="${totalSales + sale.salePrice}"/>
			</c:forEach>
		</tbody>
	</table>
	</section>
	<p>총 매출: ${totalSales} 원</p>
</body>
</html>