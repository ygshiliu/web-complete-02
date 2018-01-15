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
		//向各个域对象中设置属性
		pageContext.setAttribute("key", "pageValue");
		request.setAttribute("key", "requestValue");
		session.setAttribute("key", "sessionValue");
		application.setAttribute("key", "applicationValue");
	%>
	
	<!-- 获取域中的属性值  -->
<%-- 	<%=pageContext.getAttribute("key" ) %><br><br>
	<%=request.getAttribute("key" ) %><br><br>
	<%=session.getAttribute("key" ) %><br><br>
	<%=application.getAttribute("key" ) %><br><br> --%>
	
	<!-- 使用EL表达式来获取域对象中的属性值  -->
	<!-- EL表达式可以接收一个域中的属性名，代表全域查找，会从小到大依次查找，找到就返回 -->
	<!-- 我们可以精确来查找域中的属性，需要指定要使用的域 -->
	<!-- 这4个域在EL中分别为：pageScope requestScope sessionScope applicationScope -->
	${requestScope.key }
</body>
</html>