package com.sport.mapper;

import java.util.List;

import com.sport.model.ActMatchInfo;


public interface ActMatchInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActMatchInfo findByPK(long pk) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findPage(ActMatchInfo actMatchInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public int count(ActMatchInfo actMatchInfo) throws Exception;


	/**
	 * 保存对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	public void save(ActMatchInfo actMatchInfo) throws Exception;


	/**
	 * 更新对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	public void update(ActMatchInfo actMatchInfo) throws Exception;


	/**
	 * 根据条件删除对象
	 * @param ActMatchInfo
	 * @throws Exception
	 */
	public void delete(ActMatchInfo actMatchInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
