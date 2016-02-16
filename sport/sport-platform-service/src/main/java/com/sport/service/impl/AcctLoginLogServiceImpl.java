package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.AcctLoginLogDao;
import com.sport.model.AcctLoginLog;
import com.sport.service.interf.IAcctLoginLogService;


@Service("acctLoginLogService")
@Transactional(readOnly = true)
public class AcctLoginLogServiceImpl implements IAcctLoginLogService {
	
	@Autowired
	private AcctLoginLogDao acctLoginLogDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctLoginLog findByPK(long pk) throws Exception {
		return acctLoginLogDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findAll() throws Exception {
		return acctLoginLogDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findPage(AcctLoginLog acctLoginLog) throws Exception {
		return acctLoginLogDao.findPage(acctLoginLog);
	}
	/**
	 * 对象记录数
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctLoginLog acctLoginLog) throws Exception {
		return acctLoginLogDao.count(acctLoginLog);
	}
	/**
	 * 保存对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogDao.save(acctLoginLog);
	}
	/**
	 * 更新对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogDao.update(acctLoginLog);
	}
	/**
	 * 根据条件删除对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(AcctLoginLog acctLoginLog) throws Exception {
		acctLoginLogDao.delete(acctLoginLog);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		acctLoginLogDao.deleteByPK(pk);
	}
	
}
