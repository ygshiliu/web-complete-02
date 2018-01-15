package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("收到js请求");
		//获取请求参数 
		String name = request.getParameter("name");
		System.out.println(name);
		//返回响应
		/*response.getWriter().print("hello , JS");
		response.getWriter().print(name);*/
		
		User user = new User("TOM", 15, "male", "13112724408");
//		String userstr = "{\"name\":\""+user.getName()+"\",\"age\":"+user.getAge()+",\"gender\":\""+user.getGender()+"\",\"phone\":\""+user.getPhone()+"\"}";
//		String userstr = "name:"+user.getName()+",age:"+user.getAge()+",gender:"+user.getGender();
//		System.out.println(userstr);
		
		//创建gson
		Gson gson = new Gson();
		
		//将对象转成json字符串
		String userstr = gson.toJson(user);
		
		response.getWriter().print(userstr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("接收到post请求");
		//获取请求参数 
		String name = request.getParameter("name");
		System.out.println(name);
		//返回响应
		//返回xml需要设置响应头
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print("<user><name>Jerry</name></user>");
	}

}
