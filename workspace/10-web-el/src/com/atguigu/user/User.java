package com.atguigu.user;
/**
 * 文件名: User.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 上午10:32:51
 */
public class User {
	private String name;
	private int age;
	private double price;
	
	private Address addr;
	
	
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age, double price) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", price=" + price
				+ ", addr=" + addr + "]";
	}
	
	
}
