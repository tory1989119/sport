package com.sport.dao;

import java.util.List;

import com.sport.model.Menu;
 
public interface MenuDao {
	/**
	 * 增加菜单
	 * @param menu
	 * @throws Exception 
	 */
	public void addMenu(Menu menu) throws Exception;
    /**
     * 根据主键查找菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public Menu getMenuById(Menu menu) throws Exception;
    /**
     * 更新菜单
     * @param menu
     * @throws Exception 
     */
    public void updateMenu(Menu menu) throws Exception;
    /**
     * 删除菜单
     * @param menu
     * @throws Exception 
     */
    public void deleteMenu(Menu menu) throws Exception;
    /**
     * 查找菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public List<Menu> findMenus(Menu menu) throws Exception;
}
