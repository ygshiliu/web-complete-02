package com.atguigu.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.bean.User;

/**
 * 文件名: WEBUtils.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 上午11:12:35
 */
public class WEBUtils {

	public static <T>T param2Bean(HttpServletRequest request, T t) {
		//获取一个请求参数的Map对象
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
		
	}

	public static void setPath(HttpServletRequest request, Page<Book> page) {
		///BookStore_V05/manager/BookManagerServlet?method=findBook
		//获取请求资源的uri
		String uri = request.getRequestURI();
		//获取请求参数
		String queryString = request.getQueryString();
		
		if(queryString.contains("&pageNo")){
			queryString = queryString.substring(0, queryString.indexOf("&pageNo"));
		}
		page.setPath(uri+"?"+queryString);
		
	}

}
