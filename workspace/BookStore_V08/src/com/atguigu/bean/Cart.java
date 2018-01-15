package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件名: Cart.java
 * 描述: 封装购物车信息
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月17日 下午3:23:19
 */
public class Cart implements Serializable{
	/**
	 * 用来保存购物项
	 */
	private Map<String,CartItem> map = new HashMap<String,CartItem>();
	/**
	 * 购物车总金额
	 */
	private double totalAmount;
	/**
	 * 购物车总数量
	 */
	private int totalCount;
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	/**
	 * 购物车的总金额：通过计算购物车所有的购物项金额之和
	 * @return
	 */
	public double getTotalAmount() {
		BigDecimal amount = new BigDecimal("0");
		List<CartItem> list = getList();
		for(CartItem item:list){
			BigDecimal d1 = new BigDecimal(item.getAmount()+"");
			amount = amount.add(d1);
		}
		return amount.doubleValue();
	}
/*	public double getTotalAmount() {
		double amount = 0;
		List<CartItem> list = getList();
		for(CartItem item:list){
			amount+=item.getAmount();
		}
		return amount;
	}*/

	
	/**
	 * 购物车中的总数量：通过计算购物车所有的购物项得出
	 * @return
	 */
	public int getTotalCount() {
		int count = 0;
		List<CartItem> list = getList();
		for(CartItem item:list){
			count += item.getCount();
		}
		return count;
	}
	
	/**
	 * 获取List集合的所有购物项
	 */
	public List<CartItem> getList(){
		return new ArrayList(map.values());
	}
	
	/**
	 * 添加图书到购物车中
	 * @param book
	 */
	public void addBook2Cart(Book book){
		//根据图书id,获取购物车中的购物项
		CartItem item = map.get(book.getId()+"");
		
		if(item == null){
			//说明购物车中没有这种图书
			item = new CartItem();
			item.setBook(book);
			item.setCount(1);
			
			//将购物项放入购物车中
			map.put(book.getId()+"", item);
			
		}else{
			//说明购物车中有此图书，数量直接加1
			int count = item.getCount();
			item.setCount(count+1);
		}
	}
	/**
	 * 根据图书ID删除指定的购物项
	 * @param bookId
	 */
	public void deleteCartItem(String bookId){
		map.remove(bookId);
	}
	/**
	 * 修改指定的图书id的cartItem项的数量
	 * @param bookId
	 * @param count
	 */
	public void changeCount(String bookId,int count){
		//获取cartItem项
		CartItem cartItem = map.get(bookId);
		//设置cartItem项数量
		cartItem.setCount(count);
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
}
