<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] str = {"a","b","c","d"};
		request.setAttribute("str", str);
	%>
	<!-- 函数标签库需要结合EL表达式使用 -->
	<!-- 函数标签库主要是操作的字符串 -->
	${fn:contains("hello","he") }<br>
	${fn:endsWith("Hello","eo") }<br>
	${fn:indexOf("hello","h") }<br>
	${fn:join(str,"-") }<br>
	
</body>
</html>