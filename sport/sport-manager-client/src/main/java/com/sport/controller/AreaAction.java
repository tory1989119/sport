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

import com.sport.model.Area;
import com.sport.redis.model.StoreObject;
import com.sport.service.AreaService;
import com.sport.service.RedisObjectService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Controller
@Scope("prototype")
@RequestMapping("/area")
public class AreaAction {
	@Autowired
	private AreaService areaService;
	@Autowired
	RedisObjectService redisObjectService;
	/**
	 * 跳转地区页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("area.do")
	public String area(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Area> slist = areaService.getAreas(request, response, "000000", "2");//获取省
		request.setAttribute("slist", slist);
		
		StoreObject storeObject = redisObjectService.getObject("AREAG");
		List areaglist = (List) storeObject.getObject();
		request.setAttribute("areaglist", areaglist);
		return "basic/area";
	}
	
	/**
	 * 查询地区列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return areaService.getList(request, response);
	}
	/**
	 * 增加地区
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public String add(HttpServletRequest request, HttpServletResponse response, Model model) {
		return areaService.add(request, response);
	}
	/**
	 * 删除地区
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return areaService.delete(request, response);
	}
	/**
	 * 获取地区下拉列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getareas.do")
	@ResponseBody
	public String getareas(HttpServletRequest request, HttpServletResponse response, Model model) {
		String grade = request.getParameter("grade");
		String fid = request.getParameter("fid");
		if(grade == null || grade == ""){
			AjaxReturnUtil ru = new AjaxReturnUtil(false, "地区等级不能为空", null);
			return GsonUtil.getJsonFromObject(ru);
		}
		if(fid == null || fid == ""){
			AjaxReturnUtil ru = new AjaxReturnUtil(false, "父节点ID不能为空", null);
			return GsonUtil.getJsonFromObject(ru);
		}
		
		List<Area> data = areaService.getAreas(request, response, fid, grade);
		AjaxReturnUtil ru = new AjaxReturnUtil(true, "成功", data);
		return GsonUtil.getJsonFromObject(ru);
	}
}
