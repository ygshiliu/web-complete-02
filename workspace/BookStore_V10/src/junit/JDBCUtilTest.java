package junit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.utils.JDBCUtil;

/**
 * 文件名: JDBCUtilTest.java
 * 描述: 测试数据库连接池连接
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月10日 下午2:28:41
 */
public class JDBCUtilTest {

	@Test
	public void testGetConnection() {
		Connection connection = JDBCUtil.getConnection();
		System.out.println(connection);
		
		//JDBCUtil.releaseConnection(connection);
	}
	
	

}
