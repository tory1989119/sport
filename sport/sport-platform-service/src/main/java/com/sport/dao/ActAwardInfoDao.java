package com.sport.dao;

import java.util.List;

import com.sport.model.ActAwardInfo;


public interface ActAwardInfoDao{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActAwardInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findPage(ActAwardInfo actAwardInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActAwardInfo actAwardInfo) throws Exception;
	/**
	 * 保存对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void save(ActAwardInfo actAwardInfo) throws Exception;
	/**
	 * 更新对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void update(ActAwardInfo actAwardInfo) throws Exception;
	/**
	 * 根据条件删除对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	public void delete(ActAwardInfo actAwardInfo) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
