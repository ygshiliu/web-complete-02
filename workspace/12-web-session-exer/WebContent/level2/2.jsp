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
	<c:if test="${empty sessionScope.user }">
		<c:redirect url="/index.jsp"></c:redirect>
	</c:if>
	<a href="../index.jsp">返回</a>
	<h1>七伤拳</h1>
	<p>练这拳的人全都死了</p>
</body>
</html>