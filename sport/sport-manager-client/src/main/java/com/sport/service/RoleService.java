package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RoleService {
	/**
	 * 获取角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取角色权限 
	 * @param request
	 * @param response
	 * @return
	 */
	public void authority(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 设置角色权限
	 * @param request
	 * @param response
	 * @return
	 */
	public String setauthority(HttpServletRequest request, HttpServletResponse response);
}
