package com.sport.service;

import javax.servlet.http.HttpServletRequest;

import com.sport.model.SessionInfo;

public interface SessionService {
	
	public SessionInfo getSessonInfo(HttpServletRequest request);
}
