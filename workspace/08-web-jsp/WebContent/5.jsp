<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>5.jsp</h1>
	
	<!-- jsp动作标签 -->
	<!-- jsp:forward 功能是转发到指定页面 -->
	<!-- 可以使用jsp:forward的子标签jsp:param传递请求参数 -->
<%-- 	<jsp:forward page="4.jsp">
		<jsp:param value="Jerry" name="name"/>
	</jsp:forward> --%>
	
	<!-- jsp:include 称为动态包含-->
	<jsp:include page="6.jsp"></jsp:include>

</body>
</html>