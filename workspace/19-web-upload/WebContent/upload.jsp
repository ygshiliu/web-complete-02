<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>upload.jsp</h1>
	<!-- 
	文件上传需要注意以下事项：
	1. 文件上传需要使用form标签，并且method属性值为post
	2. form标签还有另一个属性enctype,用来指定或返回表单内容的MIME值 
		默认值为application/x-www-form-urlencoded，表示表单内容为普通表单项
		假如表单项类型为file时，我们需要指定为multipart/form-data，表示表单内容通过流的方式上传到服务器
	3. 当form的enctype=multipart/form-data时，服务通过reqeust.getParameter方法将不能正确获取数据
		我们需要使用流的方式
	 -->
	<span style="color:red"> ${msg }</span><br><br>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		别名：<input type="text" name="photo"><br><br>
		File1：<input type="file" name="file1"><br><br>
		File2：<input type="file" name="file2"><br><br>
		File3：<input type="file" name="file3"><br><br>
		File4：<input type="file" name="file4"><br><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>