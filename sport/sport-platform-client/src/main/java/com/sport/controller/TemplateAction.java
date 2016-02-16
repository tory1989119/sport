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

import com.sport.service.TemplateService;
import com.sport.common.util.Configuration;
import com.sport.common.util.FileUploadUtil;
import com.sport.common.util.GsonUtil;

@Controller
@Scope("prototype")
@RequestMapping("/template")
public class TemplateAction {
	@Autowired
	private TemplateService templateService;
	/**
	 * 跳转模板页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("template.do")
	public String template(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "basic/template";
	}
	/**
	 * 查询模板列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return templateService.getList(request, response);
	}
	/**
	 * 增加模板
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return templateService.add(request, response);
	}
	/**
	 * 修改模板
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		return templateService.edit(request, response);
	}
	/**
	 * 删除模板
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return templateService.delete(request, response);
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
		String pagename = "";
		try {
	        MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;  
	        MultipartFile jspFile  =  multipartRequest.getFile("file_data");
	        pagename = jspFile.getOriginalFilename().split("\\.")[0];
	        fileUrl = Configuration.getGlobalMsg("templateuploaddir") + jspFile.getOriginalFilename();             
	        File file = new File(fileUrl);
	        jspFile.transferTo(file);     
        } catch (Exception e) {
        	e.printStackTrace();
        	FileUploadUtil fu = new FileUploadUtil("上传失败",null);
            return GsonUtil.getJsonFromObject(fu);
        }
        
       return templateService.upload(request, response,fileUrl,pagename);
	}
}
