<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/menulist.css">
</head>
<body>
   <div class="wrap">
      <ul id="login">
         <li><a href="/rest/menulist">메뉴조회</a></li>
         <li><a href="/rest/salelist">주문조회</a></li>
         <li><a href="/rest/salesinquiry">매출조회</a></li>
         <li><a href="/rest/logout">로그아웃</a></li>
      </ul>
   </div>
   <h2>메뉴조회</h2>
   <div id="ml">
      <section id="main">
         <table>
            <tr>
               <th>카테고리</th>
               <th>메뉴명</th>
               <th>가격</th>
            </tr>
            <c:forEach items="${menuList}" var="Allmenu">
               <tr>
                  <td>${Allmenu.categorie}</td>
                  <td>${Allmenu.name}</td>
                  <td>${Allmenu.price}</td>
               </tr>
            </c:forEach>
         </table>
      </section>
      <div id="menulist">
         <a href="/rest/addmenu">메뉴추가</a> <a href="/rest/deletemenu">메뉴삭제</a>
         <a href="/rest/updatemenu">가격수정</a>
      </div>
   </div>

</body>
</html>