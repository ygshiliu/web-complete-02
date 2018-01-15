package com.atguigu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JDBCUtil;

/**
 * 文件名: BaseDao.java
 * 描述:BaseDao主要用来继承的，对数据库增删改查做统一处理
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午2:32:18
 */
public class BaseDao<T> {
	
	private QueryRunner qr = new QueryRunner();
	private Class<T> type ;
	
	public BaseDao() {
		//获取带泛型的父类
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//获取父类泛型中的类型数组
		Type[] actualTypeArguments = ((ParameterizedType)genericSuperclass).getActualTypeArguments();
		//取出类型
		type = (Class<T>) actualTypeArguments[0];
	}
	/**
	 * 用来对数据库做增删改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object ... params ){
		int count = 0;
		Connection conn = JDBCUtil.getConnection();
		try {
			count = qr.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.releaseConnection(conn);
		}
		return count;
	}
	
	/**
	 * 从数据库中获取一个bean对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql,Object ... params){
		T t = null;
		Connection conn = JDBCUtil.getConnection();
		
		try {
			t = qr.query(conn, sql,new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.releaseConnection(conn);
		}
		
		return t;
	}
	/**
	 * 从数据库中获取Bean对象集合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql,Object ... params){
		List<T> list = null;
		Connection conn = JDBCUtil.getConnection();
		try {
			list = qr.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.releaseConnection(conn);
		}
		return list;
	}
	/**
	 * 查询数据库中单个数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingle(String sql ,Object ... params){
		Object count = null;
		Connection conn = JDBCUtil.getConnection();
		
		try {
			count = qr.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
