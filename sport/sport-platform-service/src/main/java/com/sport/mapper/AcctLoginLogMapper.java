package com.sport.mapper;

import java.util.List;

import com.sport.model.AcctLoginLog;



public interface AcctLoginLogMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctLoginLog findByPK(AcctLoginLog acctLoginLog) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public List<AcctLoginLog> findPage(AcctLoginLog acctLoginLog) throws Exception;


	/**
	 * 统计对象记录数
	 * @param acctLoginLog
	 * @return
	 * @throws Exception
	 */
	public int count(AcctLoginLog acctLoginLog) throws Exception;


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
	public void deleteByPK(AcctLoginLog acctLoginLog) throws Exception;
}
