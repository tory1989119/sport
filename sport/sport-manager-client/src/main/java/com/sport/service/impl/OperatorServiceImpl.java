package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Operator;
import com.sport.redis.RedisObjectDAO;
import com.sport.service.OperatorService;
import com.sport.service.interf.IOperatorService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.util.ExportExcelUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;
import com.sport.common.util.ValidatorUtil;

@Service
@Scope("prototype")
public class OperatorServiceImpl implements OperatorService{
	@Autowired
	private IOperatorService ioperatorService;
	@Autowired
	private RedisObjectDAO redisObjectDAO;
	/**
	 * 查询操作员列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
		
		Operator operator = new Operator();
		operator.setName(name);
		operator.setPhone(phone);
		
		operator.setStartadate(startdate);
		operator.setEndadate(enddate);
		
		
		operator.setStart(Integer.valueOf(start));
		operator.setLength(Integer.valueOf(length));
		
		List<Operator> data = new ArrayList<Operator>();
		int count = 0;
		try {
			data = ioperatorService.findOperators(operator);
			count = ioperatorService.countOperators(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 增加操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response){
		
		Operator operator = new Operator();
		operator.setName(request.getParameter("name"));
		operator.setPhone(request.getParameter("phone"));
		operator.setAddress(request.getParameter("address"));
		operator.setLoginname(request.getParameter("loginname"));
		operator.setPassword(request.getParameter("password"));
		operator.setSex(request.getParameter("sex"));
		operator.setEmail(request.getParameter("email"));
		
		String roleid = request.getParameter("roleid");
		if(!roleid.isEmpty()){
			operator.setRoleid(Long.parseLong(roleid));
		}
		try {
			ioperatorService.addOperator(operator);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 修改操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		Operator operator = new Operator();
		operator.setId(Long.parseLong(request.getParameter("id")));
		operator.setName(request.getParameter("name"));
		operator.setPhone(request.getParameter("phone"));
		operator.setAddress(request.getParameter("address"));
		operator.setLoginname(request.getParameter("loginname"));
		operator.setPassword(request.getParameter("password"));
		operator.setSex(request.getParameter("sex"));
		operator.setEmail(request.getParameter("email"));
		
		String roleid = request.getParameter("roleid");
		if(!roleid.isEmpty()){
			operator.setRoleid(Long.parseLong(roleid));
		}
		try {
			ioperatorService.updateOperator(operator);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		try {
			ioperatorService.deleteOperator(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	
	/**
	 * 导出操作员
	 * @param request
	 * @param response
	 * @return
	 */
	public String export(HttpServletRequest request, HttpServletResponse response){
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
		
		Operator operator = new Operator();
		operator.setName(name);
		operator.setPhone(phone);
		
		operator.setStartadate(startdate);
		operator.setEndadate(enddate);
		
		List data = new ArrayList();
		try {
			data = ioperatorService.findOperators(operator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] title = {"姓名","性别","手机号", "邮箱", "地址"};
		String[] titleId = {"name","sex,SEXM","phone", "email", "address"};
		String filename = "操作员列表.xls";
		return ExportExcelUtil.exportExcel(response, filename, title, titleId, data,redisObjectDAO);
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	public String editpwd(HttpServletRequest request, HttpServletResponse response){
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		Operator operator = new Operator();
		try {
			operator = ioperatorService.getOperatorById(Long.parseLong(request.getParameter("operatorid")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"系统异常",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		if(operator == null){
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"操作员不存在",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		if(!operator.getPassword().equals(oldpassword)){
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"输入旧密码错误",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		operator.setPassword(newpassword);
		
		try {
			ioperatorService.updateOperator(operator);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"系统异常",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		
		
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 校验登录名
	 * @param request
	 * @param response
	 * @return
	 */
	public String checkloginname(HttpServletRequest request, HttpServletResponse response){
		Operator operator = new Operator();
		operator.setLoginname(request.getParameter("loginname"));
		try {
			int count = ioperatorService.countOperators(operator);
			if(count >= 1){
				ValidatorUtil vu = new ValidatorUtil(false);
				return GsonUtil.getJsonFromObject(vu);
			}else{
				ValidatorUtil vu = new ValidatorUtil(true);
				return GsonUtil.getJsonFromObject(vu);
			}
		} catch (Exception e) {
			ValidatorUtil vu = new ValidatorUtil(false);
			return GsonUtil.getJsonFromObject(vu);
		}
	}
}
