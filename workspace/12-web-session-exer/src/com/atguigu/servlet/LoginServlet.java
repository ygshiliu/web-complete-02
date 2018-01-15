package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String name = request.getParameter("username");
		
		//去数据库验证，模拟每次都是正确的
		//如果判断用记是否登录了？
		//通过会将用户信息放到一个域对象中，然后判断这个域对象中有没有用户信息来判断是否登录
		//这个域对象通常使用session
		
		//获取session
		HttpSession session = request.getSession();
		session.setAttribute("user", name);
		System.out.println(name);
		//重定向
		response.sendRedirect("index.jsp");
		
	}

}
