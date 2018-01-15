package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 文件名: BookDao.java
 * 描述: 与图书相关的操作
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 上午10:18:18
 */
public interface BookDao {
	/**
	 * 保存一本图书
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	/**
	 * 修改一本图书信息
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	/**
	 * 根据图书id删除一本图书
	 * @param bookId
	 * @return
	 */
	int deleteBook(String bookId);
	
	/**
	 * 根据图书Id查找一本图书
	 * @param bookId
	 * @return
	 */
	Book getBook(String bookId);
	/**
	 * 获取所有图书
	 * @return
	 */
	List<Book> getAll();
	
	/**
	 * 与分页相关的图书查询操作
	 * @param page
	 * @return
	 */
	Page<Book> findBook(Page<Book> page);
	
	/**
	 * 根据价格来查询图书分页信息
	 * @param page
	 * @return
	 */
	Page<Book> findBookByPrice(Page<Book> page,int min,int max);
	/**
	 * 修改图书的库存与销量
	 */
	int updateStockAndSale(int sale,int stock,int bookId);
	/**
	 * 批量修改图书的库存和销量
	 * @param params
	 * @return
	 */
	int[] batchUpdateSaleAndStock(Object[][] params);
}
