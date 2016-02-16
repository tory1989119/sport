package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PictureService {
	/**
	 * 添加或修改图片
	 * @param request
	 * @param response
	 * @return
	 */
	public String addOrEdit(HttpServletRequest request, HttpServletResponse response,String fileUrl);
}
