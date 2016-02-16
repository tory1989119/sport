package com.sport.mapper;

import java.util.List;

import com.sport.model.CustComApply;



public interface CustComApplyMapper{
	/**
	 * 根据主键查询对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComApply findByPK(CustComApply custComApply) throws Exception;


	/**
	 * 查询所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findAll() throws Exception;


	/**
	 * 查询对象
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findPage(CustComApply custComApply) throws Exception;


	/**
	 * 统计对象记录数
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public int count(CustComApply custComApply) throws Exception;


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
	public void deleteByPK(CustComApply custComApply) throws Exception;
}
