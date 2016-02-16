package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.ActBaseInfoService;
import com.sport.service.SessionService;

@Controller
@Scope("prototype")
@RequestMapping("/actbaseinfo")
public class ActBaseInfoAction {
	@Autowired
	private ActBaseInfoService actBaseInfoService;
	@Autowired
	private SessionService sessionService;
	/**
	 * 跳转活动穿件页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("actbaseinfo.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "actbaseinfo";
	}
	/**
	 * 活动创建
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toactbaseinfo.do")
	@ResponseBody
	public String toactbaseinfo(HttpServletRequest request, HttpServletResponse response, Model model) {
		return actBaseInfoService.save(request, response,sessionService.getSessonInfo(request));
		
	}
}
