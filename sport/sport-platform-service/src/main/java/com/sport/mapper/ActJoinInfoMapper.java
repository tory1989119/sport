package com.sport.mapper;

import java.util.List;

import com.sport.model.ActJoinInfo;

public interface ActJoinInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActJoinInfo findByPK(long pk) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findPage(ActJoinInfo actJoinInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public int count(ActJoinInfo actJoinInfo) throws Exception;


	/**
	 * 保存对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	public void save(ActJoinInfo actJoinInfo) throws Exception;


	/**
	 * 更新对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	public void update(ActJoinInfo actJoinInfo) throws Exception;


	/**
	 * 根据条件删除对象
	 * @param ActJoinInfo
	 * @throws Exception
	 */
	public void delete(ActJoinInfo actJoinInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
