package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.AcctInfoService;

@Controller
@Scope("prototype")
@RequestMapping("/regist")
public class RegistAction {
	@Autowired
	private AcctInfoService acctInfoService;
	/**
	 * 跳转登陆页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("regist.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "regist";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toregist.do")
	@ResponseBody
	public String tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
		return acctInfoService.regist(request, response);
		
	}
}
