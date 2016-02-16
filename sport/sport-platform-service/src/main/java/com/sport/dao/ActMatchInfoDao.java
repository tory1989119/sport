package com.sport.dao;

import java.util.List;

import com.sport.model.ActMatchInfo;

public interface ActMatchInfoDao{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActMatchInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findPage(ActMatchInfo actMatchInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActMatchInfo actMatchInfo) throws Exception;
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
	 * @param actMatchInfo
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
