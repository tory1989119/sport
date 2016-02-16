package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustComApplyService {
	/**
	 * 查询主办方授权申请列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改主办方授权申请
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
}
