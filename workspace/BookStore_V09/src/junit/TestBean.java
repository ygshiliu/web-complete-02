package junit;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.atguigu.bean.User;

/**
 * 文件名: TestBean.java
 * 描述: 使用beanUtil工具
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月13日 上午10:22:31
 */
public class TestBean {

	@Test
	public void test() throws Exception {
		//setProperty()可以用来给一个javaBean设置一个属性
		User bean = new User();
		String name = "username1";
		String value = "刘在石";
		
		BeanUtils.setProperty(bean, name, value);
		System.out.println(bean);
	}

}
