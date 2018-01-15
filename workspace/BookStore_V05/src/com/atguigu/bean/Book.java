package com.atguigu.bean;
/**
 * 文件名: Book.java
 * 描述: 封装图书的信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 上午10:09:20
 */
public class Book {
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
	 * 销售
	 */
	private int sale;
	/**
	 * 库存
	 */
	private int stock;
	/**
	 * 封面
	 */
	private String imgPath = "static/img/default.jpg";
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
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Book(Integer id, String title, String author, double price,
			int sale, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sale = sale;
		this.stock = stock;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", sale=" + sale + ", stock=" + stock
				+ ", imgPath=" + imgPath + "]";
	}
	
	
}
