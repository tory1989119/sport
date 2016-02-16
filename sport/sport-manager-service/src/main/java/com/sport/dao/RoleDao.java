package com.sport.dao;

import java.util.List;

import com.sport.model.Role;

public interface RoleDao {
	/**
	 * 添加角色
	 * @param role
	 * @throws Exception 
	 */
    public void addRole(Role role) throws Exception;
    /**
     * 根据主键查找角色
     * @param role
     * @return
     * @throws Exception 
     */
    public Role getRoleById(Role role) throws Exception;
    /**
     * 更新角色
     * @param role
     * @throws Exception 
     */
    public void updateRole(Role role) throws Exception; 
    /**
     * 删除角色
     * @param role
     * @throws Exception 
     */
    public void deleteRole(Role role) throws Exception; 
    /**
     * 查找角色
     * @param role
     * @return
     * @throws Exception 
     */
    public List<Role> findRoles(Role role) throws Exception;
    /**
     * 统计记录数
     * @param role
     * @return
     * @throws Exception 
     */
	public int countRoles(Role role) throws Exception;
}
