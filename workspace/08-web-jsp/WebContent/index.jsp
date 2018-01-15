<%@page import="java.util.Date"%>
<!-- 告诉服务器如何解析jsp文件 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>index.jsp</h1>
	
	<%
		//向控制台输出一条语句
		System.out.print("我来自JSP页面");
		
		Date date = new Date();
	
	%>
	
	<!-- 将日期输出到页面中 -->
	<%=date %>
	
</body>
</html>