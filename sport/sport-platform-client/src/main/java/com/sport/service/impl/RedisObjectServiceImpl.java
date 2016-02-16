package com.sport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.redis.RedisObjectDAO;
import com.sport.redis.model.StoreObject;
import com.sport.service.RedisObjectService;

@Service
@Scope("prototype")
public class RedisObjectServiceImpl implements RedisObjectService{
	@Autowired
	private RedisObjectDAO redisObjectDAO;
	
	public StoreObject getObject(String key){
		return redisObjectDAO.get(key);
	}
}
