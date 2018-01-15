package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

/**
 * 文件名: BookService.java
 * 描述: 与图书相关的业务操作
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 上午10:53:14
 */
public interface BookService {
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
	 * 查找图书的分页业务逻辑操作
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @return
	 */
	Page<Book> findBook(String pageNoStr,String pageSizeStr);
	/**
	 * 根据价格查询图书分页信息
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @return
	 */
	Page<Book> findBookByPrice(String pageNoStr,String pageSizeStr,String min,String max);
}
