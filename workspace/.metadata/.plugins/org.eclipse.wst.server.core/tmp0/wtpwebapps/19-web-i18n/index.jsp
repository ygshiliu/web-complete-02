<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		//获取Locale
		//Locale locale = request.getLocale();
		String localestr = request.getParameter("locale");
		Locale locale = null;
		locale=(localestr==null?(request.getLocale()):(new Locale(localestr)));
		//创建资源管理器类
		ResourceBundle rb = ResourceBundle.getBundle("i18n",locale);
	%>

	<h1><%=rb.getString("title") %></h1>
	
	<form action="" method="post">
		<%=rb.getString("username") %>：<input type="text" name="username"><br><br>
		<%=rb.getString("password") %>：<input type="password" name="password"><br><br>
		<input type="submit" value="<%=rb.getString("login") %>">
	</form>
	<br><br>
	<a href="index.jsp?locale=zh_CN">中文</a> | <a href="index.jsp?locale=en_US">English</a> --%>

<!-- 以下使用JSTL实现国际化 -->
	<!-- 手动指定locale，如果没有获取到将使用默认的 -->
	 <fmt:setLocale value="${param.locale}"/> 
	 <!-- 通过 fmt:setBundle与bundle指定资源文件的基础名 -->
	<%-- <fmt:setBundle basename="i18n"></fmt:setBundle>  --%>
	<fmt:bundle basename="i18n">
	<h1><fmt:message key="title"></fmt:message></h1>
	
	<form action="" method="post">
		<fmt:message key="username"></fmt:message>：<input type="text" name="username"><br><br>
		<fmt:message key="password"></fmt:message>：<input type="password" name="password"><br><br>
		<input type="submit" value='<fmt:message key="login"></fmt:message>'>
	</form>
	<br><br>
	<a href="index.jsp?locale=zh_CN">中文</a> | <a href="index.jsp?locale=en_US">English</a>
	
	<br><br>
	<fmt:formatDate value="<%=new Date() %>" type="both"/><br><br>
	<fmt:formatNumber value="<%=Integer.MAX_VALUE %>" ></fmt:formatNumber>
	</fmt:bundle> 
	
</body>
</html>