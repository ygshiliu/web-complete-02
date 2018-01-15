<%@page import="com.atguigu.user.Address"%>
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
		//创建一个User对象
		User user = new User("haha",16,20);
		//创建一个地址对象
		Address addr = new Address();
		addr.setProvince("北京市");
		addr.setCity("北京");
		addr.setDistrict("昌平区");
		
		user.setAddr(addr);
	
		//设置进域中
		request.setAttribute("user", user);
	%>
	
	<!-- 获取域中的user属性 -->
	<!-- 如果属性是一个对象会显示对象的toString方法的返回值  -->
	<!-- 获取对象的属性，直接对象.属性，需要注意的是这里的属性指getter方法去掉get后首字母小写获得的 -->
	<%-- ${requestScope.user.name } --%>
	
	<!-- 获取 域中的user对象 -->
	${user }
	
	<!-- 获取域 中对象的属性：对象.属性 -->
	<%-- ${user.addr } --%>
	
	<!-- 获取域中对象的属性的属性，还是使用点操作，EL是支持级联操作的 -->
	<!-- 获取对象的属性还可以使用中括号 -->
	<%-- ${user.addr.city } --%>
	<!-- 这种方式一般在属性名中包含有特殊字符时使用 -->
	${requestScope.user["price"] }
</body>
</html>