<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/cart.css">
<script type="text/javascript">
	// 수량 변경 함수
	function changeQuantity(element, value) {
		var input = element.parentNode.querySelector('input[type="number"]');
		input.value = parseInt(input.value) + value;
	}
</script>
</head>
<body>
	<h3>장바구니</h3>
	<c:forEach items="${cart.lineItemList}" var="lineItem">
		<c:if test="${lineItem.quantity >= 1}">
			<tr>
				<form:form modelAttribute="cart" action="/menu/cart/updateQuantity">
					<td>[${lineItem.menu.name}]</td>
					<td><label path="quantity">${lineItem.quantity}</label></td>개
					가격	: <td>${lineItem.salePrice}</td>원
					<td>
                        <button type="button" onclick="changeQuantity(this, -1)">-</button>
                        <input id="quantity" type="number" name="quantity" value="1" max="999"/>
                        <button type="button" onclick="changeQuantity(this, 1)">+</button>
                    </td>
					<input type="hidden" name="mname" value="${lineItem.menu.name}" />

					<td><input type="submit" value="변경하기"></td>
				</form:form>
			</tr>
		</c:if>
	</c:forEach>

	<form action="/cart/checkout">
		<input type="submit" value="결제하기">
	</form>
</body>
</html>