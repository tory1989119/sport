package com.sport.redis.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.sport.redis.AbstractBaseRedisDao;
import com.sport.redis.RedisObjectDAO;
import com.sport.redis.model.StoreObject;
import com.sport.common.util.SerializeUtil;

@Repository
public class RedisObjectDAOImpl extends AbstractBaseRedisDao<String, Object> implements RedisObjectDAO {

	@Override
	public boolean add(final StoreObject storeObject) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(storeObject.getId());
				byte[] name = SerializeUtil.serialize(storeObject);
				return connection.setNX(key, name);
			}
		});
		return result;
	}
    @Override
    public void set(final StoreObject storeObject) {
         redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(storeObject.getId());
                byte[] name = SerializeUtil.serialize(storeObject);
                connection.set(key, name);
                return true;
            }
        });
    }

	public boolean add(final List<StoreObject> list) {
		Assert.notEmpty(list);
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for (StoreObject storeObject : list) {
					byte[] key = serializer.serialize(storeObject.getId());
					byte[] name = SerializeUtil.serialize(storeObject.getObject());
					connection.setNX(key, name);
				}
				return true;
			}
		}, false, true);
		return result;
	}

	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
	}


	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	public boolean update(final StoreObject storeObject) {
		String key = storeObject.getId();
		if (get(key) == null) {
			throw new NullPointerException("数据行不存在, key = " + key);
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(storeObject.getId());
				byte[] name = SerializeUtil.serialize(storeObject);
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	public StoreObject get(final String keyId) {
		StoreObject result = redisTemplate.execute(new RedisCallback<StoreObject>() {
			public StoreObject doInRedis(RedisConnection connection)throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				StoreObject object = (StoreObject) SerializeUtil
						.unserialize(value);
				return object;
			}
		});
		return result;
	}
	
	public void expire(String key,long timeout){
		redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}
	
}
