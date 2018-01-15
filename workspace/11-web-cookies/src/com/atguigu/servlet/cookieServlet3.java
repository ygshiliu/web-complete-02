package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet3
 */
public class cookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个cookies
		Cookie cookie = new Cookie("name", "haha");
		
		//设置cookie的有效时间，单位：秒
		//Set-Cookie: name=haha; Expires=Wed, 15-Mar-2017 07:20:16 GMT
		//可以指定一个大于0的正整数，代表有效时间
		//cookie.setMaxAge(20);
		
		//Set-Cookie: name=haha; Expires=Thu, 01-Jan-1970 00:00:10 GMT
		//代表立即失效
		//cookie.setMaxAge(0);
		
		//指定一个负数，与不设置一样，有效时间代表一次会话
		//Set-Cookie: name=haha
		//cookie.setMaxAge(-20);
		
		cookie.setMaxAge(60*60*24*365*10);
		
		//发送给浏览器
		response.addCookie(cookie);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
