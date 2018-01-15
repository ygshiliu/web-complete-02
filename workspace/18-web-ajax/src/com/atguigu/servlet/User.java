package com.atguigu.servlet;

import java.util.List;

/**
 * 文件名: User.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年4月6日 上午10:22:46
 */
public class User {
	
	private String name ;
	private int age;
	private String gender;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName1(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age, String gender, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [name1=" + name + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + "]";
	}
	

	
}
