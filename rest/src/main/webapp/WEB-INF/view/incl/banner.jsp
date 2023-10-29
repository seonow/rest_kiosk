<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<div style="padding-left:20px">
	<h1><a href="http://localhost:8080/order">REST</a></h1>
	<h3><%=URLDecoder.decode(request.getParameter("subTitle"), "UTF-8") %></h3>
</div>