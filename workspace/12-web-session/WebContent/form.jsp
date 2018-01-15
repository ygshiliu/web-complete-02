<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* 	window.onload = function(){
		var btn = document.getElementById("btn");
		btn.onclick = function(){
			//点击之后将按钮设置为不可用
			btn.disabled = true;
			
			//将按钮设置不可用后，默认行为会被取消
			//需要手动提交请求
			this.parentNode.submit();
		}
	} */
</script>
</head>
<body>
	<h1>form.jsp</h1>
	
	<%
		//由服务器生成token
		String token = UUID.randomUUID().toString().replace("-","");
		
		//将token设置进session域
		session.setAttribute("token", token);
		
	%>
	<br>
	${msg }
	<form action="RegistServlet" method="post">
		<input type="Text" name="token" value="<%=token%>" style="width:600px"><br>
		姓名：<input type="text" name="username" ><br>
		年龄：<input type="text" name="age"><br>
		手机：<input type="text" name="phone"><br>
		<input id="btn" type="submit" value="注册">
	</form>
</body>
</html>