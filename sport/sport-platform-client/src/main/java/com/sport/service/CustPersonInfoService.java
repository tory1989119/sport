package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.CustPersonInfo;

public interface CustPersonInfoService {
	/**
	 * 增加会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据账户ID获取会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustPersonInfo findByAcctId(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据主键获取会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustPersonInfo findByPk(HttpServletRequest request, HttpServletResponse response);
}
