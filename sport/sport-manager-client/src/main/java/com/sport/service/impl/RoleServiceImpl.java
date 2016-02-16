package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Menu;
import com.sport.model.Operator;
import com.sport.model.Role;
import com.sport.model.Treeview;
import com.sport.model.TreeviewState;
import com.sport.service.RoleService;
import com.sport.service.interf.IMenuService;
import com.sport.service.interf.IOperatorService;
import com.sport.service.interf.IRoleService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private IRoleService iroleService;
	@Autowired
	private IMenuService imenuService;
	@Autowired
	private IOperatorService ioperatorService;
	/**
	 * 获取角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    String rolename = request.getParameter("rolename");
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
		Role role = new Role();
		role.setRolename(rolename);
		role.setStartadate(startdate);
		role.setEndadate(enddate);
		
		role.setStart(Integer.valueOf(start));
		role.setLength(Integer.valueOf(length));
		
		List<Role> data = new ArrayList<Role>();
		int count = 0;
		try {
			data = iroleService.findRoles(role);
			count = iroleService.countRoles(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response){
		Role role = new Role();
		role.setRolename(request.getParameter("rolename"));
		try {
			iroleService.addRole(role);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 修改角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response){
		Role role = new Role();
		role.setId(Long.parseLong(request.getParameter("id")));
		role.setRolename(request.getParameter("rolename"));
		try {
			iroleService.updateRole(role);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除角色
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		Operator operator = new Operator();
		operator.setRoleid(Long.parseLong(request.getParameter("id")));
		List<Operator> list = new ArrayList<Operator>();;
		try {
			list = ioperatorService.findOperators(operator);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(list != null && list.size() > 0){
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,"该角色无法删除，操作员拥有此角色",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}else{
			try {
				iroleService.deleteRole(Long.parseLong(request.getParameter("id")));
			} catch (Exception e) {
				AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
				return GsonUtil.getJsonFromObject(rmsg);
			}
			AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
	}
	/**
	 * 获取角色权限 
	 * @param request
	 * @param response
	 * @return
	 */
	public void authority(HttpServletRequest request, HttpServletResponse response){
		
		Role role = null;
		try {
			role = iroleService.getRoleById(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> au = new ArrayList<String>();
		if(role != null && role.getAuthority() != null  && !role.getAuthority().isEmpty()){
			au = GsonUtil.getObject(role.getAuthority(), List.class);
		}
		
		Menu smenu = new Menu();
		smenu.setGrade("0");
		List<Menu> slist = new ArrayList<Menu>();
		try {
			slist = imenuService.findMenus(smenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Menu xmenu = new Menu();
		xmenu.setGrade("1");
		List<Menu> xlist = new ArrayList<Menu>();
		try {
			xlist = imenuService.findMenus(xmenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Treeview> sl = new ArrayList<Treeview>();
		for (int i = 0; i < slist.size(); i++) {
			Menu sm = slist.get(i);
			Treeview stv= new Treeview();
			stv.setText(sm.getUrlname());
			//stv.setId(sm.getMenuid());
			
			List<Treeview> xl = new ArrayList<Treeview>();
			boolean ischeck = true;//判断父级是否会被选中
			for (int j = 0; j < xlist.size(); j++) {
				Menu xm = xlist.get(j);
				if(xm.getFid().equals(sm.getMenuid())){
					Treeview xtv= new Treeview();
					xtv.setText(xm.getUrlname());
					xtv.setId(xm.getMenuid());
					//是否被选中
					for (int k = 0; k < au.size(); k++) {
						if(xm.getMenuid().equals(au.get(k))){
							xtv.setState(new TreeviewState(true));
							break;
						}
					}
					//判断是否被选中结果
					if(xtv.getState() != null){
						if(!xtv.getState().isChecked()){
							ischeck = false;
						}
					}else{
						ischeck = false;
					}
					
					xl.add(xtv);
				}
			}
			stv.setNodes(xl);
			//若该子集全部被选中，则父也被选中
			if(ischeck){
				stv.setState(new TreeviewState(true));
			}
			//若无子集则不显示
			if(stv.getNodes() != null && stv.getNodes().size() > 0){
				sl.add(stv);
			}
		}
		request.setAttribute("str", GsonUtil.getJsonFromObject(sl));
		request.setAttribute("roleid", role.getId());
	}
	/**
	 * 设置角色权限
	 * @param request
	 * @param response
	 * @return
	 */
	public String setauthority(HttpServletRequest request, HttpServletResponse response){
		Role role = null;
		try {
			role = iroleService.getRoleById(Long.parseLong(request.getParameter("id")));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String austr = request.getParameter("austr");
		List<String> list= new ArrayList<String>();
		
		if(austr != null && austr != ""){
			String[] au = austr.split(",");
			for (int i = 0; i < au.length; i++) {
				list.add(au[i]);
			}
		}
		
		if(role !=null){
			role.setAuthority(GsonUtil.getJsonFromObject(list));
		}
		
		try {
			iroleService.updateRole(role);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
}
