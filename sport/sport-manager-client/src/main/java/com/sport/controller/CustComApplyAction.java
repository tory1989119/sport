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
import com.sport.service.CustComApplyService;
import com.sport.service.RedisObjectService;

@Controller
@Scope("prototype")
@RequestMapping("/custcomapply")
public class CustComApplyAction {
	@Autowired
	private CustComApplyService custComApplySevice;
	@Autowired
	RedisObjectService redisObjectService;
	/**
	 * 跳转主办方授权审核页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("custcomapply.do")
	public String custcomapply(HttpServletRequest request, HttpServletResponse response, Model model) {
		StoreObject storeObject = redisObjectService.getObject("APPLYSTATUS");
		List statuslist = (List) storeObject.getObject();
		request.setAttribute("statuslist", statuslist);
		return "member/custcomapply";
	}
	/**
	 * 查询主办方授权审核方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return custComApplySevice.getList(request, response);
	}
	/**
	 * 修改主办方授权审核
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		return custComApplySevice.edit(request, response);
	}
}
