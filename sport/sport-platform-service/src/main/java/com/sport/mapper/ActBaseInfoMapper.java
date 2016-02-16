package com.sport.mapper;

import java.util.List;

import com.sport.model.ActBaseInfo;

public interface ActBaseInfoMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActBaseInfo findByPK(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findAll() throws Exception;


	/**
	 * 查询所有对象
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findPage(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 统计对象记录数
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public int count(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 保存对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void save(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 更新对象
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void update(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 根据条件删除对象
	 * @param ActBaseInfo
	 * @throws Exception
	 */
	public void delete(ActBaseInfo actBaseInfo) throws Exception;


	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(ActBaseInfo actBaseInfo) throws Exception;
}
