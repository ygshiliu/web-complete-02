package com.atguigu.bean;
/**
 * 文件名: OrderItem.java
 * 描述: 封装订单项信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月20日 下午4:45:15
 */
public class OrderItem {
	/**
	 * 订单项主键
	 */
	private Integer id;
	/**
	 * 书名
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 封面
	 */
	private String imgPath;
	/**
	 * 单项购买数量
	 */
	private int count;
	/**
	 * 单项购买的金额
	 */
	private double amount;
	/**
	 * 隶属哪个订单
	 */
	private String orderId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderItem(Integer id, String title, String author, double price,
			String imgPath, int count, double amount, String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.imgPath = imgPath;
		this.count = count;
		this.amount = amount;
		this.orderId = orderId;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", title=" + title + ", author="
				+ author + ", price=" + price + ", imgPath=" + imgPath
				+ ", count=" + count + ", amount=" + amount + ", orderId="
				+ orderId + "]";
	}
	
	
}
