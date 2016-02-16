package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustComInfoService {
	/**
	 * 查询主办方列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
}
