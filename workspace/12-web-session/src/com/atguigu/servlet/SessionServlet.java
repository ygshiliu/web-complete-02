package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建session
		//是在第一次调用request.getSession（）方法时创建
		HttpSession session = request.getSession();
		
		//保存数据
		session.setAttribute("name", "Tom");
		
		//获取session的Id
		//每一个Session对象都有它唯一的标识符
		//唯一标识符是由一个32位的
		String id = session.getId();
		
		//向页面输出信息
		response.getWriter().print(id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
