package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Category;
import com.sport.service.CategoryService;
import com.sport.service.interf.ICategoryService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private ICategoryService icategoryService;
	/**
	 * 获取活动分类列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    String categoryname = request.getParameter("categoryname");
	    String grade = request.getParameter("grade");
	    String categoryid = request.getParameter("categoryid");
	    String fid = request.getParameter("fid");
		Category category = new Category();
		category.setCategoryname(categoryname);
		category.setGrade(grade);
		category.setCategoryid(categoryid);
		category.setFid(fid);
		
		category.setStart(Integer.valueOf(start));
		category.setLength(Integer.valueOf(length));
		
		List<Category> data = new ArrayList<Category>();
		int count = 0;
		try {
			data = icategoryService.findCategorys(category);
			count = icategoryService.countCategorys(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 添加活动分类
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response){
		String grade = request.getParameter("grade");
		String categoryid = request.getParameter("categoryid");
		
		Category category = new Category();
		
		if("1".equals(grade)){
			category.setGrade(grade);
			category.setFid("0");
			category.setCategoryname(request.getParameter("categoryname"));
			
			Category mcategory = new Category();
			mcategory.setGrade(grade);
			mcategory.setFid("0");
			String mxcategoryid = "";
			try {
				mxcategoryid = icategoryService.maxCategorys(mcategory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置活动分类编号
			if(mxcategoryid == null || mxcategoryid == ""){
				category.setCategoryid("010000");
			}else{
				int one = Integer.parseInt(mxcategoryid.substring(0, 2)) + 1;
				if(one > 9){
					category.setCategoryid(one + "0000");
				}else{
					category.setCategoryid("0" + one + "0000");
				}
			}
		}else if("2".equals(grade)){
			category.setGrade(grade);
			category.setFid(categoryid);
			category.setCategoryname(request.getParameter("categoryname"));
			
			Category mcategory = new Category();
			mcategory.setGrade(grade);
			mcategory.setFid(categoryid);
			String mxcategoryid = "";
			try {
				mxcategoryid = icategoryService.maxCategorys(mcategory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置活动分类编号
			if(mxcategoryid == null || mxcategoryid == ""){
				category.setCategoryid(categoryid.substring(0, 2) + "0100");
			}else{
				int two = Integer.parseInt(mxcategoryid.substring(2, 4)) + 1;
				if(two > 9){
					category.setCategoryid(categoryid.substring(0, 2) + two + "00");
				}else{
					category.setCategoryid(categoryid.substring(0, 2) + "0" + two + "00");
				}
			}
		}else if("3".equals(grade)){
			category.setGrade(grade);
			category.setFid(categoryid);
			category.setCategoryname(request.getParameter("categoryname"));
			
			Category mcategory = new Category();
			mcategory.setGrade(grade);
			mcategory.setFid(categoryid);
			String mxcategoryid = "";
			try {
				mxcategoryid = icategoryService.maxCategorys(mcategory);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置活动分类编号
			if(mxcategoryid == null || mxcategoryid == ""){
				category.setCategoryid(categoryid.substring(0, 4) + "01");
			}else{
				int three = Integer.parseInt(mxcategoryid.substring(4, 6)) + 1;
				if(three > 9){
					category.setCategoryid(categoryid.substring(0, 4) + three);
				}else{
					category.setCategoryid(categoryid.substring(0, 4) + "0" + three);
				}
			}
		}else{
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"分类等级未知",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		try {
			icategoryService.addCategory(category);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除活动分类
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		long id = Long.parseLong(request.getParameter("id"));
		try {
			
			Category category = icategoryService.getCategoryById(id);
			Category fcategory = new Category();
			fcategory.setFid(category.getCategoryid());
			int count = icategoryService.countCategorys(fcategory);
			if(count >= 1){
				AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"此分类拥有下次分类，请先删除下级分类",null);
				return GsonUtil.getJsonFromObject(rmsg);
			}
			icategoryService.deleteCategory(id);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 根据查询条件获取活动分类 下拉列表
	 * @param request
	 * @param response
	 * @param fid
	 * @param grade
	 * @return
	 */
	public List<Category> getCategorys(HttpServletRequest request, HttpServletResponse response,String fid,String grade){
		Category category = new Category();
		category.setGrade(grade);
		category.setFid(fid);
		List<Category> data = new ArrayList<Category>();
		try {
			data = icategoryService.findCategorys(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
