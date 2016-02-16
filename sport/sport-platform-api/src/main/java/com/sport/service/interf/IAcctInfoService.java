package com.sport.service.interf;

import java.util.List;

import com.sport.model.AcctInfo;

public interface IAcctInfoService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findPage(AcctInfo acctInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctInfo acctInfo) throws Exception;
	/**
	 * 注册
	 * @param acctInfo
	 * @throws Exception
	 */
	public void regist(AcctInfo acctInfo) throws Exception;
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
	public void deleteByPK(long pk) throws Exception;
	
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
	public Integer checkUsername(AcctInfo acctInfo) throws Exception;
}
