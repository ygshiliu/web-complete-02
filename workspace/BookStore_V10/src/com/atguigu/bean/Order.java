package com.atguigu.bean;

import java.util.Date;

/**
 * 文件名: Order.java
 * 描述: 封装订单信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午4:39:15
 */
public class Order {
	/**
	 * 订单号：时间戳+用户id
	 */
	private String id;
	/**
	 * 订单生成时间
	 */
	private Date createDate;
	/**
	 * 订单状态
	 */
	private int state;
	/**
	 * 订单总金额
	 */
	private double totalAmount;
	/**
	 * 订单总数量 
	 */
	private int totalCount;
	/**
	 * 用户Id
	 */
	private int userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order(String id, Date createDate, int state, double totalAmount,
			int totalCount, int userId) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.state = state;
		this.totalAmount = totalAmount;
		this.totalCount = totalCount;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", createDate=" + createDate + ", state="
				+ state + ", totalAmount=" + totalAmount + ", totalCount="
				+ totalCount + ", userId=" + userId + "]";
	}
	
	
}
