package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MenuService {
	
	public void getMenu(HttpServletRequest request, HttpServletResponse response,Long roleid);
}
