package com.sport.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.ActBaseInfo;
import com.sport.model.SessionInfo;
import com.sport.service.ActBaseInfoService;
import com.sport.service.interf.IActBaseInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class ActBaseInfoServiceImpl implements ActBaseInfoService{
	@Autowired
	private IActBaseInfoService iactBaseInfoService;
	
	
	public String save(HttpServletRequest request, HttpServletResponse response, SessionInfo sessionInfo){
		String actName = request.getParameter("actName");
		String actTitle = request.getParameter("actTitle");
		String strjoinstart = request.getParameter("strjoinstart");
		String strjoinend = request.getParameter("strjoinend");
		String strholdstart = request.getParameter("strholdstart");
		String strholdend = request.getParameter("strholdend");
		String actPerson = request.getParameter("actPerson");
		String actPersonMobile = request.getParameter("actPersonMobile");
		String actRemark = request.getParameter("actRemark");
		String reward = request.getParameter("reward");
		String actAddr = request.getParameter("actAddr");
		
		ActBaseInfo actBaseInfo = new ActBaseInfo();
		actBaseInfo.setComId(sessionInfo.getComId());
		actBaseInfo.setComName(sessionInfo.getComName());
		actBaseInfo.setActName(actName);
		actBaseInfo.setActTitle(actTitle);
		actBaseInfo.setStrjoinstart(strjoinstart);
		actBaseInfo.setStrjoinend(strjoinend);
		actBaseInfo.setStrholdstart(strholdstart);
		actBaseInfo.setStrholdend(strholdend);
		actBaseInfo.setActPerson(actPerson);
		actBaseInfo.setActPersonMobile(actPersonMobile);
		actBaseInfo.setActRemark(actRemark);
		actBaseInfo.setReward(reward);
		actBaseInfo.setActAddr(actAddr);
		
		try {
			iactBaseInfoService.save(actBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "创建异常",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}
		AjaxReturnUtil returnUtil = new AjaxReturnUtil(true, "创建成功",null);
		return GsonUtil.getJsonFromObject(returnUtil);
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response){
		
	}
}
