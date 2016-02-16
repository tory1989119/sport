package com.sport.mapper;

import java.util.List;

import com.sport.model.Role;

public interface RoleMapper {  
  
	public void add(Role role) throws Exception;
  
	public Role get(Role role) throws Exception;
  
	public void update(Role role) throws Exception;
  
	public void delete(Role role) throws Exception;
  
	public List<Role> find(Role role) throws Exception;
	
	public int count (Role role) throws Exception;
}  