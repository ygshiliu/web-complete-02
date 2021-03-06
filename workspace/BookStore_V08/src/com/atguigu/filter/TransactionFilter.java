package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.utils.JDBCUtil;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		//获取connection对象
		Connection conn = JDBCUtil.getConnection();
		
		try {
			//取消自动提交
			conn.setAutoCommit(false);
			
			//调用Dao处理数据
			chain.doFilter(req, resp);
			
			//提交事务
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("TransactionFilter异常捕获");
			try {
				//不成功，回滚
				conn.rollback();
//				出现异常，重定向到错误页面
				resp.sendRedirect(req.getContextPath()+"/pages/user/error.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			//JDBCUtil.releaseConnection(conn);
			JDBCUtil.releaseConnection();
		}
		
	}
	
}