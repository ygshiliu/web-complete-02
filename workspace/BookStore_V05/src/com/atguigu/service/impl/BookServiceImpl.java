package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.imp.BookDaoImpl;
import com.atguigu.service.BookService;

/**
 * 文件名: BookServiceImpl.java
 * 描述: BookService实现类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 上午10:54:52
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bd = new BookDaoImpl();
	@Override
	public int saveBook(Book book) {
		return bd.saveBook(book);
		
	}

	@Override
	public int updateBook(Book book) {
		return bd.updateBook(book);
		
	}

	@Override
	public int deleteBook(String bookId) {
		return bd.deleteBook(bookId);
		
	}

	@Override
	public Book getBook(String bookId) {
		return bd.getBook(bookId);
		
	}

	@Override
	public List<Book> getAll() {
		return bd.getAll();
		
	}

	@Override
	public Page<Book> findBook(String pageNoStr, String pageSizeStr) {

		//需要对用户传过来的当前面与每页显示条数进行处理
		//设置初始值
		int pageNo = 1;
		int pageSize = Integer.MAX_VALUE;
		
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (NumberFormatException e) {}
		
		//创建page对象
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		//调用dao方法
		page = bd.findBook(page);
		
		return page;
		
	}

	@Override
	public Page<Book> findBookByPrice(String pageNoStr, String pageSizeStr,
			String minstr, String maxstr) {

		//需要对用户传过来的当前面与每页显示条数进行处理
		//设置初始值
		int pageNo = 1;
		int pageSize = Integer.MAX_VALUE;
		
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (NumberFormatException e) {}
		
		int min = 0;
		int max = Integer.MAX_VALUE;
		
		try {
			min = Integer.parseInt(minstr);
		} catch (NumberFormatException e) {}
		
		try {
			max = Integer.parseInt(maxstr);
		} catch (NumberFormatException e) {}
		
		//创建page对象
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		//调用dao方法
		page = bd.findBookByPrice(page, min, max);
		
		return page;
		
	}

}
