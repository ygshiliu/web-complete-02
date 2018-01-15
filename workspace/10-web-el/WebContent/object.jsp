<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 通过pageContext可以获取其它隐含对象 -->
	${pageContext.request.contextPath }<br><br>
	
	<!-- pageScope\requestScope\sessionScope\applicationScope用来指定具体的域 -->
	<!-- 获取请求参数中的信息 -->
	<%-- ${param.name } --%>
	<!-- 获取到一个请求信息数组可以通过下标的方式来查找元素 -->
	<%-- ${paramValues.name[1] } --%>
	
	<!-- 通过EL获取请求头信息 -->
	${header["user-agent"] }<br><br>
	${headerValues.accept[0] }<br><br>
	
	<!-- 通过EL获取web应用中的配置信息 -->
	${initParam.encode }<br><br>
	
	<!-- 可以获取Cookie -->
	<%-- ${cookie.JSESSIONID} --%>
</body>
</html>