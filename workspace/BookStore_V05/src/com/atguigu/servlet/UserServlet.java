package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WEBUtils;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService us = new UserServiceImpl();
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String method = request.getParameter("method");
		
		//通过反射方式来调用方法
		//首先获取大Class对象
		Class<? extends UserServlet> clazz = this.getClass();
		try {
			//获取方法对象
			Method declaredMethod = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//设置方法的可访问权限
			declaredMethod.setAccessible(true);
			//执行
			declaredMethod.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//判断请求方法
		if("login".equals(method)){
			login(request,response);
		}else if("regist".equals(method)){
			regist(request, response);
		}else if("delete".equals(method)){
			
		}else if("logout".equals(method)){
			
		}else if()
		
	}*/
	//登录功能
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	//获取一个请求参数的Map对象
		Map map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	/*	//获取请求参数 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//组织请求参数 
		User user = new User(null, username, password, null);
		System.out.println(user);*/
		
		User user = WEBUtils.param2Bean(request, new User());
		
		//调用业务逻辑层
		User login = us.login(user);
		//根据返回结果，显示页面
		if(login == null){
			//说明用户不存在，转发到login.html
			//设置错误信息到域 中
			request.setAttribute("msg", "用户名或密码不对，请重新输入");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//否则说明用户登录成功，重定向到login_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
		
	}
	//注册功能
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		User user = WEBUtils.param2Bean(request,new User());
	/*	//获取请求参数 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//组织请求参数 
		User user = new User(null, username, password, email);
		*/
		//调用业务逻辑层
		boolean flag = us.regist(user);
		
		//根据返回结果显示页面
		if(flag){
			//如果为真说明注册成功，重定向到regist_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			//否则用户已存在，转发到regist.html
			//向域对象中设置错误信息
			request.setAttribute("msg", "此用户已经注册过");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}

}
