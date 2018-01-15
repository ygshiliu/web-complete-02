package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 文件名: CartItem.java
 * 描述: 封装购物车中的购物项信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月17日 下午3:18:21
 */
public class CartItem implements Serializable{
	/**
	 * 图书
	 */
	private Book book;
	/**
	 * 单品种图书总数量
	 */
	private int count;
	/**
	 * 单品种图书的总金额
	 */
//	private double amount;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 单品种的图书总金额是通过计算得来的
	 * @return
	 */
	public double getAmount() {
		double price = getBook().getPrice();
		BigDecimal amount = new BigDecimal(price+"");
		BigDecimal count = new BigDecimal(getCount()+"");
		return amount.multiply(count).doubleValue();
	}
/*	public double getAmount() {
		double price = getBook().getPrice();
		return price*getCount();
	}*/

	
	
}
