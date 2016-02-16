package com.sport.dao;

import java.util.List;

import com.sport.model.CustComApply;

public interface CustComApplyDao{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComApply findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findPage(CustComApply custComApply) throws Exception;
	/**
	 * 对象记录数
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComApply custComApply) throws Exception;
	/**
	 * 保存对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void save(CustComApply custComApply) throws Exception;
	/**
	 * 更新对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void update(CustComApply custComApply) throws Exception;
	/**
	 * 根据条件删除对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void delete(CustComApply custComApply) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
