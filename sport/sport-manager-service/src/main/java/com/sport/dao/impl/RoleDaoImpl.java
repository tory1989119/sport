package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.RoleDao;
import com.sport.mapper.RoleMapper;
import com.sport.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
    private RoleMapper roleMapper;
	/**
	 * 添加角色
	 * @param role
	 * @throws Exception 
	 */
    public void addRole(Role role) throws Exception {
    	roleMapper.add(role);
    }  
    /**
     * 根据主键查找角色
     * @param role
     * @return
     * @throws Exception 
     */
    public Role getRoleById(Role role) throws Exception {
        return roleMapper.get(role);
    }  
    /**
     * 更新角色
     * @param role
     * @throws Exception 
     */
    public void updateRole(Role role) throws Exception {
    	roleMapper.update(role);
    }  
    /**
     * 删除角色
     * @param role
     * @throws Exception 
     */
    public void deleteRole(Role role) throws Exception {
        roleMapper.delete(role);
    }  
    /**
     * 查找角色
     * @param role
     * @return
     * @throws Exception 
     */
    public List<Role> findRoles(Role role) throws Exception{
    	return roleMapper.find(role);
    }
    /**
     * 统计记录数
     * @param role
     * @return
     * @throws Exception 
     */
	public int countRoles(Role role) throws Exception {
		return roleMapper.count(role);
	}
}
