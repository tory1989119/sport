package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OperatorService {
	/**
	 * 查询操作员列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 增加操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 导出操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String export(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	public String editpwd(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 校验登录名
	 * @param request
	 * @param response
	 * @return
	 */
	public String checkloginname(HttpServletRequest request, HttpServletResponse response);
}
