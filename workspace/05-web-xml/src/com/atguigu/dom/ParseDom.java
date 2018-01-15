package com.atguigu.dom;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.atguigu.bean.Student;

public class ParseDom {
	

	//解析所有学生
	@Test
	public void testAll() throws Exception {
		//获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//通过解析器工厂类获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//通过解析器解析xml文件
		Document document = builder.parse("students.xml");
		
		//xml本身是自定义标签，所以这里的id属性没有实际的意义
		//getElementById()在这里根本不能用
		//Element ele = document.getElementById("01");
		
		NodeList list = document.getElementsByTagName("student");
		for(int i=0;i<list.getLength();i++){
			//获取每一个student元素
			Element ele = (Element) list.item(i);
			
			//获取id属性值 
			String id = ele.getAttribute("id");
			
			if(!("02".equals(id))){
				continue;
			}
			
			//获取name元素
			NodeList nameList = ele.getElementsByTagName("name");
			Element nameEle = (Element) nameList.item(0);
			String name = nameEle.getTextContent();
			
			//获取age元素文本值 
			String age = ele.getElementsByTagName("age").item(0).getTextContent();
			
			//获取sex元素文本值 
			String sex = ele.getElementsByTagName("sex").item(0).getTextContent();
			
			Student student = new Student(id,name, Integer.parseInt(age), sex);
			
			System.out.println(student);
		}
		
		//System.out.println(ele);
		
	}

}
