package com.sport.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Report;
import com.sport.model.SessionInfo;
import com.sport.service.ReportService;
import com.sport.service.interf.IReportService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class ReportServiceImpl implements ReportService{
	@Autowired
	private IReportService ireportService;
	/**
	 * 查询举报列表
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
	    String actId = request.getParameter("actId");
	    String personId = request.getParameter("personId");
	    String customerId = request.getParameter("customerId");
		
		Report report = new Report();
		report.setStartdate(startdate);
		report.setEnddate(enddate);
		if(actId != "" && actId != null){
			report.setActId(Long.parseLong(actId));
		}
		
		if(personId != "" && personId != null){
			report.setPersonId(Long.parseLong(personId));
		}
		
		if(customerId != "" && customerId != null){
			report.setCustomerId(Long.parseLong(customerId));
		}
		
		report.setStart(Integer.valueOf(start));
		report.setLength(Integer.valueOf(length));
		
		List<Report> data = new ArrayList<Report>();
		int count = 0;
		try {
			data = ireportService.findReports(report);
			count = ireportService.countReports(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 修改举报
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response, SessionInfo si){
		Report report = new Report();
		report.setId(Long.parseLong(request.getParameter("id")));
		String reply = request.getParameter("reply");
		report.setReply(reply);
		report.setRdate(new Timestamp(System.currentTimeMillis()));
		
		report.setCustomerId(si.getId());
		report.setCustomerName(si.getName());
		try {
			ireportService.updateReport(report);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除举报
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		try {
			ireportService.deleteReport(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
}
