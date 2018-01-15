package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 文件名: HellowordFilter.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年4月2日 上午10:46:53
 */
public class HellowordFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ServletRequest:请求报文
	 * ServletResponse:响应报文
	 * FilterChain: 用来调用过滤器链中的下一个过滤器或目标资源
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//向控制台输出一条信息
		System.out.println("请求到达HellowordFilter");
		
		//对请求报文进行预处理
		request.setAttribute("name", "Tom");
		
		//调用目标资源
		//调用此方法对请求进行放行操作
		//不调用此方法将对请求进行拦截
		chain.doFilter(request, response);
		
		//向控制台输出一条信息
		System.out.println("请求重新回到HellowordFilter中");
		
		//对响应报文进行更改
		response.getWriter().print("<b>Hello , I am coming from server!</b>");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
