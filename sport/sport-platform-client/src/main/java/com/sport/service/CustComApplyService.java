package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.SessionInfo;

public interface CustComApplyService {
	/**
	 * 增加主办方审核信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response, SessionInfo sessionInfo);
	/**
	 * 修改审核信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
}
