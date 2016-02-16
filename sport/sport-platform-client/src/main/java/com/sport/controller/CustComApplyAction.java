package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.CustComApplyService;
import com.sport.service.SessionService;

@Controller
@Scope("prototype")
@RequestMapping("/custcomapply")
public class CustComApplyAction {
	@Autowired
	private CustComApplyService custComApplyService;
	@Autowired
	private SessionService sessionService;
	/**
	 * 跳转登陆页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("custcomapply.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "custcomapply";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("tocustcomapply.do")
	@ResponseBody
	public String tocustcomapply(HttpServletRequest request, HttpServletResponse response, Model model) {
		return custComApplyService.save(request, response,sessionService.getSessonInfo(request));
		
	}
}
