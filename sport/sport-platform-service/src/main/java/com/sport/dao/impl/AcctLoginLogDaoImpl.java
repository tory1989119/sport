package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.AcctLoginLogDao;
import com.sport.mapper.AcctLoginLogMapper;
import com.sport.model.AcctLoginLog;


@Repository
public class AcctLoginLogDaoImpl implements AcctLoginLogDao {
	
	@Autowired
	private AcctLoginLogMapper acctLoginLogMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctLoginLog findByPK(long pk) throws Exception {
		AcctLoginLog acctLoginLog = new AcctLoginLog();
		acctLoginLog.setId(pk);
		return acctLoginLogMapper.findByPK(acctLoginLog);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findAll() throws Exception {
		return acctLoginLogMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findPage(AcctLoginLog acctLoginLog) throws Exception {
		return acctLoginLogMapper.findPage(acctLoginLog);
	}
	/**
	 * 对象记录数
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctLoginLog acctLoginLog) throws Exception {
		return acctLoginLogMapper.count(acctLoginLog);
	}
	/**
	 * 保存对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void save(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogMapper.save(acctLoginLog);
	}
	/**
	 * 更新对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void update(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogMapper.update(acctLoginLog);
	}
	/**
	 * 根据条件删除对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void delete(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogMapper.delete(acctLoginLog);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		AcctLoginLog acctLoginLog = new AcctLoginLog();
		acctLoginLog.setId(pk);
		acctLoginLogMapper.deleteByPK(acctLoginLog);
	}
	
}
