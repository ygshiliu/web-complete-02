package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求参数 
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		//这里默认已经从数据库中取出数据来
		System.out.println("去数据库中获取用户名和密码的信息，这里默认只有一个用户名admin和密码123123");
		//根据返回结果输出指定页面
		if("admin".equals(name) && "123123".equals(password)){
			//如果为真，重定向到login_success.html
			resp.sendRedirect("login_success.html");
		}else{
			req.getRequestDispatcher("login_error.html").forward(req, resp);
		}
		
		
	}

}
