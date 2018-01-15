<%@page import="com.atguigu.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
	<h1>学生列表</h1>
	<!-- 从域对象中获取学生列表  -->
	<!-- 对学生集合做判断，使用c:choose/c:when/c:otherwise -->
	<c:choose>
		<c:when test="${!empty list }">
		
		
			<table align="center" border="1px" cellspacing="0" cellpadding="10" width=60%>
				<tr>
					<td>姓名</td>
					<td>性别</td>
					<td>地址</td>
					<td colspan="2">操作</td>
				</tr>
				<!-- 使用c:foreach遍历学生信息 -->
				<c:forEach items="${list }" var="stu">
					<tr>
						<td>${stu.name }</td>
						<td>${stu.sex }</td>
						<td>${stu.address }</td>
						<td><a href="#">删除</a></td>
						<td><a href="#">修改</a></td>
					</tr>
				
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>没有学生信息可显示</h3>
		</c:otherwise>
	
	</c:choose>
	
	
</body>
</html>