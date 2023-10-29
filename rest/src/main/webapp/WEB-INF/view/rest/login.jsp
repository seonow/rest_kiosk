<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="/resources/css/login.css">
<script type="text/javascript" src="../../resources/js/login.js" defer></script>


</head>
<body>
	<section id="main">
		<form name="loginForm" id="login">
		<div id="loginforms">
			<div class="id"><p>아이디</p><input type="text" name="id" id="id" size = 30></div> <br><br>
			<div class="pw"><p>비밀번호</p><input type="password" name="pw" id="pw" size = 30></div> <br>
		</div>
		<button id="loginBtn">로그인</button>
		</form>
	</section>
	
</body>
</html>