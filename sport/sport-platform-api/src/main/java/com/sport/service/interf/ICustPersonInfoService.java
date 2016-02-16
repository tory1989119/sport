package com.sport.service.interf;

import java.util.List;

import com.sport.model.CustPersonInfo;

public interface ICustPersonInfoService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByPK(long pk) throws Exception;
	/**
	 * 根据账号查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustPersonInfo findByACCTID(long acct_id) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public List<CustPersonInfo> findPage(CustPersonInfo custPersonInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param custPersonInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustPersonInfo custPersonInfo) throws Exception;
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
	 * @param custPersonInfo
	 * @throws Exception
	 */
	public void delete(CustPersonInfo custPersonInfo) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
