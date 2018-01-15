package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件名: BaseServlet.java
 * 描述: 专门用来继承的
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 上午10:00:59
 */
public class BaseServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			doPost(req,resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setCharacterEncoding()是在request第一次获取请求参数时才会起作用
		request.setCharacterEncoding("utf-8");
		
		//获取请求参数
		String method = request.getParameter("method");
		
		//通过反射方式来调用方法
		//首先获取大Class对象
		Class clazz = this.getClass();
		try {
			//获取方法对象
			Method declaredMethod = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//设置方法的可访问权限
			declaredMethod.setAccessible(true);
			//执行
			declaredMethod.invoke(this, request,response);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
