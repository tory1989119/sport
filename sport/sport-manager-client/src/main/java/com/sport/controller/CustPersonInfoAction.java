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
import com.sport.service.CustPersonInfoService;
import com.sport.service.RedisObjectService;

@Controller
@Scope("prototype")
@RequestMapping("/custpersoninfo")
public class CustPersonInfoAction {
	@Autowired
	private CustPersonInfoService custPersonInfoSevice;
	@Autowired
	RedisObjectService redisObjectService;
	/**
	 * 跳转会员页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("custpersoninfo.do")
	public String custpersoninfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		StoreObject storeObject = redisObjectService.getObject("SEX");
		List sexlist = (List) storeObject.getObject();
		request.setAttribute("sexlist", sexlist);
		return "member/custpersoninfo";
	}
	/**
	 * 查询会员方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return custPersonInfoSevice.getList(request, response);
	}
}
