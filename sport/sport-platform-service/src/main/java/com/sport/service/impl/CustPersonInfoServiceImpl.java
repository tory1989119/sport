package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.CustPersonInfoDao;
import com.sport.model.CustPersonInfo;
import com.sport.service.interf.ICustPersonInfoService;


@Service("custPersonInfoService")
@Transactional(readOnly = true)
public class CustPersonInfoServiceImpl implements ICustPersonInfoService {
	
	@Autowired
	private CustPersonInfoDao custPersonInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByPK(long pk) throws Exception {
		return custPersonInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findAll() throws Exception {
		return custPersonInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findPage(CustPersonInfo custPersonInfo) throws Exception {
		return custPersonInfoDao.findPage(custPersonInfo);
	}
	/**
	 * 对象记录数
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustPersonInfo custPersonInfo) throws Exception {
		return custPersonInfoDao.count(custPersonInfo);
	}
	/**
	 * 保存对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoDao.save(custPersonInfo);
	}
	/**
	 * 更新对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoDao.update(custPersonInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoDao.delete(custPersonInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		custPersonInfoDao.deleteByPK(pk);
	}
	/**
	 * 根据账号查找对象
	 * @param acct_id
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByACCTID(long acct_id) throws Exception {
		return custPersonInfoDao.findByACCTID(acct_id);
	}
	
}
