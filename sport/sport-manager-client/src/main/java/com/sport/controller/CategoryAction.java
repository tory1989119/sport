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

import com.sport.model.Category;
import com.sport.redis.model.StoreObject;
import com.sport.service.CategoryService;
import com.sport.service.RedisObjectService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Controller
@Scope("prototype")
@RequestMapping("/category")
public class CategoryAction {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	RedisObjectService redisObjectService;
	/**
	 * 跳转活动分类页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("category.do")
	public String category(HttpServletRequest request, HttpServletResponse response, Model model) {
		StoreObject storeObject = redisObjectService.getObject("CATEGORYG");
		List categoryglist = (List) storeObject.getObject();
		request.setAttribute("categoryglist", categoryglist);
		return "basic/category";
	}
	
	/**
	 * 查询活动分类列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return categoryService.getList(request, response);
	}
	/**
	 * 增加活动分类
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return categoryService.add(request, response);
	}
	/**
	 * 删除活动分类
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return categoryService.delete(request, response);
	}
	/**
	 * 获取活动分类下拉列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getcategorys.do")
	@ResponseBody
	public String getcategorys(HttpServletRequest request, HttpServletResponse response, Model model) {
		String grade = request.getParameter("grade");
		String fid = request.getParameter("fid");
		if(grade == null || grade == ""){
			AjaxReturnUtil ru = new AjaxReturnUtil(false, "活动分类等级不能为空", null);
			return GsonUtil.getJsonFromObject(ru);
		}
		if(fid == null || fid == ""){
			AjaxReturnUtil ru = new AjaxReturnUtil(false, "父节点ID不能为空", null);
			return GsonUtil.getJsonFromObject(ru);
		}
		
		List<Category> data = categoryService.getCategorys(request, response, fid, grade);
		AjaxReturnUtil ru = new AjaxReturnUtil(true, "成功", data);
		return GsonUtil.getJsonFromObject(ru);
	}
}
