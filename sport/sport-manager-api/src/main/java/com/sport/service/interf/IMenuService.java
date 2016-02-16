package com.sport.service.interf;

import java.util.List;

import com.sport.model.Menu;
 
public interface IMenuService {
	/**
	 * 增加菜单
	 * @param menu
	 * @throws Exception 
	 */
	public void addMenu(Menu menu) throws Exception;
    /**
     * 根据主键查找菜单
     * @param id
     * @return
     * @throws Exception 
     */
    public Menu getMenuById(long id) throws Exception;
    /**
     * 更新菜单
     * @param menu
     * @throws Exception 
     */
    public void updateMenu(Menu menu) throws Exception;
    /**
     * 删除菜单
     * @param id
     * @throws Exception 
     */
    public void deleteMenu(long id) throws Exception;
    /**
     * 查询菜单
     * @param menu
     * @return
     * @throws Exception 
     */
    public List<Menu> findMenus(Menu menu) throws Exception;
}
