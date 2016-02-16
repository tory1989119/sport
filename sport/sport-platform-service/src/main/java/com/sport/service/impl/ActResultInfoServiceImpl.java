package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.ActResultInfoDao;
import com.sport.model.ActResultInfo;
import com.sport.service.interf.IActResultInfoService;


@Service("actResultInfoService")
@Transactional(readOnly = true)
public class ActResultInfoServiceImpl implements IActResultInfoService {
	
	@Autowired
	private ActResultInfoDao actResultInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActResultInfo findByPK(long pk) throws Exception {
		return actResultInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findAll() throws Exception {
		return actResultInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findPage(ActResultInfo actResultInfo) throws Exception {
		return actResultInfoDao.findPage(actResultInfo);
	}
	/**
	 * 对象记录数
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActResultInfo actResultInfo) throws Exception {
		return actResultInfoDao.count(actResultInfo);
	}
	/**
	 * 保存对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActResultInfo actResultInfo) throws Exception {
		actResultInfoDao.save(actResultInfo);
	}
	/**
	 * 更新对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(ActResultInfo actResultInfo) throws Exception {
		actResultInfoDao.update(actResultInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(ActResultInfo actResultInfo) throws Exception {
		actResultInfoDao.delete(actResultInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		actResultInfoDao.deleteByPK(pk);
	}
	
}
