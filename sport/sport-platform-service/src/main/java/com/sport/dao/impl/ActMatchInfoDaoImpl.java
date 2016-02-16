package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ActMatchInfoDao;
import com.sport.mapper.ActMatchInfoMapper;
import com.sport.model.ActMatchInfo;

@Repository
public class ActMatchInfoDaoImpl implements ActMatchInfoDao {
	
	@Autowired
	private ActMatchInfoMapper actMatchInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActMatchInfo findByPK(long pk) throws Exception {
		return actMatchInfoMapper.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findAll() throws Exception {
		return actMatchInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findPage(ActMatchInfo actMatchInfo) throws Exception {
		return actMatchInfoMapper.findPage(actMatchInfo);
	}
	/**
	 * 对象记录数
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActMatchInfo actMatchInfo) throws Exception {
		return actMatchInfoMapper.count(actMatchInfo);
	}
	/**
	 * 保存对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	public void save(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoMapper.save(actMatchInfo);
	}
	/**
	 * 更新对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	public void update(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoMapper.update(actMatchInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	public void delete(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoMapper.delete(actMatchInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		actMatchInfoMapper.deleteByPK(pk);
	}
	
}
