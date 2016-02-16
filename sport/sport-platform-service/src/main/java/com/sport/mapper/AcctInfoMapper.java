package com.sport.mapper;

import java.util.List;

import com.sport.model.AcctInfo;



public interface AcctInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctInfo findByPK(AcctInfo acctInfo) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findPage(AcctInfo acctInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public int count(AcctInfo acctInfo) throws Exception;


	/**
	 * 保存对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void save(AcctInfo acctInfo) throws Exception;


	/**
	 * 更新对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void update(AcctInfo acctInfo) throws Exception;


	/**
	 * 根据条件删除对象
	 * @param acctInfo
	 * @throws Exception
	 */
	public void delete(AcctInfo acctInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(AcctInfo acctInfo) throws Exception;
	
	/**
	 * 登录
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public AcctInfo login(AcctInfo acctInfo) throws Exception;
	
	/**
	 * 校验登录名
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public int checkUsername(AcctInfo acctInfo) throws Exception;
}
