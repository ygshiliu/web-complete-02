package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet
 */
public class cookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个cookies
		Cookie cookie = new Cookie("name", "Tom");
		Cookie cookie2 = new Cookie("password", "123123");
		
		//给name的cookie指定路径
		//Cookie是由浏览器来解析所以路径要加上项目名
		//cookie默认有效路径是项目根目录，只要访问项目根目录下的资源就会带着
		//假如设置了cookie路径后，只有访问指定路径时才会带着此cookie
		cookie.setPath(request.getContextPath()+"/aa/");
		
		//将cookie发送给浏览器,可以发送多个cookie
		//当通过addCookie向浏览器发送cookie时，服务器会在响应报文中设置一个响应头，如Set-Cookie: name=Tom
		//当浏览器收到响应报文后，会将cookie信息保存下来，下次访问服务器时会带着这个cookie
		response.addCookie(cookie);
		response.addCookie(cookie2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
