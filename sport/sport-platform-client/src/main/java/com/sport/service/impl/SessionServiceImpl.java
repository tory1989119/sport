package com.sport.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.SessionInfo;
import com.sport.service.SessionService;

@Service
@Scope("prototype")
public class SessionServiceImpl implements SessionService{
	
	public SessionInfo getSessonInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		SessionInfo si = (SessionInfo) session.getAttribute("typlatform");
		return si;
	}
}
