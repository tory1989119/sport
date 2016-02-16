package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.SessionInfo;

public interface ActBaseInfoService {
	/**
	 * 保存活动
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response, SessionInfo sessionInfo);
	/**
	 * 修改活动
	 * @param request
	 * @param response
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response);
}
