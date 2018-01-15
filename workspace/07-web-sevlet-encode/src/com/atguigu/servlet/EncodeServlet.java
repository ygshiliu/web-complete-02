package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodeServlet
 */
public class EncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get请求是由服务器自动进行解码的，而服务器默认的字符集是iso8859-1，不支持中文
		request.setCharacterEncoding("utf-8");
		//获取请求参数 
		String name = request.getParameter("name");
		System.out.println("后台获取name : "+name);
		
		//设置响应字符集
		//response.setCharacterEncoding("utf-8");
		//如果不指浏览器字符集，浏览器会使用默认字符集，但默认字符集有可能不是utf-8
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//服务器向浏览器发送信息
		response.getWriter().print(name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//如果不指定字符集，服务器默认的字符集是iso8859-1
		//设置post请求解码必须是在服务器第一次获取请求参数之前才启作用
		request.setCharacterEncoding("utf-8");
		//获取请求参数 
		String name = request.getParameter("name");
		System.out.println("post请求，后台获取name : "+name);
		
		//服务器向浏览器发送信息
		//response.getWriter().print(name);
	}

}
