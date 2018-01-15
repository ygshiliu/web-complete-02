package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JspServlet
 */
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在servlet中只能获取三个域对象：request,session,application
		//获取session对象
		HttpSession session = request.getSession();
		//获取application
		ServletContext application = getServletContext();
		
		//模拟从数据库中获取数据
		String str = "宋智孝";
		
		
		//response可以向浏览器输出一个页面片段，也可以输出一个页面
		//获取输出流
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//输出一个页面片段
		//out.print("你好，我来自服务器");
		
		//输出一张网页
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>来自服务器端的动态页面</h1>");
		out.print("<h3>"+str+"</h3>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
