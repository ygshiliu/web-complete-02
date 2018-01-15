<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.atguigu.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		request.setAttribute("user", user);
		
		List list = new ArrayList();
		request.setAttribute("list", list);
	%>
	<!-- EL表达式可以进行数字运算、比较运算、逻辑运算 -->
	${5*3 }<br>
	${5>3 }<br>
	${! true }<br><br>
	
	${empty "" }<br>
	${empty " " }<br>
	${empty user}<br>
	${empty list }<br>
	${!empty map }
	
</body>
</html>