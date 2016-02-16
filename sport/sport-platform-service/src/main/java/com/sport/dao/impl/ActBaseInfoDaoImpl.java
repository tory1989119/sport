package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ActBaseInfoDao;
import com.sport.mapper.ActBaseInfoMapper;
import com.sport.model.ActBaseInfo;


@Repository
public class ActBaseInfoDaoImpl implements ActBaseInfoDao {
	
	@Autowired
	private ActBaseInfoMapper actBaseInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActBaseInfo findByPK(long pk) throws Exception {
		ActBaseInfo actBaseInfo = new ActBaseInfo();
		actBaseInfo.setId(pk);
		return actBaseInfoMapper.findByPK(actBaseInfo);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findAll() throws Exception {
		return actBaseInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findPage(ActBaseInfo actBaseInfo) throws Exception {
		return actBaseInfoMapper.findPage(actBaseInfo);
	}
	/**
	 * 对象记录数
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActBaseInfo actBaseInfo) throws Exception {
		return actBaseInfoMapper.count(actBaseInfo);
	}
	/**
	 * 保存对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void save(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoMapper.save(actBaseInfo);
	}
	/**
	 * 更新对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void update(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoMapper.update(actBaseInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void delete(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoMapper.delete(actBaseInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		ActBaseInfo actBaseInfo = new ActBaseInfo();
		actBaseInfo.setId(pk);
		actBaseInfoMapper.deleteByPK(actBaseInfo);
	}
	
}
