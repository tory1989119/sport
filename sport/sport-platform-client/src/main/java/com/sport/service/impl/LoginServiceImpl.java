package com.sport.service.impl;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.AcctInfo;
import com.sport.model.AcctLoginLog;
import com.sport.model.CustComInfo;
import com.sport.model.CustPersonInfo;
import com.sport.model.SessionInfo;
import com.sport.service.LoginService;
import com.sport.service.interf.IAcctInfoService;
import com.sport.service.interf.IAcctLoginLogService;
import com.sport.service.interf.ICustComInfoService;
import com.sport.service.interf.ICustPersonInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private IAcctInfoService iacctInfoService;
	@Autowired
	private IAcctLoginLogService iacctLoginLogService;
	@Autowired
	private ICustComInfoService icustComInfoService;
	@Autowired
	private ICustPersonInfoService icustPersonInfoService;
	
	
	public String login(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setUsername(username);
		acctInfo.setPassword(password);
		try {
			acctInfo =  iacctInfoService.login(acctInfo);
		} catch (Exception e) {
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "登录异常",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}
		
		if(acctInfo != null && acctInfo.getId() != 0){
			
			//保存session信息
			HttpSession session = request.getSession();
			SessionInfo si = new SessionInfo();
			
			si.setAcctId(acctInfo.getId());
			si.setAcctStatus(acctInfo.getAcctStatus());
			si.setAcctType(acctInfo.getAcctType());
			
			if(acctInfo.getAcctType().equals("0")){
				CustComInfo custComInfo = null;
				try {
					custComInfo = icustComInfoService.findByACCTID(acctInfo.getId());
				} catch (Exception e) {
					e.printStackTrace();
					AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "登录异常",null);
					return GsonUtil.getJsonFromObject(returnUtil);
				}
				si.setComId(custComInfo.getId());
				si.setComName(custComInfo.getComName());
				si.setComEmail(custComInfo.getComEmail());
				si.setComMobile(custComInfo.getComMobile());
				si.setComTel(custComInfo.getComTel());
			}else{
				CustPersonInfo custPersonInfo = null;
				try {
					custPersonInfo = icustPersonInfoService.findByACCTID(acctInfo.getId());
				} catch (Exception e) {
					e.printStackTrace();
					AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "登录异常",null);
					return GsonUtil.getJsonFromObject(returnUtil);
				}
				si.setPersonId(custPersonInfo.getId());
				si.setRealName(custPersonInfo.getRealName());
				si.setPerEmail(custPersonInfo.getPerEmail());
				si.setPerTel(custPersonInfo.getPerTel());
				si.setPerMobile(custPersonInfo.getPerMobile());
				si.setPerSex(custPersonInfo.getPerSex());
			}
			
			session.setAttribute("typlatform", si);
			
			//增加登录日志
			AcctLoginLog acctLoginLog = new AcctLoginLog();
			acctLoginLog.setAcctId(acctInfo.getId());
			acctLoginLog.setLoginDate(new Timestamp(System.currentTimeMillis()));
			acctLoginLog.setLoginIp("");
			acctLoginLog.setLoginStatus("");
			try {
				iacctLoginLogService.save(acctLoginLog);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(true, "成功",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}else{
			AjaxReturnUtil returnUtil = new AjaxReturnUtil(false, "该用户不存在，请检查登录名或者密码",null);
			return GsonUtil.getJsonFromObject(returnUtil);
		}
	}
	
	public void loginOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("typlatform");
	}
}
