<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="http://localhost:8080/10-web-jstl/">
</head>
<body>
	<!-- 
		在页面中设置绝对路径有几种方式？
		1、使用base标签 ： <base href="http://localhost:8080/10-web-jstl/">
		2、使用c:url标签 ，会自动为绝对路径加上项目名
		3、使用c:set标签向域中设置一个项目名属性：
			c:set var="ctx" value="${pageContext.request.contextPath}"
	
	 -->
	
	<!-- 自动为绝对路径加上项目名 -->
	<!-- value属性指定要设置的路径 -->
	<!-- var属性指定设置进域中属性名 -->
	<!-- scope指定要设置进哪个域对象中 -->
	<!-- c:url可以定义一个子标签 c:param -->
	<!-- c:param用来定义一个请求参数，请求参数会自动进行url编码 -->
	<c:url value="/index.jsp" var="url" >
		<c:param name="name" value="haha"></c:param>
		<c:param name="name" value="宋智孝"></c:param>
	</c:url>
	
	${url }
	
	

</body>
</html>