package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustComInfo;
import com.sport.service.CustComInfoService;
import com.sport.service.interf.ICustComInfoService;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class CustComInfoServiceImpl implements CustComInfoService{
	@Autowired
	private ICustComInfoService icustComInfoService;
	/**
	 * 查询主办方列表
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
	    String id = request.getParameter("id");
	    String comName = request.getParameter("comName");
		
	    CustComInfo custComInfo = new CustComInfo();
	    custComInfo.setComName(comName);
	    custComInfo.setStartregtime(startdate);
	    custComInfo.setEndregtime(enddate);
		if(id != "" && id != null){
			custComInfo.setId(Long.parseLong(id));
		}
		
		custComInfo.setStart(Integer.valueOf(start));
		custComInfo.setLength(Integer.valueOf(length));
		
		List<CustComInfo> data = new ArrayList<CustComInfo>();
		int count = 0;
		try {
			data = icustComInfoService.findPage(custComInfo);
			count = icustComInfoService.count(custComInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
}
