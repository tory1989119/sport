package com.sport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
	
	public String login(HttpServletRequest request, HttpServletResponse response);
	
	public void loginOut(HttpServletRequest request, HttpServletResponse response);
}
