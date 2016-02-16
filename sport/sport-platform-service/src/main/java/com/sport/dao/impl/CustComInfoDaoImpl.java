package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.CustComInfoDao;
import com.sport.mapper.CustComInfoMapper;
import com.sport.model.CustComInfo;

@Repository
public class CustComInfoDaoImpl implements CustComInfoDao {
	
	@Autowired
	private CustComInfoMapper custComInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByPK(long pk) throws Exception {
		CustComInfo custComInfo = new CustComInfo();
		custComInfo.setId(pk);
		return custComInfoMapper.findByPK(custComInfo);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findAll() throws Exception {
		return custComInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findPage(CustComInfo custComInfo) throws Exception {
		return custComInfoMapper.findPage(custComInfo);
	}
	/**
	 * 对象记录数
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComInfo custComInfo) throws Exception {
		return custComInfoMapper.count(custComInfo);
	}
	/**
	 * 保存对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void save(CustComInfo custComInfo) throws Exception {
		custComInfoMapper.save(custComInfo);
	}
	/**
	 * 更新对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void update(CustComInfo custComInfo) throws Exception {
		custComInfoMapper.update(custComInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void delete(CustComInfo custComInfo) throws Exception {
		custComInfoMapper.delete(custComInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		CustComInfo custComInfo = new CustComInfo();
		custComInfo.setId(pk);
		custComInfoMapper.deleteByPK(custComInfo);
	}
	/**
	 * 根据账号查找对象
	 * @param acct_id
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByACCTID(long acctId) throws Exception {
		CustComInfo custComInfo = new CustComInfo();
		custComInfo.setAcctId(acctId);
		return custComInfoMapper.findByACCTID(custComInfo);
	}
	
}
