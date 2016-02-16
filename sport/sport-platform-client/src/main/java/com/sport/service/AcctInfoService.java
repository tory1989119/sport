package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AcctInfoService {
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	public String editPwd(HttpServletRequest request, HttpServletResponse response);
}
