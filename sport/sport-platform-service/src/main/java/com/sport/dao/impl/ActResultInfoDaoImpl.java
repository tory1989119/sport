package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ActResultInfoDao;
import com.sport.mapper.ActResultInfoMapper;
import com.sport.model.ActResultInfo;

@Repository
public class ActResultInfoDaoImpl implements ActResultInfoDao {
	
	@Autowired
	private ActResultInfoMapper actResultInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActResultInfo findByPK(long pk) throws Exception {
		return actResultInfoMapper.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findAll() throws Exception {
		return actResultInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findPage(ActResultInfo actResultInfo) throws Exception {
		return actResultInfoMapper.findPage(actResultInfo);
	}
	/**
	 * 对象记录数
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActResultInfo actResultInfo) throws Exception {
		return actResultInfoMapper.count(actResultInfo);
	}
	/**
	 * 保存对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void save(ActResultInfo actResultInfo) throws Exception {
		actResultInfoMapper.save(actResultInfo);
	}
	/**
	 * 更新对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void update(ActResultInfo actResultInfo) throws Exception {
		actResultInfoMapper.update(actResultInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void delete(ActResultInfo actResultInfo) throws Exception {
		actResultInfoMapper.delete(actResultInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		actResultInfoMapper.deleteByPK(pk);
	}
	
}
