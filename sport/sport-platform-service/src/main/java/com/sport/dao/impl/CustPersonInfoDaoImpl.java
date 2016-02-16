package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.CustPersonInfoDao;
import com.sport.mapper.CustPersonInfoMapper;
import com.sport.model.CustPersonInfo;


@Repository
public class CustPersonInfoDaoImpl implements CustPersonInfoDao {
	
	@Autowired
	private CustPersonInfoMapper custPersonInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByPK(long pk) throws Exception {
		CustPersonInfo custPersonInfo= new CustPersonInfo();
		custPersonInfo.setId(pk);
		return custPersonInfoMapper.findByPK(custPersonInfo);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findAll() throws Exception {
		return custPersonInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findPage(CustPersonInfo custPersonInfo) throws Exception {
		return custPersonInfoMapper.findPage(custPersonInfo);
	}
	/**
	 * 对象记录数
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustPersonInfo custPersonInfo) throws Exception {
		return custPersonInfoMapper.count(custPersonInfo);
	}
	/**
	 * 保存对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void save(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoMapper.save(custPersonInfo);
	}
	/**
	 * 更新对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void update(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoMapper.update(custPersonInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void delete(CustPersonInfo custPersonInfo) throws Exception {
		custPersonInfoMapper.delete(custPersonInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		CustPersonInfo custPersonInfo= new CustPersonInfo();
		custPersonInfo.setId(pk);
		custPersonInfoMapper.deleteByPK(custPersonInfo);
	}
	/**
	 * 根据账号查找对象
	 * @param acct_id
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByACCTID(long acctId) throws Exception {
		CustPersonInfo custPersonInfo= new CustPersonInfo();
		custPersonInfo.setAcctId(acctId);
		return custPersonInfoMapper.findByACCTID(custPersonInfo);
	}
	
}
