package com.sport.service.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustPersonInfo;
import com.sport.service.CustPersonInfoService;
import com.sport.service.interf.ICustPersonInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class CustPersonInfoServiceImpl implements CustPersonInfoService{
	@Autowired
	private ICustPersonInfoService icustPersonInfoService;
	/**
	 * 增加会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response){
		String realName = request.getParameter("realName");
		String cardId = request.getParameter("cardId");
		String perEmail = request.getParameter("perEmail");
		String perTel = request.getParameter("perTel");
		String perMobile = request.getParameter("perMobile");
		String perSex = request.getParameter("perSex");
		String perWechat = request.getParameter("perWechat");
		String perQq = request.getParameter("perQq");
		String perHobby = request.getParameter("perHobby");
		String perAge = request.getParameter("perAge");
		String perAddr = request.getParameter("perAddr");
		
		CustPersonInfo custPersonInfo = new CustPersonInfo();
		custPersonInfo.setRealName(realName);
		custPersonInfo.setCardId(cardId);
		custPersonInfo.setPerEmail(perEmail);
		custPersonInfo.setPerTel(perTel);
		custPersonInfo.setPerMobile(perMobile);
		custPersonInfo.setPerSex(perSex);
		custPersonInfo.setPerWechat(perWechat);
		custPersonInfo.setPerQq(perQq);
		custPersonInfo.setPerHobby(perHobby);
		custPersonInfo.setPerAge(Integer.parseInt(perAge));
		custPersonInfo.setPerAddr(perAddr);
		
		String acctId = request.getParameter("acctId");
		custPersonInfo.setAcctId(Long.parseLong(acctId));
		
		try {
			icustPersonInfoService.save(custPersonInfo);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "增加会员信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 修改会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		String realName = request.getParameter("realName");
		String cardId = request.getParameter("cardId");
		String perEmail = request.getParameter("perEmail");
		String perTel = request.getParameter("perTel");
		String perMobile = request.getParameter("perMobile");
		String perSex = request.getParameter("perSex");
		String perWechat = request.getParameter("perWechat");
		String perQq = request.getParameter("perQq");
		String perHobby = request.getParameter("perHobby");
		String perAge = request.getParameter("perAge");
		String perAddr = request.getParameter("perAddr");
		//查找会员信息
		CustPersonInfo custPersonInfo = null;
		String id = request.getParameter("id");
		try {
			custPersonInfo = icustPersonInfoService.findByPK(Long.parseLong(id));
		} catch (Exception e1) {
			e1.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "获取会员信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		//修改会员信息
		if(custPersonInfo == null){
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "该会员不存在", null);
			return GsonUtil.getJsonFromObject(ar);
		}else{
			custPersonInfo.setRealName(realName);
			custPersonInfo.setCardId(cardId);
			custPersonInfo.setPerEmail(perEmail);
			custPersonInfo.setPerTel(perTel);
			custPersonInfo.setPerMobile(perMobile);
			custPersonInfo.setPerSex(perSex);
			custPersonInfo.setPerWechat(perWechat);
			custPersonInfo.setPerQq(perQq);
			custPersonInfo.setPerHobby(perHobby);
			custPersonInfo.setPerAge(Integer.parseInt(perAge));
			custPersonInfo.setPerAddr(perAddr);
			try {
				icustPersonInfoService.update(custPersonInfo);
			} catch (Exception e) {
				e.printStackTrace();
				AjaxReturnUtil ar = new AjaxReturnUtil(false, "修改会员信息异常", null);
				return GsonUtil.getJsonFromObject(ar);
			}
		}
		
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 根据账户ID获取会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustPersonInfo findByAcctId(HttpServletRequest request, HttpServletResponse response){
		//查找会员信息
		CustPersonInfo custPersonInfo = null;
		String id = request.getParameter("id");
		try {
			custPersonInfo = icustPersonInfoService.findByPK(Long.parseLong(id));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return custPersonInfo;
	}
	/**
	 * 根据主键获取会员信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustPersonInfo findByPk(HttpServletRequest request, HttpServletResponse response){
		//查找会员信息
		CustPersonInfo custPersonInfo = null;
		String acctId = request.getParameter("acctId");
		try {
			custPersonInfo = icustPersonInfoService.findByACCTID(Long.parseLong(acctId));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return custPersonInfo;
	}
}
