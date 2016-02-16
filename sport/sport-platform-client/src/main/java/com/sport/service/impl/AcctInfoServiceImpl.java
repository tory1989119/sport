package com.sport.service.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.AcctInfo;
import com.sport.service.AcctInfoService;
import com.sport.service.interf.IAcctInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class AcctInfoServiceImpl implements AcctInfoService{
	@Autowired
	private IAcctInfoService iacctInfoService;
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String acctType = request.getParameter("acctType");
		
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setAcctStatus("0");
		acctInfo.setRegIp("");
		acctInfo.setAcctType(acctType);
		acctInfo.setUsername(username);
		acctInfo.setPassword(password);
		
		try {
			iacctInfoService.regist(acctInfo);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "注册异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	public String editPwd(HttpServletRequest request, HttpServletResponse response){
		String newpassword = request.getParameter("newpassword");
		String id = request.getParameter("id");
		//查找用户
		AcctInfo acctInfo = null;
		try {
			acctInfo = iacctInfoService.findByPK(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "获取用户信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		//修改用户
		if(acctInfo == null){
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "未获取到用户信息", null);
			return GsonUtil.getJsonFromObject(ar);
		}else{
			acctInfo.setPassword(newpassword);
			try {
				iacctInfoService.update(acctInfo);
			} catch (Exception e) {
				e.printStackTrace();
				AjaxReturnUtil ar = new AjaxReturnUtil(false, "修改密码异常", null);
				return GsonUtil.getJsonFromObject(ar);
			}
		}
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
}
