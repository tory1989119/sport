package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.AcctInfoDao;
import com.sport.mapper.AcctInfoMapper;
import com.sport.model.AcctInfo;


@Repository
public class AcctInfoDaoImpl implements AcctInfoDao {
	
	@Autowired
	private AcctInfoMapper acctInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctInfo findByPK(long pk) throws Exception {
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setId(pk);
		return acctInfoMapper.findByPK(acctInfo);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findAll() throws Exception {
		return acctInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findPage(AcctInfo acctInfo) throws Exception {
		return acctInfoMapper.findPage(acctInfo);
	}
	/**
	 * 对象记录数
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctInfo acctInfo) throws Exception {
		return acctInfoMapper.count(acctInfo);
	}
	/**
	 * 保存对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void save(AcctInfo acctInfo) throws Exception {
		acctInfoMapper.save(acctInfo);
	}
	/**
	 * 更新对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void update(AcctInfo acctInfo) throws Exception {
		acctInfoMapper.update(acctInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void delete(AcctInfo acctInfo) throws Exception {
		acctInfoMapper.delete(acctInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setId(pk);
		acctInfoMapper.deleteByPK(acctInfo);
	}
	
	/**
	 * 登录
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public AcctInfo login(AcctInfo acctInfo) throws Exception {
		return acctInfoMapper.login(acctInfo);
	}
	
	/**
	 * 校验登录名
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public Integer checkUsername(AcctInfo acctInfo) throws Exception {
		return acctInfoMapper.checkUsername(acctInfo);
	}
}
