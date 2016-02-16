package com.sport.service.interf;

import java.util.List;

import com.sport.model.ActBaseInfo;

public interface IActBaseInfoService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActBaseInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActBaseInfo> findPage(ActBaseInfo actBaseInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param actBaseInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActBaseInfo actBaseInfo) throws Exception;
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
	 * @param actBaseInfo
	 * @throws Exception
	 */
	public void delete(ActBaseInfo actBaseInfo) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
