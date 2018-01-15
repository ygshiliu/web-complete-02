package com.atguigu.i18n;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * 文件名: TestI18n.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年4月8日 上午11:16:05
 */
public class TestI18n {
	
	@Test
	public void test04() {
		//仅创建日期
//		DateFormat instance = DateFormat.getDateInstance(DateFormat.FULL);
//		DateFormat instance = DateFormat.getDateInstance(DateFormat.SHORT, Locale.KOREAN);
		
		//创建日期和时间
//		DateFormat instance = DateFormat.getDateTimeInstance();
//		DateFormat instance = DateFormat.getDateInstance(DateFormat.FULL);
		DateFormat instance = DateFormat.getDateInstance(DateFormat.FULL,Locale.PRC);
		
		String str = instance.format(new Date());
		System.out.println(str);
	}
	
	@Test
	public void test03() {
		
		NumberFormat instance = NumberFormat.getInstance();
		String str = instance.format(12234445);
		System.out.println(str);
		
	}

	@Test
	public void test02() {
		//用来指定语言环境
//		Locale locale = new Locale("en", "US");
		Locale locale = Locale.ITALIAN;
		System.out.println(locale);
		
		//根据指定的Local加载资源文件
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
		//获取资源文件中的值
		String title = bundle.getString("title");
		String username = bundle.getString("username");
		String password = bundle.getString("password");
		String login = bundle.getString("login");
		System.out.println(title+"--"+username+"--"+password+"--"+login);
	}

	@Test
	public void test01() {
		//根据默认语言环境加载资源文件
		ResourceBundle bundle = ResourceBundle.getBundle("i18n");
		
		//获取资源管理器使用的Local
		Locale locale = bundle.getLocale();
		System.out.println(locale);
		
		//获取资源文件中的值
		String title = bundle.getString("title");
		System.out.println(title);
	}

}
