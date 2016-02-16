package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sport.model.Picture;

public interface PictureService {
	/**
	 * 获取图片
	 * @param request
	 * @param response
	 * @return
	 */
	public Picture getPictureById(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 添加或修改图片
	 * @param request
	 * @param response
	 * @return
	 */
	public String addOrEdit(HttpServletRequest request, HttpServletResponse response,String url);
}
