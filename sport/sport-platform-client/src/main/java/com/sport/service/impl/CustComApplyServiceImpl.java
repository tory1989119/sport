package com.sport.service.impl;


import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustComApply;
import com.sport.model.SessionInfo;
import com.sport.service.CustComApplyService;
import com.sport.service.interf.ICustComApplyService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class CustComApplyServiceImpl implements CustComApplyService{
	@Autowired
	private ICustComApplyService icustComApplyService;
	/**
	 * 增加主办方审核信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String save(HttpServletRequest request, HttpServletResponse response, SessionInfo sessionInfo){
		CustComApply comApply = new CustComApply();
		String comLogo = request.getParameter("comLogo");
		String comLicensePic = request.getParameter("comLicensePic");
		String comAuthorizePic = request.getParameter("comAuthorizePic");
		String note = request.getParameter("note");
		
		comApply.setAcctId(sessionInfo.getAcctId());
		comApply.setComId(sessionInfo.getComId());
		comApply.setApplyDate(new Timestamp(System.currentTimeMillis()));
		comApply.setNote(note);
		comApply.setComLogo(comLogo);
		comApply.setComAuthorizePic(comLicensePic);
		comApply.setComLicensePic(comAuthorizePic);
		comApply.setApplyStatus("0");
		
		try {
			icustComApplyService.save(comApply);
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "保存授权信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
	/**
	 * 修改审核信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		CustComApply comApply = null;
		String id = request.getParameter("id");
		String applyStatus = request.getParameter("applyStatus");
		try {
			comApply = icustComApplyService.findByPK(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "查询授权信息异常", null);
			return GsonUtil.getJsonFromObject(ar);
		}
		
		if(comApply == null){
			AjaxReturnUtil ar = new AjaxReturnUtil(false, "未查询到授权申请信息", null);
			return GsonUtil.getJsonFromObject(ar);
		}else{
			comApply.setApplyStatus(applyStatus);
			try {
				icustComApplyService.update(comApply);
			} catch (Exception e) {
				e.printStackTrace();
				AjaxReturnUtil ar = new AjaxReturnUtil(false, "申请手授权异常", null);
				return GsonUtil.getJsonFromObject(ar);
			}
		}
		AjaxReturnUtil ar = new AjaxReturnUtil(true, "成功", null);
		return GsonUtil.getJsonFromObject(ar);
	}
}
