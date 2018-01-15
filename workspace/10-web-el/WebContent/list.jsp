<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.atguigu.user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<User> list = new ArrayList<User>();
	
		list.add(new User("haha",16,20));
		list.add(new User("gary",20,30));
		list.add(new User("Lucy",25,40));
		
		//将集合设置进域中
		request.setAttribute("list", list);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Marc");
		map.put("age",16);
		map.put("sex",'男');
		
		//设置进域中
		request.setAttribute("map", map);
	%>
	
	<!-- 使用EL获取集合 -->
	<%-- ${list } --%>
	
	<!-- 获取list集合中的每一个元素对象，通过  “属性[下标]” 方式 -->
	<%-- ${list[2] } --%>
	
	<!-- 获取map中的属性值：对象.key -->
	${map.sex }
	
</body>
</html>