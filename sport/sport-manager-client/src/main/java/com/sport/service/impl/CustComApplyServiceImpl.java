package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustComApply;
import com.sport.service.CustComApplyService;
import com.sport.service.interf.ICustComApplyService;
import com.sport.service.interf.ICustComInfoService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class CustComApplyServiceImpl implements CustComApplyService{
	@Autowired
	private ICustComApplyService icustComApplyService;
	@Autowired
	private ICustComInfoService icustComInfoService;
	/**
	 * 查询主办方授权审核列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
	    String acct_id = request.getParameter("acct_id");
	    String com_id = request.getParameter("com_id");
		
	    CustComApply custComApply = new CustComApply();
	    custComApply.setStartapplydate(startdate);
	    custComApply.setEndapplydate(enddate);
		if(acct_id != "" && acct_id != null){
			custComApply.setAcctId(Long.parseLong(acct_id));
		}
		
		if(com_id != "" && com_id != null){
			custComApply.setComId(Long.parseLong(com_id));
		}
		
		custComApply.setStart(Integer.valueOf(start));
		custComApply.setLength(Integer.valueOf(length));
		
		List<CustComApply> data = new ArrayList<CustComApply>();
		int count = 0;
		try {
			data = icustComApplyService.findPage(custComApply);
			count = icustComApplyService.count(custComApply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 修改主办方授权审核
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		String status = request.getParameter("status");
		String note = request.getParameter("note");
		CustComApply custComApply = new CustComApply();
		custComApply.setApplyStatus(status);
		custComApply.setNote(note);
		custComApply.setId(Long.parseLong(request.getParameter("id")));
		
		try {
			icustComApplyService.check(custComApply);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
}
