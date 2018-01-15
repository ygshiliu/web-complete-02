<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>3.jsp</h1>
	<!-- include指令 -->
	<!-- 作用：是将被包含的页面的html代码原封不动的复制到当前页面 -->
	<!-- 注意：include指令属于静态包含，它只会翻译当前jsp文件 -->
	<%@ include file="4.jsp" %>
</body>
</html>