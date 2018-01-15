package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 实现servlet的步骤：
 * 1、创建一个类实现Servlet接口
 * 2、需要将servlet配置到服务器上 
 *	
 * servlet是由我们创建，但是由servlet容器（tomcat服务器）管理
 * servlet容器主要负责管理servlet的生命周期
 * 
 * 人的生命周期：是人从出生到死亡的过程
 * servlet的生命周期是从被创建到被销毁的过程
 * 
 * servlet的生命周期方法：
 * 1、构造器	
 * 			servlet第一次处理请求时被调用，仅调用1次
 * 			构造器只调用1次说明servlet是一个单例模式，servlet是以单例多线程的方式来调用service（）方法的
 * 			servlet不是线程安全的，所以我们尽量不要在service()方法中出现全局变量
 * 			
 * 2、init
 * 			是在构造器调用后立即被调用，只调用1次，用来做servlet初始化操作
 * 
 * 3、service
 * 			每次处理请求都会被调用，它会执行多次
 * 
 * 4、destroy
 * 			当项目被卸载时调用，仅调用1次。主要用来做servlet的收尾工作
 * 
 * 
 * 第1次访问servlet时：
 * 构造器调用
 * init()
 * Service()
 * 
 * 第1次之后访问servlet时：
 * service()
 * 
 * 当项目被卸载时：
 * destroy()
 * 
 */
public class HelloServlet implements Servlet {
	
	public HelloServlet() {
		System.out.println("构造器被调用");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init被调用");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ServletRequest：代表浏览器发送给服务器的请求报文
	 * ServletResponse：代表服务器发送给浏览器的响应报文
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		/*//向控制台输出一条信息
		System.out.println("你好servlet");
		
		//向页面输出一条信息
		res.getWriter().print("I come from server");*/
	
		System.out.println("service被调用");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy被调用");
		
	}


}
