package com.atguigu.dom4j;

import static org.junit.Assert.*;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.atguigu.bean.Student;

public class ParseDom4j {
	//解析全部的学生信息
	@Test
	public void test() throws Exception {
		//创建解析器类
		 SAXReader reader = new SAXReader();
		 //通过解析器解析xml文档
	     Document document = reader.read("students.xml");
	     
	     //domj4的一切解析是从根元素开去吧的
	     Element root = document.getRootElement();
	     
	     List list = root.elements("student");
	     for(int i=0;i<list.size();i++){
	    	 Element ele = (Element) list.get(i);
	    	 
	    	 //获取id属性
	    	 String id = ele.attributeValue("id");
	    	 
	    	 //获取name标签的文本值 
	    	 String name = ((Element)(ele.elements("name").get(0))).getText();
	    	 //获取age标签的文本值 
	    	 String age = ((Element)(ele.elements("age").get(0))).getText();
	    	 //获取sex标签的文本值 
	    	 String sex = ((Element)(ele.elements("sex").get(0))).getText();
	    	 
	    	// System.out.println(id+"--"+name+"--"+age+"--"+sex);
	    	 Student student = new Student(id, name, Integer.parseInt(age), sex);
	    	 System.out.println(student);
	     }
	     
	     
	}
	
	//使用xpath解析xml
	@Test
	public void testXpath() throws Exception{
		//查找一个学生信息
		//创建解析器
		SAXReader reader = new SAXReader();
		Document document = reader.read("students.xml");
		
		//通过xpath表达式获取一个元素对象
		Element ele = (Element) document.selectSingleNode("/students/student[@id=02]");
		String id = ele.attributeValue("id");
		String name = ele.elementText("name");
		String age = ele.elementText("age");
		String sex = ele.elementText("sex");
		
		Student student = new Student(id, name, Integer.parseInt(age), sex);
		System.out.println(student);
	}

}
