package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.MenuDao;
import com.sport.mapper.MenuMapper;
import com.sport.model.Menu;

import org.springframework.stereotype.Repository;

 
@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private MenuMapper menuMapper;
	/**
	 * 增加菜单
	 * @param menu
	 * @throws Exception 
	 */
    public void addMenu(Menu menu) throws Exception {
    	menuMapper.add(menu);
    }  
    /**
     * 根据主键查找菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public Menu getMenuById(Menu menu) throws Exception {
        return menuMapper.get(menu);
    }  
    /**
     * 更新菜单
     * @param menu
     * @throws Exception 
     */
    public void updateMenu(Menu menu) throws Exception {
    	menuMapper.update(menu);
    }  
    /**
     * 删除菜单
     * @param menu
     * @throws Exception 
     */
    public void deleteMenu(Menu menu) throws Exception {
        menuMapper.delete(menu);
    }  
    /**
     * 查找菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public List<Menu> findMenus(Menu menu) throws Exception{
    	return menuMapper.find(menu);
    }
}  
