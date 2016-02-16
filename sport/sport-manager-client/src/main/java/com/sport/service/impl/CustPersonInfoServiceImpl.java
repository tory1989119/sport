package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.CustPersonInfo;
import com.sport.service.CustPersonInfoService;
import com.sport.service.interf.ICustPersonInfoService;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class CustPersonInfoServiceImpl implements CustPersonInfoService{
	@Autowired
	private ICustPersonInfoService icustPersonInfoService;
	/**
	 * 查询会员列表
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
	    String realName = request.getParameter("realName");
		
	    CustPersonInfo custPersonInfo = new CustPersonInfo();
	    custPersonInfo.setRealName(realName);
	    custPersonInfo.setStartregtime(startdate);
	    custPersonInfo.setEndregtime(enddate);
		if(id != "" && id != null){
			custPersonInfo.setId(Long.parseLong(id));
		}
		
		custPersonInfo.setStart(Integer.valueOf(start));
		custPersonInfo.setLength(Integer.valueOf(length));
		
		List<CustPersonInfo> data = new ArrayList<CustPersonInfo>();
		int count = 0;
		try {
			data = icustPersonInfoService.findPage(custPersonInfo);
			count = icustPersonInfoService.count(custPersonInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
}
