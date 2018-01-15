package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 文件名: AFilter.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年4月2日 上午11:38:13
 */
public class AFilter implements Filter {
	
	public AFilter() {
//		System.out.println("AFilter构造器方法被调用");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("init方法被调用");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		System.out.println("doFilter方法被调用");
		System.out.println("请求到达AFilter");
		
		//对请求放行
		chain.doFilter(request, response);
		
		System.out.println("请求重新回到AFitle");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		System.out.println("destroy方法被调用");
	}

}
