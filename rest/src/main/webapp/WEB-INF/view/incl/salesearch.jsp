<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 목록 조회</title>
</head>
<body>
	<table border="1">
					<tr>
						<th>주문번호</th>
						<th>메뉴명</th>
						<th>수량</th>
						<th>총액</th>
						<th>주문날짜</th>
					</tr>
		
		<c:forEach items="${saleList}" var="sale">
			<c:if test="${sale.onum eq param.onum}">
					<tr>
						<td>${sale.onum}</td>
						<td>${sale.menuId}</td>
						<td>${sale.quantity}</td>
						<td>${sale.salePrice}</td>
						<td>${sale.orderDate}</td>
					</tr>
				<br>
			</c:if>
		</c:forEach>
	</table>


</body>
</html>
