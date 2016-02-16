package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.ActBaseInfoDao;
import com.sport.model.ActBaseInfo;
import com.sport.service.interf.IActBaseInfoService;


@Service("actBaseInfoService")
@Transactional(readOnly = true)
public class ActBaseInfoServiceImpl implements IActBaseInfoService {
	
	@Autowired
	private ActBaseInfoDao actBaseInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActBaseInfo findByPK(long pk) throws Exception {
		return actBaseInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findAll() throws Exception {
		return actBaseInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findPage(ActBaseInfo actBaseInfo) throws Exception {
		return actBaseInfoDao.findPage(actBaseInfo);
	}
	/**
	 * 对象记录数
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActBaseInfo actBaseInfo) throws Exception {
		return actBaseInfoDao.count(actBaseInfo);
	}
	/**
	 * 保存对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoDao.save(actBaseInfo);
	}
	/**
	 * 更新对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoDao.update(actBaseInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(ActBaseInfo actBaseInfo) throws Exception {
		actBaseInfoDao.delete(actBaseInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		actBaseInfoDao.deleteByPK(pk);
	}
	
}
