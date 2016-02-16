package com.sport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.Category;

public interface CategoryService {
	/**
	 * 获取活动分类列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加活动分类
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除活动分类
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 根据查询条件获取活动分类 下拉列表
	 * @param request
	 * @param response
	 * @param fid
	 * @param grade
	 * @return
	 */
	public List<Category> getCategorys(HttpServletRequest request, HttpServletResponse response,String fid,String grade);
}
