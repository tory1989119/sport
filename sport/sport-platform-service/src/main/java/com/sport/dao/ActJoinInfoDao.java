package com.sport.dao;

import java.util.List;

import com.sport.model.ActJoinInfo;

public interface ActJoinInfoDao{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActJoinInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findPage(ActJoinInfo actJoinInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActJoinInfo actJoinInfo) throws Exception;
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
	 * @param actJoinInfo
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
