<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/order.css">
<script type="text/javascript" src="../../resources/js/jquery-3.6.2.js"></script>
<script type="text/javascript" src="../../resources/js/order.js" defer></script>
</head>
<body>
<!-- ===============[banner]================== -->
	
	<header>
		<div style="display: flex; justify-content: space-between; align-items: center;">
			<br>
			<jsp:include page="./incl/banner.jsp">
				<jsp:param value="<%=URLEncoder.encode(\"  \", \"UTF-8\") %>" name="subTitle"/>
			</jsp:include>
			<div id="back">
				<a href="/start">Back</a>
			</div>
		</div>

		<hr>
	</header>
<!-- ===============[banner]================== -->
	<h2>메뉴선택</h2>
	<section id="main">
		<div>
			<div>
				<ul class="menuCategory">
					<li><a href="#">한식</a></li>
					<li><a href="#">중식</a></li>
					<li><a href="#">일식</a></li>
					<li><a href="#">분식</a></li>
				</ul>
			</div>
			<div class="menuList">
				<div class="korean">
					<div class="submenu">
						<c:forEach items="${menuList}" var="Allmenu">
							<c:if test="${Allmenu.categorie == '한식'}">
								<form:form method="post" action="/menu/cart" modelAttribute="cart">
									<div class="menubox">
										<a href="#"><img src="../../resources/img/${Allmenu.name}.jpg"></a>
										<p>${Allmenu.name}</p>
										<p>${Allmenu.price}</p>
										<p class="hidden"><input type="hidden" name="quantity" value="1" /></p>
										<input type="hidden" name="mname" value="${Allmenu.name}" />
										<p><input type="submit" value="추가하기"></p>
									</div>
								</form:form>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="china">
					<div class="submenu">
						<c:forEach items="${menuList}" var="Allmenu">
							<c:if test="${Allmenu.categorie == '중식'}">
								<form:form method="post" action="/menu/cart" modelAttribute="cart">
									<div class="menubox">
										<a href="#"><img src="../../resources/img/${Allmenu.name}.jpg"></a>
										<p>${Allmenu.name}</p>
										<p>${Allmenu.price}</p>
										<p class="hidden"><input type="hidden" name="quantity" value="1" /></p>
										<input type="hidden" name="mname" value="${Allmenu.name}" />
										<p><input type="submit" value="추가하기"></p>
									</div>
								</form:form>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="japan">
					<div class="submenu">
						<c:forEach items="${menuList}" var="Allmenu">
							<c:if test="${Allmenu.categorie == '일식'}">
								<form:form method="post" action="/menu/cart" modelAttribute="cart">
									<div class="menubox">
										<a href="#"><img src="../../resources/img/${Allmenu.name}.jpg"></a>
										<p>${Allmenu.name}</p>
										<p>${Allmenu.price}</p>
										<p class="hidden"><input type="hidden" name="quantity" value="1" /></p>
										<input type="hidden" name="mname" value="${Allmenu.name}" />
										<p><input type="submit" value="추가하기"></p>
									</div>
								</form:form>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="school">
					<div class="submenu">
						<c:forEach items="${menuList}" var="Allmenu">
							<c:if test="${Allmenu.categorie == '분식'}">
								<form:form method="post" action="/menu/cart" modelAttribute="cart">
									<div class="menubox">
										<a href="#"><img src="../../resources/img/${Allmenu.name}.jpg"></a>
										<p>${Allmenu.name}</p>
										<p>${Allmenu.price}</p>
										<p class="hidden"><input type="hidden" name="quantity" value="1" /></p>
										<input type="hidden" name="mname" value="${Allmenu.name}" />
										<p><input type="submit" value="추가하기"></p>
									</div>
								</form:form>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="./include/cart.jsp"></jsp:include>
</body>
</html>