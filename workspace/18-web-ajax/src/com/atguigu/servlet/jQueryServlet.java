package com.atguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class jQueryServlet
 * @param <V>
 * @param <K>
 */
public class jQueryServlet<V, K> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name:"+name+",age:"+age);
		
		//创建map
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", age);
		
		//创建json
		Gson gson = new Gson();
		
		//将对象转成字符串
		String json = gson.toJson(map);
		
		response.getWriter().print(json);
		
		
	}

}
