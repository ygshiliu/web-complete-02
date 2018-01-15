package com.atguigu.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
			name = URLEncoder.encode(name, "utf-8");
			
			//创建cookie
			Cookie cookie = new Cookie("name", name);
			
			//设置cookie有效时间
			cookie.setMaxAge(60*60);
			
			//发送给浏览器
			response.addCookie(cookie);
			
			//重定向到登录页面
			response.sendRedirect("login_success.jsp");
		
		
	}

}
