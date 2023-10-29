<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../resources/css/sale_success.css">
</head>
<body>
	<!-- ===============[banner]================== -->

	<header>
		<div>
			<br>
			<jsp:include page="../incl/banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\"  \", \"UTF-8\")%>"
					name="subTitle" />
			</jsp:include>
			<br>
		</div>
		<hr>
	</header>
	<!-- ===============[banner]================== -->
	<h2>결제가 완료되었습니다</h2>
	<div class="receipt">
		<h3>주문 내역</h3>
		<table>
			<th>메뉴명</th>
			<th>수량</th>
			<th>가격</th>
			<c:forEach items="${lineItems}" var="lineItem">
				<c:set var="total" value="${total + lineItem.salePrice}" />
				<div class="receipt-item">
					<tr>
						<td class="item-name">${lineItem.menu.name}</td>
						<td class="item-quantity">${lineItem.quantity}개</td>
						<td class="item-price">${lineItem.salePrice}원</td>
					</tr>
				</div>
			</c:forEach>
		</table>
		<p>주문번호 : ${sales} </p>
		<p>총 결제금액 : ${total} 원</p>
	</div>
	<a href="http://localhost:8080/order" id="home">메뉴 화면으로 돌아가기</a>

</body>
</html>