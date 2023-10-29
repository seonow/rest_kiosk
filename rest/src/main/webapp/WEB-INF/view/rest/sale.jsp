<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
<link rel="stylesheet" href="../../../resources/css/sale.css">

</head>
<body>
<!-- ===============[banner]================== -->
	
	<header>
		<div>
			<br>
			<jsp:include page="../incl/banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\"  \", \"UTF-8\") %>" name="subTitle"/>
			</jsp:include>
			<br>
		</div>
		<hr>
	</header>
<!-- ===============[banner]================== -->
   <h2>결제</h2>
   <section id="main">
   
   		
      <form:form method="post" action="/sale/success" modelAttribute="sale">
      	 	
		<label>카드사 : </label>	 	
			<select id="card">
				<option value="NH">농협은행</option>
				<option value="KB">국민은행</option>
				<option value="KAKAO">카카오뱅크</option>
				<option value="IBK">기업은행</option>
				<option value="SH">신한은행</option>
				<option value="WR">우리은행</option>
			</select><br>
			
			<label id="cardNum">카드번호 : </label>	 
			<input type="text" maxlength="4" size="4"> - 
			<input type="text" maxlength="4" size="4"> -
			<input type="password" maxlength="4" size="4"> - 
			<input type="password" maxlength="4" size="4"><br>
			
      	
         <c:forEach items="${cart.lineItemList}" var="cart">
            <c:set var="total" value="${total + cart.salePrice}" />
         </c:forEach>
            결제금액 : ${total}
            <input type="submit" value="결제하기">
            
      </form:form>
   </section>
</body>
</html>