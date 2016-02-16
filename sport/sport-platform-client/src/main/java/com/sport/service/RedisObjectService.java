package com.sport.service;

import com.sport.redis.model.StoreObject;

public interface RedisObjectService {
	
	public StoreObject getObject(String key);
}
