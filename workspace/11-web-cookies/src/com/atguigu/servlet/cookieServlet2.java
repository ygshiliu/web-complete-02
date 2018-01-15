package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieServlet2
 */
public class cookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取cookie
		Cookie[] cookies = request.getCookies();
		//cookies不为null时才遍历
		if(cookies !=null){
			
			for(Cookie cookie:cookies){
				//获取cookie的名字
				String name = cookie.getName();
				//获取cookie的值 
				String value = cookie.getValue();
				
//				System.out.println(name+"--"+value);
				if("password".equals(name)){
					//cookie被替换后必须重新发送给浏览器才会生效
					cookie = new Cookie("password", "456456");
					response.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
