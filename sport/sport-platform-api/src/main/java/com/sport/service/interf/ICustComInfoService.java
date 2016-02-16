package com.sport.service.interf;

import java.util.List;

import com.sport.model.CustComInfo;

public interface ICustComInfoService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByPK(long pk) throws Exception;
	/**
	 * 根据账号查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByACCTID(long acct_id) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findPage(CustComInfo custComInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComInfo custComInfo) throws Exception;
	/**
	 * 保存对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void save(CustComInfo custComInfo) throws Exception;
	/**
	 * 更新对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void update(CustComInfo custComInfo) throws Exception;
	/**
	 * 根据条件删除对象
	 * @param custComInfo
	 * @throws Exception
	 */
	public void delete(CustComInfo custComInfo) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
