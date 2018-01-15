package com.atguigu.bean;

import java.io.Serializable;

/**
 * 文件名: User.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月16日 下午3:23:19
 */
public class User implements Serializable{
	
	private String name;
	private int age;
	private Address addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
