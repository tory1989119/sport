package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Template;
import com.sport.service.TemplateService;
import com.sport.service.interf.ITemplateService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.util.FileUploadUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class TemplateServiceImpl implements TemplateService{
	@Autowired
	private ITemplateService itemplateService;
	/**
	 * 获取模板列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    String name = request.getParameter("name");
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
		Template template = new Template();
		template.setName(name);
		template.setStartadate(startdate);
		template.setEndadate(enddate);
		
		template.setStart(Integer.valueOf(start));
		template.setLength(Integer.valueOf(length));
		
		List<Template> data = new ArrayList<Template>();
		int count = 0;
		try {
			data = itemplateService.findTemplates(template);
			count = itemplateService.countTemplates(template);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 添加模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response){
		Template template = new Template();
		template.setName(request.getParameter("name"));
		try {
			itemplateService.addTemplate(template);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 修改模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		Template template = null;
		try {
			template = itemplateService.getTemplateById(Long.parseLong(request.getParameter("id")));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(template == null){
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"未找到该模板",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		template.setName(request.getParameter("name"));
		try {
			itemplateService.updateTemplate(template);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		try {
			itemplateService.deleteTemplate(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 上传模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String upload(HttpServletRequest request, HttpServletResponse response,String fileUrl,String pagename){
		Template template = null;
		try {
			template = itemplateService.getTemplateById(Long.parseLong(request.getParameter("id")));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(template == null){
			FileUploadUtil fu = new FileUploadUtil("未找到该模板",null);
            return GsonUtil.getJsonFromObject(fu);
		}
		template.setPagename(pagename);
		template.setUrl(fileUrl);;
		try {
			itemplateService.updateTemplate(template);
		} catch (Exception e) {
			FileUploadUtil fu = new FileUploadUtil(e.getMessage(),null);
            return GsonUtil.getJsonFromObject(fu);
		}
		
		FileUploadUtil fu = new FileUploadUtil();
        return GsonUtil.getJsonFromObject(fu);
	}

}
