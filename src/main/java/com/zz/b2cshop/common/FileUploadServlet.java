package com.zz.b2cshop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.zz.b2cshop.common.util.FileUtils;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 9178933383160259031L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 初始化 FileItemFactory
		MultiPartRequestWrapper requert = (MultiPartRequestWrapper) req;
		Enumeration<String> fileNames = requert.getFileParameterNames();
		while (fileNames.hasMoreElements()) {
			String fileName = fileNames.nextElement();
			System.out.println(fileName);
			File[] files = requert.getFiles(fileName);
			FileInputStream in = new FileInputStream(files[0]);
			byte[] bytes = new byte[1024];
			int len= 0;
			while((len = in.read(bytes))!=-1) {
				FileUtils.writeFile("d:/Youku Files/"+fileName, bytes,true);
			}
			
			
		}
		FileItemFactory factory = new DiskFileItemFactory();

		// 初始化ServletFileUpload，可以说是一个封装好的的容器
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(req);
			for (int i = 0; i < list.size(); i++) {
				FileItem fileItem = list.get(i);

				// 根据你想要的如XX.jpg等，来截取字符串
				String name = fileItem.getName().substring(fileItem.getName().lastIndexOf("\\") + 1);

				// 保存，别说你不知道是什么。。。。
				req.getSession().setAttribute(name, true);
				fileItem.write(new File("d:/Youku Files/" + name));
				// 这是上传图片的名字，如果只规定上传一次的话，那么直接拿这个name，如果比较多的话，那么。。。考虑中
				System.out.println(name);
			}
			// 方法一、直接放入集合中，然后循环读出放入数据库（放一个图片就立即入库）
			// 方法二、再写一个servlet，然后直接读出upload下的子文件夹，放入数据库（在确认这些图片的情况下，不进行改动的情况下再去入库）
			// 考虑到可移植性的问题，那么采取方法二
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
