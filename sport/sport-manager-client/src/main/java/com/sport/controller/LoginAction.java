package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.model.SessionInfo;
import com.sport.service.LoginService;
import com.sport.service.MenuService;
import com.sport.service.OperatorService;
import com.sport.service.SessionService;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	@Autowired
	private LoginService loginSevice;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private SessionService sessionService;
	/**
	 * 跳转登陆页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "login";
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("tologin.do")
	@ResponseBody
	public String tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
		return loginSevice.login(request, response);
		
	}
	/**
	 * 登出
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("loginout.do")
	public String loginout(HttpServletRequest request, HttpServletResponse response, Model model) {
		loginSevice.loginOut(request, response);
		return "login";
	}
	/**
	 * 跳转菜单首页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("main.do")
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) {
		SessionInfo si = sessionService.getSessonInfo(request);
		menuService.getMenu(request, response,si.getRoleid());
		request.setAttribute("operator", si);
		return "main";
	}
}
