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
import com.sport.service.MessageService;
import com.sport.service.SessionService;

@Controller
@Scope("prototype")
@RequestMapping("/message")
public class MessageAction {
	@Autowired
	private MessageService messageSevice;
	@Autowired
	private SessionService sessionService;
	/**
	 * 跳转留言页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("message.do")
	public String message(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "customer/message";
	}
	/**
	 * 查询留言方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return messageSevice.getList(request, response);
	}
	/**
	 * 修改留言
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		SessionInfo si = sessionService.getSessonInfo(request);
		return messageSevice.edit(request, response,si);
	}
	/**
	 * 删除留言
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return messageSevice.delete(request, response);
	}
}
