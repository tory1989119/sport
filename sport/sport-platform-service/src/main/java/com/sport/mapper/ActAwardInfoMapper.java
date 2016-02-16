package com.sport.mapper;

import java.util.List;

import com.sport.model.ActAwardInfo;

public interface ActAwardInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActAwardInfo findByPK(long pk) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findPage(ActAwardInfo actAwardInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public int count(ActAwardInfo actAwardInfo) throws Exception;


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
	 * @param ActAwardInfo
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
