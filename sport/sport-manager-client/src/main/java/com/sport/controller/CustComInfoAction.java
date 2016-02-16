package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.CustComInfoService;

@Controller
@Scope("prototype")
@RequestMapping("/custcominfo")
public class CustComInfoAction {
	@Autowired
	private CustComInfoService custComInfoSevice;
	/**
	 * 跳转主办方页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("custcominfo.do")
	public String custcominfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "member/custcominfo";
	}
	/**
	 * 查询主办方方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return custComInfoSevice.getList(request, response);
	}
}
