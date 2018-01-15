<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 使用taglib指令导入核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 向域中设置属性 -->
	<!-- var用来定义在域中属性的名字 -->
	<!-- value用来指定属性的值  -->
	<!-- scope用来指定将属性设置在哪个域 中,默认是pageScope -->
	<c:set var="name" value="haha" scope="session" ></c:set>
	
	<!-- 向页面输出信息 -->
	<!-- default属性是一个默认值 ，当value为null时，显示默认值 -->
	<!-- escapeXml属性指定一个布尔值 ，代表value值如果有特殊字符是否自动转义，默认为true不转义 -->
	<c:out value="${name }" default="<script>alert('aaa')</script>" escapeXml="true"></c:out>
	
	<!-- 从域中删除名字相同的属性，默认是全域删除-->
	<!-- scope用来指定删除哪个域中的属性 -->
	<c:remove var="name" scope="request"/>
	${sessionScope.name } 
</body>
</html>