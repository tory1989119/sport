package com.sport.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sport.service.PictureService;
import com.sport.common.util.Configuration;
import com.sport.common.util.FileUploadUtil;
import com.sport.common.util.GsonUtil;

@Controller
@Scope("prototype")
@RequestMapping("/picture")
public class PictureAction {
	@Autowired
	private PictureService pictureService;
	/**
	 * 跳转图片上传页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("picture.do")
	public String picture(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "basic/picture";
	}
	/**
	 * 增加图片上传
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("upload.do")
	@ResponseBody
	public String upload(HttpServletRequest request, HttpServletResponse response, Model model) {
		String fileUrl = "";
		try {
			MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
			MultipartFile imgFile  =  multipartRequest.getFile("file_data");
			fileUrl = Configuration.getGlobalMsg("imageuploaddir") + imgFile.getOriginalFilename();             
			File file = new File(fileUrl);
        	imgFile.transferTo(file);     
        } catch (Exception e) {
        	e.printStackTrace();
        	FileUploadUtil fu = new FileUploadUtil("上传失败", null);
            return GsonUtil.getJsonFromObject(fu);
        }
        
       return pictureService.addOrEdit(request, response,fileUrl);
	}
}
