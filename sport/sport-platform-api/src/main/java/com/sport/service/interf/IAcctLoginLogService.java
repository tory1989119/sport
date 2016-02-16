package com.sport.service.interf;

import java.util.List;

import com.sport.model.AcctLoginLog;

public interface IAcctLoginLogService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctLoginLog findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findPage(AcctLoginLog acctLoginLog) throws Exception;
	/**
	 * 对象记录数
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctLoginLog acctLoginLog) throws Exception;
	/**
	 * 保存对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void save(AcctLoginLog acctLoginLog) throws Exception;
	/**
	 * 更新对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void update(AcctLoginLog acctLoginLog) throws Exception;
	/**
	 * 根据条件删除对象
	 * @param acctLoginLog
	 * @throws Exception
	 */
	public void delete(AcctLoginLog acctLoginLog) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
