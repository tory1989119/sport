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
import com.sport.service.ReportService;
import com.sport.service.SessionService;

@Controller
@Scope("prototype")
@RequestMapping("/report")
public class ReportAction {
	@Autowired
	private ReportService reportSevice;
	@Autowired
	private SessionService sessionService;
	/**
	 * 跳转举报页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("report.do")
	public String report(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "customer/report";
	}
	/**
	 * 查询举报方法
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getlist.do")
	@ResponseBody
	public String getlist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return reportSevice.getList(request, response);
	}
	/**
	 * 修改举报
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public String edit(HttpServletRequest request, HttpServletResponse response, Model model) {
		SessionInfo si = sessionService.getSessonInfo(request);
		return reportSevice.edit(request, response,si);
	}
	/**
	 * 删除举报
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		return reportSevice.delete(request, response);
	}
}
