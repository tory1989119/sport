package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Menu;
import com.sport.model.Role;
import com.sport.service.MenuService;
import com.sport.service.interf.IMenuService;
import com.sport.service.interf.IRoleService;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private IMenuService imenuService;
	@Autowired
	private IRoleService iroleService;
	
	public void getMenu(HttpServletRequest request, HttpServletResponse response,Long roleid){
		StringBuffer barstr = new StringBuffer();
		
		Role role = null;
		try {
			role = iroleService.getRoleById(roleid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> aulist = new ArrayList<String>();
		if(role != null && role.getAuthority() != null){
			aulist = GsonUtil.getObject(role.getAuthority(), List.class);
		}
		
		Menu smenu = new Menu();
		smenu.setGrade("0");
		List<Menu> slist = new ArrayList<Menu>();
		try {
			slist = imenuService.findMenus(smenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < slist.size(); i++) {
			StringBuffer zbarstr = new StringBuffer();
			boolean ishas = false;
			
			smenu = slist.get(i);
			Menu xmenu = new Menu();
			xmenu.setGrade("1");
			xmenu.setFid(smenu.getMenuid());
			List<Menu> xlist = new ArrayList<Menu>();
			try {
				xlist = imenuService.findMenus(xmenu);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(xlist != null && xlist.size() > 0){
				
				zbarstr.append("<li class=\"treeview\"><a href=\"javascript:void(0)\"><span>");
				zbarstr.append(smenu.getUrlname());
				zbarstr.append("</span><i class=\"fa fa-angle-left pull-right\"></i></a><ul class=\"treeview-menu\">");
				for (int j = 0; j < xlist.size(); j++) {
					xmenu = xlist.get(j);
					for (int g = 0; g < aulist.size(); g++) {
						if(xmenu.getMenuid().equals(aulist.get(g))){
							zbarstr.append("<li><a onclick=\"getMenu('");
							zbarstr.append(xmenu.getUrl());
							zbarstr.append("');\" href=\"#\"><i class=\"fa fa-angle-double-right\"></i>");
							zbarstr.append(xmenu.getUrlname());
							zbarstr.append("</a></li>");
							ishas = true;
							break;
						}
					}
				}
				zbarstr.append("</ul></li>");
			}
			if(ishas){
				barstr.append(zbarstr);
			}
		}
		request.setAttribute("barstr", barstr.toString());

	}
}
