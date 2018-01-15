<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
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
<body>
<%
	List list = new ArrayList();
	list.add("刘在石");
	list.add("金钟国");
	list.add("宋智孝");
	list.add("池石镇");
	
	request.setAttribute("list", list);
	
	Map map = new HashMap();
	map.put("name", "haha");
	map.put("age",16);
	map.put("sex",'男');
	
	request.setAttribute("map", map);

%>

	<!-- 可以遍历一个Map集合 -->
	<!-- 当集合是一个map时，输出的属性是一个键值对的形式 -->
	<!-- 可以通过属性.key来获取键，属性.value来获取value -->
	<c:forEach items="${map }" var="pro">
		${pro.key } -- ${pro.value }<br><br>
	</c:forEach>


	<!-- 可以遍历一个集合 -->
	<!-- items指要遍历的集合对象 -->
	<!-- 集合对象中有几个元素，c:foreach就会遍历几次；
		同时每遍历一次就会将元素以var指定值作为属性名，以遍历的元素作为值设置进域中 ;
		在标签体中，可以使用EL表达式从或中来获取每次设置的值-->
	<c:forEach items="${list }" var="name">
		${name }<br>
	</c:forEach>
	
	<br><br>
	
	
	<!-- 可以向页面中输出一组数据 -->
	<!-- 用来循环标签体。实现java中的循环功能-->
	<!-- begin是开始值，最小值 为0 -->
	<!-- end指结束位置 -->
	<!-- step代表步长 -->
	<!-- var是每次c:forEach循环时都会将变量设置进域里，并使用var指定的值作为属性名 -->
	<c:forEach begin="0" end="10" step="1" var="index" >
		${index }&nbsp;&nbsp;
	</c:forEach>
</body>
</html>