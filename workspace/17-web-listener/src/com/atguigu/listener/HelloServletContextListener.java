package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 文件名: HelloServletContextListener.java
 * 描述: application域的生命周期监听器
 * 开发人员： Miss Wang
 * 创建时间： 2017年4月4日 上午11:02:25
 */
public class HelloServletContextListener implements ServletContextListener {
	
	public HelloServletContextListener() {
		// TODO Auto-generated constructor stub
		System.out.println("application 构造器");
	}
	//application被创建时调用
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application被创建。。");
		/*ServletContext app = sce.getServletContext();
		System.out.println(app);
		String param = app.getInitParameter("name");
		System.out.println(param);
		String path = app.getContextPath();
		System.out.println(path);
		String realPath = app.getRealPath("/hello");
		System.out.println(realPath);*/
		
		
	}
	//application被销毁时调用
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application被销毁。。");
		
	}

}