<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1.jsp</h1>
	<%-- ${name } --%>
	<!-- 获取session的有效时间 -->
	<%=session.getMaxInactiveInterval() %>
	<!-- 手动设置session有效时间 -->
	<%
		//单位是秒
		//设置正整数，代表Session有效时长
		//session.setMaxInactiveInterval(5);
		
		//设置0，代表立即失效
		//session.setMaxInactiveInterval(0);
		
		//设置负数，代表永远不会超时
		//只所以会创建新Session是因为它所对应的JSESSIONID的cookie默认有效时间是一次会话，关闭浏览器就消失了
		session.setMaxInactiveInterval(10000);
	
		session.setAttribute("name", "haha");
	%>
	<br><br>
	<%=session.getMaxInactiveInterval() %><br><br>
	<a href="${pageContext.request.contextPath }/2.jsp">访问首页</a><br><br>
	<a href="<%= response.encodeRedirectURL(request.getContextPath()+"/2.jsp")%>">访问首页</a><br><br>
	<a href="<c:url value="/2.jsp"></c:url>">访问首页</a><br><br>
	
	
</body>
</html>