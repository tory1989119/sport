package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Area;
import com.sport.service.AreaService;
import com.sport.service.interf.IAreaService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class AreaServiceImpl implements AreaService{
	@Autowired
	private IAreaService iareaService;
	/**
	 * 获取地区列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    String areaname = request.getParameter("areaname");
	    String grade = request.getParameter("grade");
	    String areaid = request.getParameter("areaid");
		Area area = new Area();
		area.setAreaname(areaname);
		area.setGrade(grade);
		area.setAreaid(areaid);
		
		area.setStart(Integer.valueOf(start));
		area.setLength(Integer.valueOf(length));
		
		List<Area> data = new ArrayList<Area>();
		int count = 0;
		try {
			data = iareaService.findAreas(area);
			count = iareaService.countAreas(area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 添加地区
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response){
		Area area = new Area();
		area.setGrade("5");
		String areaxj = request.getParameter("areaxj");
		if(areaxj == null || areaxj == ""){
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"县级或区未选择",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		area.setFid(areaxj);
		area.setAreaname(request.getParameter("areaname"));
		
		Area marea = new Area();
		marea.setGrade("5");
		marea.setFid(areaxj);
		String mxareaid = "";
		try {
			mxareaid = iareaService.maxAreas(marea);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//设置地区编号
		if(mxareaid == null || mxareaid == ""){
			area.setAreaid(areaxj + "01");
		}else{
			area.setAreaid(String.valueOf(Integer.parseInt(mxareaid) + 1));
		}
		
		try {
			iareaService.addArea(area);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除地区
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		try {
			iareaService.deleteArea(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 根据查询条件获取地区 下拉列表
	 * @param request
	 * @param response
	 * @param fid
	 * @param grade
	 * @return
	 */
	public List<Area> getAreas(HttpServletRequest request, HttpServletResponse response,String fid,String grade){
		Area area = new Area();
		area.setGrade(grade);
		area.setFid(fid);
		List<Area> data = new ArrayList<Area>();
		try {
			data = iareaService.findAreas(area);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
