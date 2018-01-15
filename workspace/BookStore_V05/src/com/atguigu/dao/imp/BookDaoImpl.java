package com.atguigu.dao.imp;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

/**
 * 文件名: BookDaoImpl.java
 * 描述: BookDao实现类
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月14日 上午10:33:38
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into bs_books(title,author,price,sale,stock,img_path) values (?,?,?,?,?,?)";
		return update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSale(),book.getStock(),book.getImgPath());
		
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update bs_books set title=?,author=?,price=?,sale=?,stock=?,img_path=? where id=?";
		return update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSale(),book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public int deleteBook(String bookId) {
		String sql ="delete from bs_books where id=?";
		return update(sql, bookId);
	}

	@Override
	public Book getBook(String bookId) {
		String sql ="select id,title,author,price,sale,stock,img_path imgPath from bs_books where id=?";
		return getBean(sql, bookId);
		
	}

	@Override
	public List<Book> getAll() {
		String sql ="select id,title,author,price,sale,stock,img_path imgPath from bs_books";
		return getBeanList(sql);
	}

	@Override
	public Page<Book> findBook(Page<Book> page) {
		//获取数据库的所有图书的记录数
		String sql = "select count(*) from bs_books";
		long count = (long) getSingle(sql);
		page.setTotalCount((int)count);

		//从数据库中获取要显示的数据
		sql = "select id,title,author,price,sale,stock,img_path imgPath from bs_books order by id desc limit ?,? ";
		List<Book> list = getBeanList(sql, page.getIndex(),page.getPageSize());
		page.setList(list);
		
		
		return page;
		
	}

	@Override
	public Page<Book> findBookByPrice(Page<Book> page, int min, int max) {
		//获取数据库的所有图书的记录数
		String sql = "select count(*) from bs_books where price between ? and ?";
		long count = (long) getSingle(sql,min,max);
		page.setTotalCount((int)count);

		//从数据库中获取要显示的数据
		sql = "select id,title,author,price,sale,stock,img_path imgPath from bs_books where price between ? and ? order by id desc limit ?,? ";
		List<Book> list = getBeanList(sql,min,max, page.getIndex(),page.getPageSize());
		page.setList(list);
		
		
		return page;
	}

}
