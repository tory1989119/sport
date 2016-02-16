package com.sport.service.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustComInfo;
import com.sport.service.CustComInfoService;
import com.sport.service.interf.ICustComInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class CustComInfoServiceImpl implements CustComInfoService{
	@Autowired
	private ICustComInfoService icustComInfoService;
	/**
	 * 增加主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response){
		String comName = request.getParameter("comName");
		String comEmail = request.getParameter("comEmail");
		String comLicenseCode = request.getParameter("comLicenseCode");
		String comLicensePic = request.getParameter("comLicensePic");
		String comMobile = request.getParameter("comMobile");
		String comTel = request.getParameter("comTel");
		String comPerson = request.getParameter("comPerson");
		String comAuthorizePic = request.getParameter("comAuthorizePic");
		String comLogo = request.getParameter("comLogo");
		String comRemark = request.getParameter("comRemark");
		String comAddr = request.getParameter("comAddr");
		
		CustComInfo custComInfo = new CustComInfo();
		custComInfo.setComName(comName);
		custComInfo.setComEmail(comEmail);
		custComInfo.setComLicenseCode(comLicenseCode);
		custComInfo.setComLicensePic(comLicensePic);
		custComInfo.setComMobile(comMobile);
		custComInfo.setComTel(comTel);
		custComInfo.setComPerson(comPerson);
		custComInfo.setComAuthorizePic(comAuthorizePic);
		custComInfo.setComLogo(comLogo);
		custComInfo.setComRemark(comRemark);
		custComInfo.setComAddr(comAddr);
		
		String acctId = request.getParameter("acctId");
		custComInfo.setAcctId(Long.parseLong(acctId));
		
		try {
			icustComInfoService.save(custComInfo);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "增加主办方信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 修改主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		String comName = request.getParameter("comName");
		String comEmail = request.getParameter("comEmail");
		String comLicenseCode = request.getParameter("comLicenseCode");
		String comLicensePic = request.getParameter("comLicensePic");
		String comMobile = request.getParameter("comMobile");
		String comTel = request.getParameter("comTel");
		String comPerson = request.getParameter("comPerson");
		String comAuthorizePic = request.getParameter("comAuthorizePic");
		String comLogo = request.getParameter("comLogo");
		String comRemark = request.getParameter("comRemark");
		String comAddr = request.getParameter("comAddr");
		//查找主办方信息
		CustComInfo custComInfo = null;
		String id = request.getParameter("id");
		try {
			custComInfo = icustComInfoService.findByPK(Long.parseLong(id));
		} catch (Exception e1) {
			e1.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "获取主办方信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		//修改主办方信息
		if(custComInfo == null){
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "该主办方不存在", null);
			return GsonUtil.getJsonFromObject(ar);
		}else{
			custComInfo.setComName(comName);
			custComInfo.setComEmail(comEmail);
			custComInfo.setComLicenseCode(comLicenseCode);
			custComInfo.setComLicensePic(comLicensePic);
			custComInfo.setComMobile(comMobile);
			custComInfo.setComTel(comTel);
			custComInfo.setComPerson(comPerson);
			custComInfo.setComAuthorizePic(comAuthorizePic);
			custComInfo.setComLogo(comLogo);
			custComInfo.setComRemark(comRemark);
			custComInfo.setComAddr(comAddr);
			try {
				icustComInfoService.update(custComInfo);
			} catch (Exception e) {
				e.printStackTrace();
				AjaxReturnUtil ar = new AjaxReturnUtil(false, "修改主办方信息异常", null);
				return GsonUtil.getJsonFromObject(ar);
			}
		}
		
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 根据账户ID获取主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustComInfo findByAcctId(HttpServletRequest request, HttpServletResponse response){
		//查找主办方信息
		CustComInfo custComInfo = null;
		String id = request.getParameter("id");
		try {
			custComInfo = icustComInfoService.findByPK(Long.parseLong(id));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return custComInfo;
	}
	/**
	 * 根据主键获取主办方信息
	 * @param request
	 * @param response
	 * @return
	 */
	public CustComInfo findByPk(HttpServletRequest request, HttpServletResponse response){
		//查找主办方信息
		CustComInfo custComInfo = null;
		String acctId = request.getParameter("acctId");
		try {
			custComInfo = icustComInfoService.findByACCTID(Long.parseLong(acctId));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return custComInfo;
	}
}
