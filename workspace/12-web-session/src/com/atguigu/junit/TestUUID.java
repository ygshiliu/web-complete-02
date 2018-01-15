package com.atguigu.junit;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

/**
 * 文件名: TestUUID.java
 * 描述: 
 * 开发人员： Miss Wang
 * 创建时间： 2017年3月16日 上午10:59:28
 */
public class TestUUID {

	@Test
	public void test() {
		//UUID是一个32位的唯一标识
		//它是由时间戳和机器码计算而成
		//UUID是一个全世界唯一的标识符，通过我们可以用来做对象的标识符，或是数据库的主键
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString().replace("-", ""));
		
		//时间戳就是从1970年1月1日 0时0分0秒 到现在的毫秒数
		long millis = System.currentTimeMillis();
		System.out.println(millis);
	}

}
