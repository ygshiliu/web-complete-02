package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		String name = request.getParameter("username");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		
		//获取用户提交的token
		String reqToken = request.getParameter("token");
		//获取session中的token
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("token");
		//移除token
		session.removeAttribute("token");
	System.out.println(token+"--"+reqToken);	
		if(token != null && token.equals(reqToken)){
			//正常处理
			
			//输出注册信息，输出一条代表向数据库中插入一条
			System.out.println(name+"--"+age+"--"+phone);
			
			//转发
			//request.getRequestDispatcher("form.jsp").forward(request, response);
			response.sendRedirect("1.jsp");
		}else{
			//否则表单重复提交
			request.setAttribute("msg", "请不要重复提交表单信息");
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}

		
	}

}
