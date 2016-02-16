package com.sport.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Operator;
import com.sport.model.SessionInfo;
import com.sport.service.LoginService;
import com.sport.service.interf.IOperatorService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private IOperatorService ioperatorService;
	
	public String login(HttpServletRequest request, HttpServletResponse response){
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		Operator operator = new Operator();
		operator.setLoginname(loginname);
		operator.setPassword(password);
		try {
			operator =  ioperatorService.login(operator);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "登录异常",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}
		
		if(operator != null && operator.getId() != 0){
			if(operator.getRoleid() != 0){
				//保存session信息
				HttpSession session = request.getSession();
				SessionInfo si = new SessionInfo();
				si.setId(operator.getId());
				si.setName(operator.getName());
				si.setPhone(operator.getPhone());
				si.setSex(operator.getSex());
				si.setEmail(operator.getEmail());
				si.setAddress(operator.getAddress());
				si.setAdate(operator.getAdate());
				si.setRoleid(operator.getRoleid());
				session.setAttribute("tymanager", si);
				
				AjaxReturnUtil returnUtil = new AjaxReturnUtil(true, "成功",null);
				 return GsonUtil.getJsonFromObject(returnUtil);
			}else{
				AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "该用户无角色，请联系管理员添加角色",null);
				return GsonUtil.getJsonFromObject(returnUtil);
			}
		}else{
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "该用户不存在，请检查登录名或者密码",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}
	}
	
	public void loginOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("tymanager");
	}
}
