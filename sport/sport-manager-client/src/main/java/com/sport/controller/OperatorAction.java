package com.sport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.redis.model.StoreObject;
import com.sport.service.OperatorService;
import com.sport.service.RedisObjectService;

@Controller
@Scope("prototype")
@RequestMapping("/operator")
public class OperatorAction {
	@Autowired
	private OperatorService operatorSevice;
	@Autowired
	RedisObjectService redisObjectService;
	/**
	 * 跳转操作员页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("operator.do")
	public String operator(HttpServletRequest request, HttpServletResponse response, Model model) {
		StoreObject storeObject = redisObjectService.getObject("SEX");
		List sexlist = (List) storeObject.getObject();
		request.setAttribute("sexlist", sexlist);
		return "basic/operator";
	}
	/**
	 * 查询操作员方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.getList(request, response);
	}
	/**
	 * 新增操作员
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.add(request, response);
	}
	/**
	 * 修改操作员
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.edit(request, response);
	}
	/**
	 * 删除操作员
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.delete(request, response);
	}
	/**
	 * 导出操作员
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("export.do")
	@ResponseBody
	public String export(HttpServletRequest request, HttpServletResponse response, Model model) {
		String result = operatorSevice.export(request, response);
		request.setAttribute("result", result);
		return "export";
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("editpwd.do")
	@ResponseBody
	public String editpwd(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.editpwd(request, response);
	}
	
	/**
	 * 校验登录名
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("checkloginname.do")
	@ResponseBody
	public String checkloginname(HttpServletRequest request, HttpServletResponse response, Model model) {
		return operatorSevice.checkloginname(request, response);
	}
}
