<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 模版元素：就是html中的标签元素，在html文件中怎么写，在jsp文件中就怎么写 
		模版元素会被翻译到java文件的service方法中，并最终会作为out.write()的参数
	-->
	<h1>1.jsp</h1>
	<p>东边日出西边雨，道是无晴却有晴</p>
	
	<!-- jsp脚本片断:可以用来写java代码，在java文件的方法中怎么写，在这里就可以怎么写 
		jsp中的脚本片断会原封不动的翻译到对应的java文件在service方法的指定位置
		在jsp页面中jsp脚本片断可以出现多次
	-->
	<%
		//可以定义一个局部变量
		String str="宋智孝";
		
		//可以调用方法
		System.out.println(str);
		
		//不可以定义方法
		//会报500错误，错误信息是Unable to compile class for JSP
		/* public void myPrint(){
			System.out.println(str);
		} */
		
		//不可以在变量前加权限修饰符
		//这里是编译时异常
		//public String str1 = "李光洙";
		
		
	%>
	
	<!-- JSp表达式 -->
	<!-- 作用：可以向页面输出信息 -->
	<!-- jsp表达式中的信息会被翻译到对应java文件的service方法中out.print（）方法的参数 -->
	<!-- 也就是说out.print（）方法可以传什么类型的参数，jsp表达式就可以接收什么类型的参数 ，即可以接收任意类型参数 -->
	<%= Math.random() %>
	
	<!-- html注释 ：在jsp、对应的java文件、及运行后的html页面中都 可以看到-->
	<%-- Jsp注释 ：只能在jsp文件中看到--%>
	<%
		//可以在jsp文件和java文件中看到
		//java注释
		/*java多行注释*/
		/**
		*java文档注释
		*/
	%>
	
	<!-- jsp声明 -->
	<!-- 作用：可以用来在类中声明一个全局变量或在类中定义一个方法 -->
	<%! 
		public String getInfo(){
		return "myInfo";
	}
	%>
</body>
</html>