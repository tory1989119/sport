package com.sport.mapper;

import java.util.List;

import com.sport.model.CustComInfo;

public interface CustComInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByPK(CustComInfo custComInfo) throws Exception;
	
	/**
	 * 根据账号查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComInfo findByACCTID(CustComInfo custComInfo) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustComInfo> findPage(CustComInfo custComInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param custComInfo
	 * @return
	 * @throws Exception
	 */
	public int count(CustComInfo custComInfo) throws Exception;


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
	 * @param CustComInfo
	 * @throws Exception
	 */
	public void delete(CustComInfo custComInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(CustComInfo custComInfo) throws Exception;
}
