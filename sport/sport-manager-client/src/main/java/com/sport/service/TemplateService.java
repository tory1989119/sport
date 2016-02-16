package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TemplateService {
	/**
	 * 获取模板列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 上传模板
	 * @param request
	 * @param response
	 * @return
	 */
	public String upload(HttpServletRequest request, HttpServletResponse response,String fileUrl,String pagename);

}
