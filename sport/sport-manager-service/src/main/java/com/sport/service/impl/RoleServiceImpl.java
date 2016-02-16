package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.RoleDao;
import com.sport.model.Role;
import com.sport.service.interf.IRoleService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements IRoleService {
	@Autowired
    private RoleDao roledao;
    /**
     * 增加角色
     * @param role
     * @throws Exception 
     */
    @Transactional(readOnly = false)
    public void addRole(Role role) throws Exception {
    	roledao.addRole(role);
    }  
	/**
     * 根据主键查找角色
     * @param role
     * @return
	 * @throws Exception 
     */
    public Role getRoleById(long id) throws Exception {
    	Role role = new Role();
    	role.setId(id);
        return roledao.getRoleById(role);
    }  
    /**
     * 更新角色
     * @param role
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateRole(Role role) throws Exception {
    	roledao.updateRole(role);
    }  
    /**
     * 删除角色
     * @param role
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteRole(long id) throws Exception {
    	Role role = new Role();
    	role.setId(id);
    	roledao.deleteRole(role);
    }  
    /**
     * 查询角色
     * @param role
     * @return
     * @throws Exception 
     */
    public List<Role> findRoles(Role role) throws Exception{
    	return roledao.findRoles(role);
    }
    /**
     * 统计角色记录数
     * @param role
     * @return
     * @throws Exception 
     */
	public int countRoles(Role role) throws Exception {
		return roledao.countRoles(role);
	}
}  
