package com.atguigu.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.atguigu.bean.User;

/**
 * 文件名: BeanUtilsTest.java
 * 描述: 测试BeanUtils方法
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 上午10:34:26
 */
public class BeanUtilsTest {
	
	@Test
	public void test2() throws Exception {
		
		User bean = new User();
		
		//这里模拟前端传过来的请求参数，都是String类型
		Map<String,String> map = new HashMap();
		//map中的key是属性名，value是属性的值 
		map.put("name", "haha");
		map.put("age", "16");
		map.put("price", "30");
		
		//populate方法需要传入一个javaBean和一个Map对象
		BeanUtils.populate(bean, map);
		
		System.out.println(bean);
	}

	@Test
	public void test1() throws Exception {
		//创建一个user对象
		User bean = new User();
		//System.out.println("前>>>>>>>"+bean);
		//模拟用户传过来的参数
		//说明javaBean中的属性名并不指我们声明的属性名
		//而是我们在javaBean中定义的getter方法和setter方法名，去掉get或set后首字母小写部分
		//通过在javaBean中定义的全局变量我们称为字段
		//通过BeanUtils给javaBean设置属性值可以实现内部自动转型，即使传递的值 类型不正确也不会报错，会自动忽略
		
		String name = "name1";
		Object value = "刘在石";
		BeanUtils.setProperty(bean, name, value);
		
		
		String age = "age";
		String ageValue = "阿斯达";
		BeanUtils.setProperty(bean, age, ageValue);
		
		String price = "price";
		String priceValue = "20.0";
		BeanUtils.setProperty(bean, price, priceValue);
		
		System.out.println("后>>>>>>"+bean);
		
		
	}

}
