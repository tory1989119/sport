package com.sport.mapper;

import java.util.List;

import com.sport.model.CustPersonInfo;



public interface CustPersonInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByPK(CustPersonInfo custPersonInfo) throws Exception;
	
	/**
	 * 根据账号查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByACCTID(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findPage(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public int count(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 保存对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void save(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 更新对象
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void update(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 根据条件删除对象
	 * @param CustPersonInfo
	 * @throws Exception
	 */
	public void delete(CustPersonInfo custPersonInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(CustPersonInfo custPersonInfo) throws Exception;
}
