package com.sport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.Area;

public interface AreaService {
	/**
	 * 获取地区列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加地区
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除地区
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据查询条件获取地区 下拉列表
	 * @param request
	 * @param response
	 * @param fid
	 * @param grade
	 * @return
	 */
	public List<Area> getAreas(HttpServletRequest request, HttpServletResponse response,String fid,String grade);
}
