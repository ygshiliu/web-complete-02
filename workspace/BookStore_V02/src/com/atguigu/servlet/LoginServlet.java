package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * 用来接收用户的登录请求
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取请求参数 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//组织请求参数 
		User user = new User(null, username, password, null);
		System.out.println(user);
		
		//调用业务逻辑层
		User login = us.login(user);
		//根据返回结果，显示页面
		if(login == null){
			//说明用户不存在，转发到login.html
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}else{
			//否则说明用户登录成功，重定向到login_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
		}
		
	}

}
