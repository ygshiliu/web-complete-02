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
		//向域对象中添加属性
		pageContext.setAttribute("pageKey", "pageValue");
		request.setAttribute("reqKey", "reqValue");
		session.setAttribute("sessionKey", "sessionValue");
		application.setAttribute("appKey", "appValue");
	%>
	
	<!-- 从域对象中获取属性 -->
	pageContext : <%=pageContext.getAttribute("pageKey") %><br><br>
	request : <%=request.getAttribute("reqKey") %><br><br>
	session : <%=session.getAttribute("sessionKey") %><br><br>
	application : <%=application.getAttribute("appKey") %><br><br>
	
<%-- 	<jsp:forward page="7.jsp"></jsp:forward> --%>
<a href="7.jsp">访问7.jsp</a>

</body>
</html>