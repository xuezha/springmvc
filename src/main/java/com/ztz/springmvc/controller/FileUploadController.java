package com.ztz.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ztz.springmvc.model.Users;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	private String fildUpload(Users users ,@RequestParam(value="file",required=false) MultipartFile[] file,
			HttpServletRequest request)throws Exception{
		//基本表单
		System.out.println(users.toString());
		
		//获得物理路径webapp所在路径
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		String path="";
		List<String> listImagePath=new ArrayList<String>();
		for (MultipartFile mf : file) {
			if(!mf.isEmpty()){
				//生成uuid作为文件名称
				String uuid = UUID.randomUUID().toString().replaceAll("-","");
				//获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType=mf.getContentType();
				//获得文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
				path="/static/images/"+uuid+"."+imageName;
				mf.transferTo(new File(pathRoot+path));
				listImagePath.add(path);
			}
		}
		System.out.println(path);
		request.setAttribute("imagesPathList", listImagePath);
		return "success";
	}
	//因为我的JSP在WEB-INF目录下面，浏览器无法直接访问
	@RequestMapping(value="/forward")
	private String forward(){
		return "index";
	}
}
