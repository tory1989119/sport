package com.sport.redis;

import java.util.List;

import com.sport.redis.model.StoreObject;


public interface RedisObjectDAO {
	/**
	 * 单个添加
	 * @param object
	 * @return
	 */
	public boolean add(StoreObject object);
	/**
	 * 多个添加
	 * @param list
	 * @return
	 */
	public boolean add(List<StoreObject> list);
	/**
	 * 单个添加
	 * @param object
	 */
	public void set(StoreObject object);
	/**
	 * 单个删除
	 * @param key
	 */
	public void delete(String key);
	/**
	 * 多个删除
	 * @param keys
	 */
	public void delete(List<String> keys);
	/**
	 * 单个更新
	 * @param object
	 * @return
	 */
	public boolean update(StoreObject object);
	/**
	 * 单个获取
	 * @param key
	 * @return
	 */
	public StoreObject get(String key);
	/**
	 * 设置过期时间
	 * @param key
	 * @param timeout
	 */
	public void expire(String key,long timeout);
}
