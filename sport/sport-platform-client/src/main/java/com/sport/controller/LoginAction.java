package com.sport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sport.service.LoginService;

@Controller
@Scope("prototype")
@RequestMapping("/login")
public class LoginAction {
	@Autowired
	private LoginService loginSevice;
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
	 * 跳转首页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("main.do")
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "main";
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
}
