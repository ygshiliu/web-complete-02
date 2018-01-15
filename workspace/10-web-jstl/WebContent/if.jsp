<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 与java中的if语句一样，用来做分支处理 -->
	<!-- test属性用来接收一个布尔值 ，也可以定义一个EL表达式，如果为true则执行标签体中的内容，如果为false则不执行 -->
	<!-- 注意这里没有else语句 -->
	<!-- 可以通过写两次，test属性取反来达到if...else效果 -->
	<c:if test="${empty param.flag }">
		<h3>老师最好啦</h3>
	</c:if>
	
	<c:if test="${param.flag }">
		<h3>老师棒棒的</h3>
	</c:if>
	
	<c:set value="60" var="score"></c:set>
	
	<!-- 可以实现java中的if...else if...else if...else -->
	<!-- c:when 与 c:otherwise不能脱离c:choose单独使用 -->
	<!-- c:when可以出现多次，c:otherwise只能出现 一次 -->
	<!-- c:when中的与c:if中的test属性一样，用来接收一个布尔值 -->
	<!-- 多个c:when之间有大小逻辑的排列，逻辑最严紧的放在前面，逻辑宽松的放在后面，只要有一个符合要求，后面就不会执行-->
	<!-- c:otherwise会在所有c:when都不符合条件的情况下才会执行 -->
	<c:choose>
		<c:when test="${score>=100 }">
			优秀
		</c:when>
		<c:when test="${score>80 }">
			良好
		</c:when>
		 <c:when test="${score >= 60 }">
		 	及格
		 </c:when>
		<c:otherwise>
			不及格
		</c:otherwise> 
	</c:choose>
	
</body>
</html>