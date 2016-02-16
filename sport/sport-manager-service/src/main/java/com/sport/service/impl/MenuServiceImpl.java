package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.MenuDao;
import com.sport.model.Menu;
import com.sport.service.interf.IMenuService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("menuService")
@Transactional(readOnly = true)
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuDao menuDao;
	/**
	 * 增加菜单
	 * @param menu
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addMenu(Menu menu) throws Exception {
    	menuDao.addMenu(menu);
    }  
    /**
     * 根据主键查找菜单
     * @param id
     * @return
     * @throws Exception 
     */ 
    public Menu getMenuById(long id) throws Exception {
    	Menu menu = new Menu();
    	menu.setId(id);
        return menuDao.getMenuById(menu);
    }  
    /**
     * 更新菜单
     * @param menu
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateMenu(Menu menu) throws Exception {
    	menuDao.updateMenu(menu);
    }  
    /**
     * 删除菜单
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteMenu(long id) throws Exception {
    	Menu menu = new Menu();
    	menu.setId(id);
        menuDao.deleteMenu(menu);
    }  
    /**
     * 查询菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public List<Menu> findMenus(Menu menu) throws Exception{
    	return menuDao.findMenus(menu);
    }
}  
