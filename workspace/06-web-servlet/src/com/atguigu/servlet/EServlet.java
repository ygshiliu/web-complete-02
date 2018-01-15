package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * Servlet implementation class EServlet
 */
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求报文格式：
		 * 请求首部
		 * 		请求首行
		 * 		请求头
		 * 空行
		 * 请求体
		 *
		 * 
		 * HttpServletRequest：
		 * 【代表】封装的是浏览器发送给服务器的请求报文
		 * 【获取】它是由服务器创建并作为参数传递给doGet与doPost方法，我们可以直接使用
		 * 【功能】
		 * 		1.可以用来获取请求参数 
		 * 		2.可以用来获取项目名
		 * 		3.可以作为一个域对象在不同的web资源中共享数据 （request servletContext)
		 * 		4.可以发起请求的转发
		 * 
		 * 什么是请求的转发？
		 * 当servlet收到浏览器发送来的请求时并不直接处理，而是调用服务器中的其它资源来处理
		 * 
		 * 转发的特点：
		 * 1.浏览器地址栏没有变化
		 * 2.浏览器发送1次请求
		 * 3.转发是发生在服务器内部
		 * 4.浏览器感知不到
		 */
		
		
		//1.可以用来获取请求参数 
		/*String value = request.getParameter("name");
		String value2 = request.getParameter("password");
		System.out.println(value+"--"+value2);*/
		
		//2.可以用来获取项目名
		//String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		
		//4.可以发起请求的转发
		//获取派发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		//转发到指定页面
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 响应报文的格式：
		 * 响应首部
		 * 		响应首行
		 * 		响应头
		 * 空行
		 * 响应体
		 * 
		 * HttpServletResponse
		 * 【代表】封装服务器发送给浏览器的响应报文
		 * 【获取】它是由服务器创建，并作为参数传递给doGet与doPost方法
		 * 【功能】
		 * 		1.可以向浏览器输出一个页面或页面片段
		 * 		2.可以发起请求的重定向
		 * 
		 * 什么是请求的重定向？
		 * 当Servlet收到请求后，会向浏览器返回一个特殊的指令
		 * 这个特殊的指令告诉浏览器再向另一个地址发送请求
		 * 	
		 *  HTTP/1.1 302 Found
			Location: http://localhost:8080/06-web-servlet/index.html
			
			这个特殊的指令包括一个响应状态码302，和一个响应头location,location指向一个新的url地址
			当浏览器收到响应状态码302后，它会重新向location指向的url地址发送请求
			
			重定向的特点：
			1.浏览器地址栏有变化
			2.浏览器发送了2次请求
			3.重定向发生在浏览器端
			4.浏览器能够感知到
		 * 
		 */
		
		//1.可以向浏览器输出一个页面或页面片段
		//先获取一个输出流
		//PrintWriter out = response.getWriter();
		//通过输出流向浏览器输出一个页面片段
	//	out.print("<h1>Hello,Browser</h1>");
		
		//2.可以发起请求的重定向
		response.sendRedirect("index.html");
	}

}
