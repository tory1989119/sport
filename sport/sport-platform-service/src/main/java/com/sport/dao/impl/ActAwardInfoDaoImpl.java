package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ActAwardInfoDao;
import com.sport.mapper.ActAwardInfoMapper;
import com.sport.model.ActAwardInfo;

@Repository
public class ActAwardInfoDaoImpl implements ActAwardInfoDao {
	
	@Autowired
	private ActAwardInfoMapper actAwardInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActAwardInfo findByPK(long pk) throws Exception {
		return actAwardInfoMapper.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findAll() throws Exception {
		return actAwardInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findPage(ActAwardInfo actAwardInfo) throws Exception {
		return actAwardInfoMapper.findPage(actAwardInfo);
	}
	/**
	 * 对象记录数
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActAwardInfo actAwardInfo) throws Exception {
		return actAwardInfoMapper.count(actAwardInfo);
	}
	/**
	 * 保存对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void save(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoMapper.save(actAwardInfo);
	}
	/**
	 * 更新对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void update(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoMapper.update(actAwardInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void delete(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoMapper.delete(actAwardInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		actAwardInfoMapper.deleteByPK(pk);
	}
}
