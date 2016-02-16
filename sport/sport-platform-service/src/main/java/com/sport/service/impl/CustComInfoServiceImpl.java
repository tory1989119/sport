package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.CustComInfoDao;
import com.sport.model.CustComInfo;
import com.sport.service.interf.ICustComInfoService;

@Service("custComInfoService")
@Transactional(readOnly = true)
public class CustComInfoServiceImpl implements ICustComInfoService {
	
	@Autowired
	private CustComInfoDao custComInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByPK(long pk) throws Exception {
		return custComInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findAll() throws Exception {
		return custComInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findPage(CustComInfo custComInfo) throws Exception {
		return custComInfoDao.findPage(custComInfo);
	}
	/**
	 * 对象记录数
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComInfo custComInfo) throws Exception {
		return custComInfoDao.count(custComInfo);
	}
	/**
	 * 保存对象
	 * @param custComInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(CustComInfo custComInfo) throws Exception {
		custComInfoDao.save(custComInfo);
	}
	/**
	 * 更新对象
	 * @param custComInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(CustComInfo custComInfo) throws Exception {
		custComInfoDao.update(custComInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param custComInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(CustComInfo custComInfo) throws Exception {
		custComInfoDao.delete(custComInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		custComInfoDao.deleteByPK(pk);
	}
	/**
	 * 根据账号查找对象
	 * @param acct_id
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByACCTID(long acct_id) throws Exception {
		return custComInfoDao.findByACCTID(acct_id);
	}
	
}
