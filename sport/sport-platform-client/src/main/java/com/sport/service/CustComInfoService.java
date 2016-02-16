package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.CustComInfo;

public interface CustComInfoService {
	/**
	 * 增加主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据账户ID获取主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustComInfo findByAcctId(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据主键获取主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustComInfo findByPk(HttpServletRequest request, HttpServletResponse response);
}
