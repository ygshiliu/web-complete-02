package com.atguigu.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		//获取用户输入的信息
		String name = request.getParameter("name");
		String filename = request.getParameter("file");
		System.out.println(name+"--"+filename);*/
		
		/*//获取输入流 ,进行解析
		ServletInputStream in = request.getInputStream();
		String str = IOUtils.toString(in);
		System.out.println(str);*/
		
		//创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//创建解析器
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		//问题4：限制文件上传大小,单位：字节
		//单个文件大小限制在5KB以内
		fileUpload.setFileSizeMax(1024*5);
		
		//上传文件总大小限制10KB
		fileUpload.setSizeMax(1024*10);
		
		
		//解析request
		try {
			//将每一个部件会封装成一个FileItem
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//遍历
			for (FileItem fileItem : list) {
				
				if(fileItem.isFormField()){
					//普通表单项
					//获取表单项的name属性值
					String name = fileItem.getFieldName();
					//获取表单项的value属性值 
					String value = fileItem.getString("utf-8");
					System.out.println("普通表单项："+name+"--"+value);
				}else{
					//文件
					
					//获取文件大小
					long size = fileItem.getSize();
					
					//问题3：过滤文件大小为0的
					if(size==0){
						continue;
					}
					
					//获取文件类型
					String type = fileItem.getContentType();
					
					//获取文件名称
					String name = fileItem.getName();
					
					//问题2：对name字符串进行判断
					if(name.contains("/")){
						//截取最后一个/后面的字符串
						name = name.substring(name.lastIndexOf("/")+1);
					}
					
					//获取表单项name属性名
					String fieldName = fileItem.getFieldName();
					
					//获取服务器上的物理路径
					ServletContext context = getServletContext();
					String path = context.getRealPath("/photo");
					//判断一下path是否存
					File file = new File(path);
					if(!file.exists()){
						//如果不存在，需要创建
						file.mkdirs();
					}
					
					//问题1：解决重名问题
					String uuid = UUID.randomUUID().toString().replace("-", "");
					
					//将文件保存到服务器
					fileItem.write(new File(path+"/"+uuid+"_"+name));
					
					/*
					 * 上传文件注意问题：
					 * 1. 文件重名问题？后上传的文件会覆盖之前上传的同名文件
					 * 	     解决方案：可以给文件加一个唯一的前缀。	
					 * 2. 通过FileItem.getName()方法获取到的文件名带有路径，比如：
					 * 		G:\课堂资料\准备素材\素材\风景图\狗狗.jpg
					 * 	  解决方案：对文件名进行字符串截取
					 * 3. 上传文件可以有多个，恰巧用户只需要上传两个，剩下的就空着，
					 * 	但是仍会上传到服务器，只不过是空文件，但是空文件也占资源，这样的资源有没有意义？只会浪费资源
					 * 	解决方案：是这样的文件， 我们就不要处理了
					 * 4.限制文件上传大小
					 * 
					 */
					
					System.out.println("===== 以下处理上传文件======");
					System.out.println("文件大小："+size);
					System.out.println("文件MIME值："+type);
					System.out.println("文件名称："+name);
					System.out.println("表单项name属性值："+fieldName);
					
				}
				
			}
			
			
		}catch(FileSizeLimitExceededException e){
			e.printStackTrace();
			request.setAttribute("msg","单个文件大小超过限制1024B");
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		}catch(SizeLimitExceededException e){
			request.setAttribute("msg","所有文件大小超过限制1024*10B");
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
			e.printStackTrace();
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
