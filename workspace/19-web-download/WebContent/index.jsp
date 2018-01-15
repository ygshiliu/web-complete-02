<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Download.jsp</h1>
	<!-- 
		放在项目根目录下的资源，通过浏览器是可以直接访问的。
		所以服务器上的资源通常我们都放在WEB-INF目录下
		而放在WEB-INF目录下需要通过servlet才能访问到
		所以下载资源通常都要访问servlet，通过servlet向浏览器发送一个流来实现 
		
		如果下载的资源类型是浏览器支持的，浏览器会自动打开资源，而不是下载
		这里需要服务器指定两个响应头：
		content-type
		content-disposition
	 -->
	<a href="${pageContext.request.contextPath }/诗词.txt">下载文件</a><br><br>
	<a href="${pageContext.request.contextPath }/DownloadServlet">下载txt</a>
</body>
</html>