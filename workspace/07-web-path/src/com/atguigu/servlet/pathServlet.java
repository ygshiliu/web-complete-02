package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pathServlet
 */
public class pathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过转发到1.html
//		在这里/是由服务器解析的，/代表着项目的根目录，所以转发不需要加项目名http://localhost:8080/07-web-path/
		//request.getRequestDispatcher("/07-web-path/page/1.html").forward(request, response);
		
		//重定向是由浏览器解析的，/代表的是服务器的根目录http://localhost:8080/，所以需要加项目名
		response.sendRedirect("/page/1.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
