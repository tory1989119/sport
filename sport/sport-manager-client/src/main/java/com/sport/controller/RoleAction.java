package com.sport.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.RoleService;

@Controller
@Scope("prototype")
@RequestMapping("/role")
public class RoleAction {
	@Autowired
	private RoleService roleService;
	/**
	 * 跳转角色页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("role.do")
	public String role(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "basic/role";
	}
	/**
	 * 查询角色列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return roleService.getList(request, response);
	}
	/**
	 * 增加角色
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return roleService.add(request, response);
	}
	/**
	 * 修改角色
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		return roleService.edit(request, response);
	}
	/**
	 * 删除角色
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return roleService.delete(request, response);
	}
	
	/**
	 * 跳转修改权限页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("authority.do")
	public String authority(HttpServletRequest request, HttpServletResponse response, Model model) {
		roleService.authority(request, response);
		return "basic/authority";
	}
	/**
	 * 修改权限
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setauthority.do")
	@ResponseBody
	public String setauthority(HttpServletRequest request, HttpServletResponse response, Model model) {
		return roleService.setauthority(request, response);
	}
}
